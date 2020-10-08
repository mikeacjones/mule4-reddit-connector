package net.mikej.connectors.reddit.internal.source;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import net.mikej.connectors.reddit.api.FixedSizeList;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.api.scheduler.SchedulerService;
import org.mule.runtime.api.store.ObjectStore;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.source.Source;
import org.mule.runtime.extension.api.runtime.source.SourceCallback;

import net.mikej.connectors.reddit.api.connection.RedditService;
import net.mikej.connectors.reddit.api.things.Comment;
import net.mikej.connectors.reddit.api.things.Listing;
import retrofit2.Call;
import retrofit2.Response;

@Alias(value = "new-comment-listener", description = "Listener for new comments.")
@DisplayName("On New Comment")
public class CommentSource extends Source<List<Comment>, Void> {

  private RedditService redditService;
  private ListingSource<Comment> commentSource;

  @Inject
  private SchedulerService schedulerService;

  @Connection
  private ConnectionProvider<RedditService> redditConnectionProvider;

  @Parameter
  @DisplayName("Monitored subreddit")
  @Optional(defaultValue = "all")
  private String subreddit = "all";

  @Parameter
  @DisplayName("Update frequency (milliseconds)")
  @Optional(defaultValue = "2000")
  private int updateFrequency;

  @Parameter
  @DisplayName("Persist last processed")
  @Optional(defaultValue = "false")
  private boolean shouldCatchUp;

  @Parameter
  @DisplayName("Max catchup pages (100 items per page)")
  @Optional(defaultValue = "5")
  private int maxCatchupPages;

  @Parameter
  @DisplayName("ObjectStore for Persistence")
  private ObjectStore<FixedSizeList<String>> objectStore;


  @Override
  public void onStart(SourceCallback<List<Comment>, Void> sourceCallback) throws MuleException {
    this.redditService = redditConnectionProvider.connect();
    
    commentSource = new ListingSource<Comment>(updateFrequency, shouldCatchUp, maxCatchupPages, objectStore,
        schedulerService) {

      @Override
      protected String objectStoreKey() {
        return String.format("CommentSource_%s", subreddit);
      }

      @Override
      protected void handleNewThings(List<Comment> things) {
        sourceCallback.handle(Result.<List<Comment>, Void>builder().output(things).build());
      }

      @Override
      protected Comment[] getThings(String after, String before) throws IOException {
        Call<Listing<Comment>> commentListingCall = redditService.getComments(subreddit, 100, null, before);
        Response<Listing<Comment>> commentListingResponse = commentListingCall.execute();
        if (commentListingResponse.isSuccessful()) {
          Listing<Comment> commentListing = commentListingResponse.body();
          if (commentListing.getData().getDist() == 0)
            return new Comment[0];
          return Arrays.stream(commentListing.getData().getChildren()).map(item -> item.getData())
              .collect(Collectors.toList()).toArray(new Comment[commentListing.getData().getDist()]);
        } else throw new IOException("Comment source API polling failed\r\n" + commentListingResponse.errorBody());
      }
    };
    commentSource.start();
  }

  @Override
  public void onStop() {
    commentSource.stop();
  }
}