package net.mikej.connectors.reddit.api.things;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.mikej.connectors.reddit.api.things.Thing;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends Thing {
  private final String selftext;
  private final String selftextHtml;
  private final Double approvedAtUtc;
  private final String subreddit;
  private final String authorFullname;
  private final Boolean saved;
  private final Integer gilded;
  private final Boolean clicked;
  private final String title;
  private final String subredditNamePrefixed;
  private final Boolean hidden;
  private final Integer pwls;
  private final Integer downs;
  private final Boolean hideScore;
  private final Boolean quarantine;
  private final Double upvoteRatio;
  private final String subredditType;
  private final Integer ups;
  private final Integer totalAwardsReceived;
  private final String linkFlairText;
  private final Integer score;
  private final String approvedBy;
  private final String thumbnail;
  private final Boolean edited;
  private final Double editedAt;
  private final Boolean isSelf;
  private final String modNote;
  private final Double created;
  private final String linkFlairType;
  private final Integer wls;
  private final String bannedBy;
  private final String authorFlairType;
  private final String domain;
  private final Boolean allowLiveComments;
  private final Double bannedAtUtc;
  private final Integer viewCount;
  private final Boolean archived;
  private final Boolean noFollow;
  private final Boolean isCrosspostable;
  private final Boolean pinned;
  private final Boolean over18;
  private final LinkedHashMap<String, Object> preview;
  private final Boolean locked;
  private final String authorFlairText;
  private final Boolean visited;
  private final String removedBy;
  private final Integer numReports;
  private final String subredditId;
  private final String modReasonBy;
  private final String removalReason;
  private final Boolean isRobotIndexable;
  private final String author;
  private final Integer numComments;
  private final Boolean sendReplies;
  private final String whitelistStatus;
  private final Boolean contestMode;
  private final String permalink;
  private final String parentWhitelistStatus;
  private final Boolean stickied;
  private final String url;
  private final Integer subredditSubscribers;
  private final Double createdUtc;
  private final Integer numCrossposts;
  private final LinkedHashMap<String, Object> media;
  private final LinkedHashMap<String, Object> secureMedia;
  private final Boolean isVideo;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Post(@JsonProperty("selftext") String selftext, @JsonProperty("selftext_html") String selftextHtml,
      @JsonProperty("approved_at_utc") Double approvedAtUtc, @JsonProperty("subreddit") String subreddit,
      @JsonProperty("author_fullname") String authorFullname, @JsonProperty("saved") Boolean saved,
      @JsonProperty("gilded") Integer gilded, @JsonProperty("clicked") Boolean clicked,
      @JsonProperty("title") String title, @JsonProperty("subreddit_name_prefixed") String subredditNamePrefixed,
      @JsonProperty("hidden") Boolean hidden, @JsonProperty("pwls") Integer pwls, @JsonProperty("downs") Integer downs,
      @JsonProperty("hide_score") Boolean hideScore, @JsonProperty("quarantine") Boolean quarantine,
      @JsonProperty("upvote_ratio") Double upvoteRatio, @JsonProperty("subreddit_type") String subredditType,
      @JsonProperty("ups") Integer ups, @JsonProperty("total_awards_received") Integer totalAwardsReceived,
      @JsonProperty("link_flair_text") String linkFlairText, @JsonProperty("score") Integer score,
      @JsonProperty("approved_by") String approvedBy, @JsonProperty("thumbnail") String thumbnail,
      @JsonProperty("edited") Object edited,
      @JsonProperty("is_self") Boolean isSelf, @JsonProperty("mod_note") String modNote,
      @JsonProperty("created") Double created, @JsonProperty("link_flair_type") String linkFlairType,
      @JsonProperty("wls") Integer wls, @JsonProperty("banned_by") String bannedBy,
      @JsonProperty("author_flair_type") String authorFlairType, @JsonProperty("domain") String domain,
      @JsonProperty("allow_live_comments") Boolean allowLiveComments, @JsonProperty("banned_at_utc") Double bannedAtUtc,
      @JsonProperty("view_count") Integer viewCount, @JsonProperty("arhived") Boolean archived,
      @JsonProperty("no_follow") Boolean noFollow, @JsonProperty("is_crosspostable") Boolean isCrosspostable,
      @JsonProperty("pinned") Boolean pinned, @JsonProperty("over_18") Boolean over18,
      @JsonProperty("preview") LinkedHashMap<String, Object> preview, @JsonProperty("locked") Boolean locked,
      @JsonProperty("author_flair_text") String authorFlairText, @JsonProperty("visited") Boolean visited,
      @JsonProperty("removed_by") String removedBy, @JsonProperty("num_reports") Integer numReports,
      @JsonProperty("subreddit_id") String subredditId, @JsonProperty("mod_reason_by") String modReasonBy,
      @JsonProperty("removal_reason") String removalReason,
      @JsonProperty("is_robot_indexable") Boolean isRobotIndexable, @JsonProperty("author") String author,
      @JsonProperty("num_comments") Integer numComments, @JsonProperty("send_replies") Boolean sendReplies,
      @JsonProperty("whitelist_status") String whitelistStatus, @JsonProperty("contest_mode") Boolean contestMode,
      @JsonProperty("permalink") String permalink,
      @JsonProperty("parent_whitelist_status") String parentWhitelistStatus, @JsonProperty("stickied") Boolean stickied,
      @JsonProperty("url") String url, @JsonProperty("subreddit_subscribers") Integer subredditSubscribers,
      @JsonProperty("created_utc") Double createdUtc, @JsonProperty("num_crossposts") Integer numCrossposts,
      @JsonProperty("media") LinkedHashMap<String, Object> media, @JsonProperty("secure_media") LinkedHashMap<String, Object> secureMedia, @JsonProperty("is_video") Boolean isVideo,
      @JsonProperty("id") final String id, @JsonProperty("name") final String name) {
    super(id, name);

    this.selftext = selftext;
    this.selftextHtml = selftextHtml;
    this.approvedAtUtc = approvedAtUtc;
    this.subreddit = subreddit;
    this.authorFullname = authorFullname;
    this.saved = saved;
    this.gilded = gilded;
    this.clicked = clicked;
    this.title = title;
    this.subredditNamePrefixed = subredditNamePrefixed;
    this.hidden = hidden;
    this.pwls = pwls;
    this.downs = downs;
    this.hideScore = hideScore;
    this.quarantine = quarantine;
    this.upvoteRatio = upvoteRatio;
    this.subredditType = subredditType;
    this.ups = ups;
    this.totalAwardsReceived = totalAwardsReceived;
    this.linkFlairText = linkFlairText;
    this.score = score;
    this.approvedBy = approvedBy;
    this.thumbnail = thumbnail;
    this.edited = !(edited instanceof Boolean);
    this.editedAt = this.edited ? new Double(edited.toString()) : null;
    this.isSelf = isSelf;
    this.modNote = modNote;
    this.created = created;
    this.linkFlairType = linkFlairType;
    this.wls = wls;
    this.bannedBy = bannedBy;
    this.authorFlairType = authorFlairType;
    this.domain = domain;
    this.allowLiveComments = allowLiveComments;
    this.bannedAtUtc = bannedAtUtc;
    this.viewCount = viewCount;
    this.archived = archived;
    this.noFollow = noFollow;
    this.isCrosspostable = isCrosspostable;
    this.pinned = pinned;
    this.over18 = over18;
    this.preview = preview;
    this.locked = locked;
    this.authorFlairText = authorFlairText;
    this.visited = visited;
    this.removedBy = removedBy;
    this.numReports = numReports;
    this.subredditId = subredditId;
    this.modReasonBy = modReasonBy;
    this.removalReason = removalReason;
    this.isRobotIndexable = isRobotIndexable;
    this.author = author;
    this.numComments = numComments;
    this.sendReplies = sendReplies;
    this.whitelistStatus = whitelistStatus;
    this.contestMode = contestMode;
    this.permalink = permalink;
    this.parentWhitelistStatus = parentWhitelistStatus;
    this.stickied = stickied;
    this.url = url;
    this.subredditSubscribers = subredditSubscribers;
    this.createdUtc = createdUtc;
    this.numCrossposts = numCrossposts;
    this.media = media;
    this.secureMedia = secureMedia;
    this.isVideo = isVideo;
  }

  public String getSelftext() {
    return this.selftext;
  }

  public String getSelftextHtml() {
    return this.selftextHtml;
  }

  public Double getApprovedAtUtc() {
    return this.approvedAtUtc;
  }

  public String getSubreddit() {
    return this.subreddit;
  }

  public String getAuthorFullname() {
    return this.authorFullname;
  }

  public Boolean getSaved() {
    return this.saved;
  }

  public Boolean isSaved() {
    return this.saved;
  }

  public Integer getGilded() {
    return this.gilded;
  }

  public Boolean getClicked() {
    return this.clicked;
  }

  public Boolean isClicked() {
    return this.clicked;
  }

  public String getTitle() {
    return this.title;
  }

  public String getSubredditNamePrefixed() {
    return this.subredditNamePrefixed;
  }

  public Boolean getHidden() {
    return this.hidden;
  }

  public Boolean isHidden() {
    return this.hidden;
  }

  public Integer getPwls() {
    return this.pwls;
  }

  public Integer getDowns() {
    return this.downs;
  }

  public Boolean getHideScore() {
    return this.hideScore;
  }

  public Boolean isHideScore() {
    return this.hideScore;
  }

  public Boolean getQuarantine() {
    return this.quarantine;
  }

  public Boolean isQuarantine() {
    return this.quarantine;
  }

  public Double getUpvoteRatio() {
    return this.upvoteRatio;
  }

  public String getSubredditType() {
    return this.subredditType;
  }

  public Integer getUps() {
    return this.ups;
  }

  public Integer getTotalAwardsReceived() {
    return this.totalAwardsReceived;
  }

  public String getLinkFlairText() {
    return this.linkFlairText;
  }

  public Integer getScore() {
    return this.score;
  }

  public String getApprovedBy() {
    return this.approvedBy;
  }

  public String getThumbnail() {
    return this.thumbnail;
  }

  public Boolean getEdited() {
    return this.edited;
  }

  public Boolean isEdited() {
    return this.edited;
  }

  public Double getEditedAt() {
    return this.editedAt;
  }

  public Boolean getIsSelf() {
    return this.isSelf;
  }

  public Boolean isIsSelf() {
    return this.isSelf;
  }

  public String getModNote() {
    return this.modNote;
  }

  public Double getCreated() {
    return this.created;
  }

  public String getLinkFlairType() {
    return this.linkFlairType;
  }

  public Integer getWls() {
    return this.wls;
  }

  public String getBannedBy() {
    return this.bannedBy;
  }

  public String getAuthorFlairType() {
    return this.authorFlairType;
  }

  public String getDomain() {
    return this.domain;
  }

  public Boolean getAllowLiveComments() {
    return this.allowLiveComments;
  }

  public Boolean isAllowLiveComments() {
    return this.allowLiveComments;
  }

  public Double getBannedAtUtc() {
    return this.bannedAtUtc;
  }

  public Integer getViewCount() {
    return this.viewCount;
  }

  public Boolean getArchived() {
    return this.archived;
  }

  public Boolean isArchived() {
    return this.archived;
  }

  public Boolean getNoFollow() {
    return this.noFollow;
  }

  public Boolean isNoFollow() {
    return this.noFollow;
  }

  public Boolean getIsCrosspostable() {
    return this.isCrosspostable;
  }

  public Boolean isIsCrosspostable() {
    return this.isCrosspostable;
  }

  public Boolean getPinned() {
    return this.pinned;
  }

  public Boolean isPinned() {
    return this.pinned;
  }

  public Boolean getOver18() {
    return this.over18;
  }

  public Boolean isOver18() {
    return this.over18;
  }

  public LinkedHashMap<String, Object> getPreview() {
    return this.preview;
  }

  public Boolean getLocked() {
    return this.locked;
  }

  public Boolean isLocked() {
    return this.locked;
  }

  public String getAuthorFlairText() {
    return this.authorFlairText;
  }

  public Boolean getVisited() {
    return this.visited;
  }

  public Boolean isVisited() {
    return this.visited;
  }

  public String getRemovedBy() {
    return this.removedBy;
  }

  public Integer getNumReports() {
    return this.numReports;
  }

  public String getSubredditId() {
    return this.subredditId;
  }

  public String getModReasonBy() {
    return this.modReasonBy;
  }

  public String getRemovalReason() {
    return this.removalReason;
  }

  public Boolean getIsRobotIndexable() {
    return this.isRobotIndexable;
  }

  public Boolean isIsRobotIndexable() {
    return this.isRobotIndexable;
  }

  public String getAuthor() {
    return this.author;
  }

  public Integer getNumComments() {
    return this.numComments;
  }

  public Boolean getSendReplies() {
    return this.sendReplies;
  }

  public Boolean isSendReplies() {
    return this.sendReplies;
  }

  public String getWhitelistStatus() {
    return this.whitelistStatus;
  }

  public Boolean getContestMode() {
    return this.contestMode;
  }

  public Boolean isContestMode() {
    return this.contestMode;
  }

  public String getPermalink() {
    return this.permalink;
  }

  public String getParentWhitelistStatus() {
    return this.parentWhitelistStatus;
  }

  public Boolean getStickied() {
    return this.stickied;
  }

  public Boolean isStickied() {
    return this.stickied;
  }

  public String getUrl() {
    return this.url;
  }

  public Integer getSubredditSubscribers() {
    return this.subredditSubscribers;
  }

  public Double getCreatedUtc() {
    return this.createdUtc;
  }

  public Integer getNumCrossposts() {
    return this.numCrossposts;
  }

  public LinkedHashMap<String, Object> getMedia() {
    return this.media;
  }

  public LinkedHashMap<String, Object> getSecureMedia() {
    return this.secureMedia;
  }

  public Boolean getIsVideo() {
    return this.isVideo;
  }

  public Boolean isIsVideo() {
    return this.isVideo;
  }

}