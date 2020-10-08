package net.mikej.connectors.reddit.api.connection;

import net.mikej.connectors.reddit.api.things.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface RedditService {

    @GET("/api/v1/me")
    Call<Me> getMe();

    @GET("/api/v1/me")
    Call<Object> getMeDynamic();

    @POST("/api/v1/access_token")
    @FormUrlEncoded
    Call<AccessToken> getToken(@Field("grant_type") final String grantType, @Field("username") final String username,
                               @Field("password") final String password);

    @POST("/api/comment")
    @FormUrlEncoded
    Call<PostResult<ThingsArray<Comment>>> postComment(@Field("thing_id") final String parentId, @Field("text") final String text,
                                                       @Field("api_type") String apiType);

    @GET("/r/{subreddit}/comments/.json")
    Call<Listing<Comment>> getComments(@Path("subreddit") final String subreddit, @Query("limit") final int limit,
                                       @Query("after") final String after, @Query("before") final String before);

    @GET("/r/{subreddit}/new/.json")
    Call<Listing<Post>> getNewPosts(@Path("subreddit") final String subreddit, @Query("limit") final int limit,
                                    @Query("after") final String after, @Query("before") final String before);

    @GET("/r/{subreddit}/rising/.json")
    Call<Listing<Post>> getRisingPosts(@Path("subreddit") final String subreddit, @Query("limit") final int limit,
                                       @Query("after") final String after, @Query("before") final String before);

    @GET("/r/{subreddit}/hot/.json")
    Call<Listing<Post>> getHotPosts(@Path("subreddit") final String subreddit, @Query("limit") final int limit,
                                    @Query("after") final String after, @Query("before") final String before);

    @POST("/api/compose")
    @FormUrlEncoded
    Call<PostResult<Thing>> sendMessage(@Field("to") final String to, @Field("text") final String markdownText,
                                        @Field("subject") final String subject, @Field("api_type") final String json);

    @GET("/user/{username}/about.json")
    Call<ListingChild<User>> getUserInfo(@Path("username") final String username);

    @POST("/r/{subreddit}/api/flair")
    @FormUrlEncoded
    Call<PostResult<Thing>> setSubredditUserFlair(@Path("subreddit") final String subreddit,
                                                  @Field("name") final String username, @Field("text") final String flairText,
                                                  @Field("api_type") final String json);

    @POST("/r/{subreddit}/api/selectflair")
    @FormUrlEncoded
    Call<PostResult<Thing>> setSubredditUserFlairExtended(@Path("subreddit") final String subreddit,
                                                          @Field("name") final String username, @Field("text") final String flairText,
                                                          @Field("background_color") final String background, @Field("text_color") final String textColor, @Field("flair_template_id") final String templateId, @Field("api_type") final String json);

    @GET("/r/{subreddit}/api/flairlist.json")
    Call<Flair> getUserFlairForSubreddit(@Path("subreddit") final String subreddit, @Query("name") final String username);

    @POST("/api/submit")
    @FormUrlEncoded
    Call<PostResult<Thing>> submitPost(@Field("kind") final String kind, @Field("sr") final String subreddit,
                                       @Field("title") final String title, @Field("sendreplies") final Boolean sendReplies,
                                       @Field("nsfw") final Boolean nsfw, @Field("spoiler") final Boolean spoiler, @Field("url") final String url,
                                       @Field("video_poster_url") final String videoPosterUrl, @Field("flair_text") final String flairText,
                                       @Field("resubmit") final Boolean resubmit, @Field("text") final String markdownText,
                                       @Field("api_type") final String json);

    @POST("/api/set_subreddit_sticky")
    @FormUrlEncoded
    Call<PostResult<Thing>> stickySubredditPost(@Field("id") final String thingFullName,
                                                @Field("state") final boolean state, @Field("num") final Integer stickyPosition,
                                                @Field("api_type") final String json);

    @POST("/api/lock")
    @FormUrlEncoded
    Call<Void> lockThing(@Field("id") final String thingFullName);

    @POST("/api/unlock")
    @FormUrlEncoded
    Call<Void> unlockThing(@Field("id") final String thingFullName);

    @POST("/api/del")
    @FormUrlEncoded
    Call<Void> deleteThing(@Field("id") final String thingFullName);

    @POST("/api/editusertext")
    @FormUrlEncoded
    Call<PostResult<ThingsArray<Thing>>> updateThingText(@Field("thing_id") final String thingId,
                                                         @Field("text") final String text, @Field("api_type") final String json);

    @GET("/api/info.json")
    Call<Listing<Post>> getPost(@Query("id") final String fullName);

    @GET("/api/info.json")
    Call<Listing<Comment>> getComment(@Query("id") final String fullName);

    @GET("/r/{subreddit}/api/user_flair_v2")
    Call<FlairTemplate[]> getFlairTemplates(@Path("subreddit") final String subreddit);

    @POST("/api/remove")
    @FormUrlEncoded
    Call<Void> removeThing(@Field("id") final String thingFullName, @Field("spam") final Boolean isSpam);

    @POST("/api/approve")
    @FormUrlEncoded
    Call<Void> approveThing(@Field("id") final String thingFullName);

    @GET("/r/{subreddit}/comments/{thing}.json")
    Call<Listing<Comment>[]> getPostComments(@Path("subreddit") final String subreddit, @Path("thing") final String thingId, @Query("showmore") final boolean showMore, @Query("depth") final int depth, @Query("sort") final String sort, @Query("limit") final Integer limit);

    @GET("/r/{subreddit}/about/moderators.json")
    Call<ModeratorListing> getModerators(@Path("subreddit") final String subreddit, @Query("limit") final Integer limit,
                                           @Query("after") final String after, @Query("before") final String before);
}