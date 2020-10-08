package net.mikej.connectors.reddit.api.connection;

import org.mule.runtime.api.store.ObjectStore;

import net.mikej.connectors.reddit.api.FixedSizeList;

public class RedditClient {
  private final RedditService service;
  private final ObjectStore<FixedSizeList<String>> objectStore;

  public RedditClient(final RedditService redditService, final ObjectStore<FixedSizeList<String>> objectStore) {
    this.service = redditService;
    this.objectStore = objectStore;
  }

  public RedditService redditService() {
    return service;
  }

  public ObjectStore<FixedSizeList<String>> objectStore() {
    return objectStore;
  }
}