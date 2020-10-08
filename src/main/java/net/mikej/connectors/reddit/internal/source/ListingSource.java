package net.mikej.connectors.reddit.internal.source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import net.mikej.connectors.reddit.api.FixedSizeList;
import org.mule.runtime.api.scheduler.Scheduler;
import org.mule.runtime.api.scheduler.SchedulerService;
import org.mule.runtime.api.store.ObjectStore;
import org.mule.runtime.api.store.ObjectStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.mikej.connectors.reddit.api.things.Thing;

public abstract class ListingSource<T extends Thing> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ListingSource.class);

  private final int updateFrequency;
  private final int maxCatchupPages;
  private final boolean shouldCatchUp;
  private final Scheduler scheduler;
  private final ObjectStore<FixedSizeList<String>> objectStore;

  private FixedSizeList<String> seenThings;
  private ScheduledFuture<?> scheduledFuture;

  public ListingSource(final int updateFrequency,
      final boolean shouldCatchUp, final int maxCatchupPages, final ObjectStore<FixedSizeList<String>> objectStore,
      final SchedulerService schedulerService) {

    this.updateFrequency = updateFrequency;
    this.shouldCatchUp = shouldCatchUp;
    this.maxCatchupPages = maxCatchupPages;
    this.seenThings = new FixedSizeList<String>(200 * maxCatchupPages);
    this.scheduler = schedulerService.ioScheduler();
    this.objectStore = objectStore;
  }

  public void start() {
    this.scheduledFuture = this.scheduler.scheduleWithFixedDelay(new Runnable() {
      @Override
      public void run() {
        try {
          if (seenThings.size() == 0)
            initialize();
          else {
            List<T> newThings = getNewThings();
            if (newThings.size() > 0) {
              handleNewThings(newThings);
              if (shouldCatchUp) {
                updateObjectStore();
              }
            }
          }
        } catch (Exception ex) {
          LOGGER.error("An error occurred in ListingSource runnable", ex);
        }
      }
    }, updateFrequency, updateFrequency, TimeUnit.MILLISECONDS);
  }

  public void stop() {
    this.scheduledFuture.cancel(true);
    this.scheduler.stop();
  }

  private void initialize() throws IOException, ObjectStoreException {
    if (shouldCatchUp) {
      if (objectStore.contains(objectStoreKey())) {
        seenThings = objectStore.retrieve(objectStoreKey());
        return;
      }
    }

    T[] things = getThings(null, null);
    if (things.length == 0)
      return;
    for (int i = things.length; i-- > 0;) {
      seenThings.add(things[i].getName());
    }
    if (shouldCatchUp) {
      updateObjectStore();
    }
  }

  private List<T> getNewThings() throws IOException {
    List<T> newThings = new ArrayList<T>();
    String after = null;
    int pages = 0;

    while (pages * 100 == newThings.size()) {
      if (pages++ > maxCatchupPages)
        break;

      T[] things = getThings(after, null);
      if (things.length > 0) {
        for (int i = things.length; i-- > 0;) {
          T thing = things[i];
          if (!seenThings.contains(thing.getName())) {
            newThings.add(thing);
            seenThings.add(thing.getName());
          }
        }
      }
    }
    return newThings;
  }

  private void updateObjectStore() throws ObjectStoreException {
    if (objectStore.contains(objectStoreKey()))
      objectStore.remove(objectStoreKey());
    objectStore.store(objectStoreKey(), seenThings);
  }

  protected abstract T[] getThings(String after, String before) throws IOException;

  protected abstract String objectStoreKey();

  protected abstract void handleNewThings(List<T> things);
}