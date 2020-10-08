package net.mikej.connectors.reddit.internal.operations;

import java.io.IOException;

import net.mikej.connectors.reddit.api.things.*;
import net.mikej.connectors.reddit.api.things.ModeratorListing.Moderator;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import net.mikej.connectors.reddit.api.connection.RedditService;
import net.mikej.connectors.reddit.api.things.Flair.UserFlair;
import retrofit2.Call;
import retrofit2.Response;

public class RedditOperations {
  @DisplayName("Send Private Message")
  public PostResult<Thing> sendPrivateMessage(@Connection RedditService client, String to, String subject,
      String markdownText) throws IOException {
    Call<PostResult<Thing>> sendMessageCall = client.sendMessage(to, markdownText, subject, "json");
    Response<PostResult<Thing>> sendMessageResponse = sendMessageCall.execute();
    if (!sendMessageResponse.isSuccessful()) {
      throw new IOException("Error occurred while posting comment");
    }
    return sendMessageResponse.body();
  }

  @DisplayName("Get User Information")
  public User getUserInformation(@Connection RedditService client, String username) throws IOException {
    Call<ListingChild<User>> getUserInfoCall = client.getUserInfo(username);
    Response<ListingChild<User>> getUserInfoResponse = getUserInfoCall.execute();
    if (!getUserInfoResponse.isSuccessful())
      throw new IOException("Error occurred while posting comment");
    return getUserInfoResponse.body().getData();
  }

  @DisplayName("Post Comment")
  public Comment comment(@Connection RedditService client, String parentId,
      String markdownText) throws IOException {
    Call<PostResult<ThingsArray<Comment>>> postCommentCall = client.postComment(parentId, markdownText, "json");
    Response<PostResult<ThingsArray<Comment>>> postCommentResponse = postCommentCall.execute();
    if (!postCommentResponse.isSuccessful()) {
      throw new IOException("Error occurred while posting comment");
    }
    if (postCommentResponse.body().getJson().getData().getThings().length == 0) return null;
    return postCommentResponse.body().getJson().getData().getThings()[0].getData();
  }

  @DisplayName("Set User's Subreddit Flair (Simple)")
  public Boolean setSubredditUserFlair(@Connection RedditService client, String subreddit, String username,
      String flairText) throws IOException {
    Call<PostResult<Thing>> setFlairCall = client.setSubredditUserFlair(subreddit, username, flairText, "json");
    Response<PostResult<Thing>> setFlairResponse = setFlairCall.execute();
    if (!setFlairResponse.isSuccessful()) {
      throw new IOException("Error occured while setting user flair");
    }
    return setFlairResponse.body().getJson().getErrors() == null
        || setFlairResponse.body().getJson().getErrors().length == 0;
  }

  @DisplayName("Set User's Subreddit Flair (Extended)")
  public Boolean setSubredditUserFlairExt(@Connection RedditService client, String subreddit, String username,
      @Optional String flairText, @DisplayName("background (Hex, eg: #FF0000)") @Optional String background, @Optional FlairTextColor textColor,
      @Optional String flairTemplateId) throws Exception {
    Call<PostResult<Thing>> setFlairCall = client.setSubredditUserFlairExtended(subreddit, username, flairText,
        background, textColor == null ? null : textColor.getValue(), flairTemplateId, "json");
    Response<PostResult<Thing>> setFlairResponse = setFlairCall.execute();
    if (!setFlairResponse.isSuccessful()) {
      throw new IOException("Error occured while setting user flair");
    }
    return setFlairResponse.body().getJson().getErrors() == null
        || setFlairResponse.body().getJson().getErrors().length == 0;
  }

  @DisplayName("Get User's Subreddit Flair")
  public UserFlair getSubredditUserFlair(@Connection RedditService client, String subreddit, String username)
      throws IOException {
    Call<Flair> getFlairCall = client.getUserFlairForSubreddit(subreddit, username);
    Response<Flair> getFlairResponse = getFlairCall.execute();
    if (!getFlairResponse.isSuccessful()) {
      throw new IOException("Error occurred while getting user flair");
    }
    return getFlairResponse.body().getFlair();
  }

  @DisplayName("Submit Text Post")
  public Thing submitTextPost(@Connection RedditService client, String subreddit, String title,
      String markdownText) throws IOException {
    Call<PostResult<Thing>> submitPostCall = client.submitPost("self", subreddit, title, null, null, null, null,
        null, null, null, markdownText, "json");
    Response<PostResult<Thing>> submitPostResponse = submitPostCall.execute();
    if (!submitPostResponse.isSuccessful()) {
      throw new IOException("Error occurred while submitting text post");
    }
    return submitPostResponse.body().getJson().getData();
  }

  @DisplayName("Update Comment/Text Post")
  public ListingChild<Thing>[] updateThingText(@Connection RedditService client, String thingId, String text)
      throws IOException {
    Call<PostResult<ThingsArray<Thing>>> updateCall = client.updateThingText(thingId, text, "json");
    Response<PostResult<ThingsArray<Thing>>> updateResponse = updateCall.execute();
    if (!updateResponse.isSuccessful()) {
      throw new IOException("Error occurred while updating comment/post");
    }
    return updateResponse.body().getJson().getData().getThings();
  }

  @DisplayName("Get New Posts Listing")
  public Listing<Post> getNewPostsListing(@Connection RedditService client, String subreddit,
      @Optional String before, @Optional String after, @Optional Integer limit) throws IOException {
    Call<Listing<Post>> getListingCall = client.getNewPosts(subreddit, limit, after, before);
    Response<Listing<Post>> getListingResponse = getListingCall.execute();
    if (!getListingResponse.isSuccessful()) {
      throw new IOException("Error occurred while fetching new post listing");
    }
    return getListingResponse.body();
  }

  @DisplayName("Get Hot Posts Listing")
  public Listing<Post> getHotPostListing(@Connection RedditService client, String subreddit,
      @Optional String before, @Optional String after, @Optional Integer limit) throws IOException {
    Call<Listing<Post>> getListingCall = client.getHotPosts(subreddit, limit, after, before);
    Response<Listing<Post>> getListingResponse = getListingCall.execute();
    if (!getListingResponse.isSuccessful()) {
      throw new IOException("Error occurred while fetching new post listing");
    }
    return getListingResponse.body();
  }

  @DisplayName("Get Rising Posts Listing")
  public Listing<Post> getHostPostListing(@Connection RedditService client, String subreddit,
      @Optional String before, @Optional String after, @Optional Integer limit) throws IOException {
    Call<Listing<Post>> getListingCall = client.getRisingPosts(subreddit, limit, after, before);
    Response<Listing<Post>> getListingResponse = getListingCall.execute();
    if (!getListingResponse.isSuccessful()) {
      throw new IOException("Error occurred while fetching new post listing");
    }
    return getListingResponse.body();
  }

  @DisplayName("Get Comments Listing")
  public Listing<Comment> getCommentsListing(@Connection RedditService client, String subreddit,
      @Optional String before, @Optional String after, @Optional Integer limit) throws IOException {
    Call<Listing<Comment>> getListingCall = client.getComments(subreddit, limit, after, before);
    Response<Listing<Comment>> getListingResponse = getListingCall.execute();
    if (!getListingResponse.isSuccessful()) {
      throw new IOException("Error occurred while fetching new post listing");
    }
    return getListingResponse.body();
  }

  @DisplayName("Set Post Sticky")
  public boolean stickySubredditPost(@Connection RedditService client, String thingId, boolean stickied,
      @Optional Integer stickyPosition) throws IOException {
    Call<PostResult<Thing>> stickyPostCall = client.stickySubredditPost(thingId, stickied, stickyPosition,
        "json");
    Response<PostResult<Thing>> stickyPostResponse = stickyPostCall.execute();
    if (!stickyPostResponse.isSuccessful()) {
      return false;
    }
    return stickyPostResponse.body().getJson().getErrors().length == 0;
  }

  @DisplayName("Set Comment/Post Lock Status")
  public boolean lockThing(@Connection RedditService client, String thingId, boolean locked) throws IOException {
    Call<Void> setLockStatusCall = locked ? client.lockThing(thingId) : client.unlockThing(thingId);
    Response<Void> setLockStatusResponse = setLockStatusCall.execute();
    return setLockStatusResponse.isSuccessful();
  }

  @DisplayName("Remove Thing (Moderation)")
  public boolean removeThing(@Connection RedditService client, String thingFullName, boolean isSpam) throws IOException {
    Call<Void> removeThingCall = client.removeThing(thingFullName, isSpam);
    Response<Void> removeThingResponse = removeThingCall.execute();
    return removeThingResponse.isSuccessful();
  }

  @DisplayName("Approve Thing (Moderation)")
  public boolean approveThing(@Connection RedditService client, String thingFullName) throws IOException {
    Call<Void> approveThingCall = client.approveThing(thingFullName);
    Response<Void> approveThingResponse = approveThingCall.execute();
    return approveThingResponse.isSuccessful();
  }

  @DisplayName("Delete My Comment/Post")
  public boolean deleteThing(@Connection RedditService client, String thingId) throws IOException {
    Call<Void> deleteThingCall = client.deleteThing(thingId);
    Response<Void> deleteThingResponse = deleteThingCall.execute();
    if (!deleteThingResponse.isSuccessful()) {
      return false;
    }
    return true;
  }

  @DisplayName("Get Post by Fullname")
  public Post getPost(@Connection RedditService client, String thingId) throws IOException {
    Call<Listing<Post>> getPostCall = client.getPost(thingId);
    Response<Listing<Post>> getPostResponse = getPostCall.execute();
    if (!getPostResponse.isSuccessful()) {
      throw new IOException("Error occurred while getting post");
    }
    if (getPostResponse.body().getData().getDist() > 0)
      return getPostResponse.body().getData().getChildren()[0].getData();
    return null;
  }

  @DisplayName("Get Comment by Fullname")
  public Comment getComment(@Connection RedditService client, String thingId) throws IOException {
    Call<Listing<Comment>> getCommentCall = client.getComment(thingId);
    Response<Listing<Comment>> getCommentResponse = getCommentCall.execute();
    if (!getCommentResponse.isSuccessful()) {
      throw new IOException("Error occurred while getting comment");
    }
    if (getCommentResponse.body().getData().getDist() > 0)
      return getCommentResponse.body().getData().getChildren()[0].getData();
    return null;
  }

  @DisplayName("Get Subreddit Flair Templates")
  public FlairTemplate[] getFlairTempaltes(@Connection RedditService client, String subreddit) throws IOException {
    Call<FlairTemplate[]> getFlairsCall = client.getFlairTemplates(subreddit);
    Response<FlairTemplate[]> getFlairsResponse = getFlairsCall.execute();
    if (!getFlairsResponse.isSuccessful()) {
      throw new IOException("Error occurred while getting comment");
    }
    return getFlairsResponse.body();
  }

  @DisplayName("Get Post Comments")
  public Listing<Comment> getPostComments(@Connection RedditService client, String subreddit, String thingId, int depth, @Optional Sort sort, @Optional Integer limit) throws IOException {
    Call<Listing<Comment>[]> getPostCommentsCall = client.getPostComments(subreddit, thingId, false, depth, sort == null ? null : sort.getSortvalue(), limit);
    Response<Listing<Comment>[]> getPostCommentsResponse = getPostCommentsCall.execute();
    if (!getPostCommentsResponse.isSuccessful()) {
      throw new IOException("Error occurred while getting comments");
    }
    Listing<Comment>[] commentListings = getPostCommentsResponse.body();
    if (commentListings == null || commentListings.length != 2) return null;
    return commentListings[1];
  }

  @DisplayName("Get Subreddit Moderators")
  public Moderator[] getModerators(@Connection RedditService client, String subreddit, @Optional Integer limit, @Optional String after, @Optional String before) throws IOException {
    Call<ModeratorListing> moderatorCall = client.getModerators(subreddit, limit, after, before);
    Response<ModeratorListing> moderatorResponse = moderatorCall.execute();
    if (!moderatorResponse.isSuccessful()) throw new IOException("Error while fetching moderators");
    ModeratorListing listing = moderatorResponse.body();
    return listing.getData().getChildren();
  }
}