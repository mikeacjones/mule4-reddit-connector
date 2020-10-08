package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.mikej.connectors.reddit.api.things.Thing;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends Thing {

  private final String body;
  private final String bodyHtml;
  private final String parentId;
  private final String subreddit;
  private final String subredditId;
  private final String linkId;
  private final String linkTitle;
  private final String linkAuthor;
  private final Boolean unread;
  private final String subredditNamePrefixed;
  private final String authorFlairCssClass;
  private final String authorFlairText;
  private final String authorFullname;
  private final Integer downvotes;
  private final Boolean edited;
  private final Double editedAt;
  private final Boolean archived;
  private final Integer upvotes;
  private final Boolean saved;
  private final Boolean locked;
  private final String permalink;
  private final String linkPermalink;
  private final Boolean stickied;
  private final Boolean liked;
  private final Integer gilded;
  private final String approvedBy;
  private final String author;
  private final String bannedBy;
  private final Integer score;
  private final Boolean approved;
  private final Boolean removed;
  private final Integer numReports;
  private final Double created;
  private final Double createdUtc;
  private final Object replies;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Comment(@JsonProperty("body") final String body, @JsonProperty("body_html") final String bodyHtml,
      @JsonProperty("parent_id") final String parentId, @JsonProperty("subreddit") final String subreddit,
      @JsonProperty("subreddit_id") final String subredditId, @JsonProperty("link_id") final String linkId,
      @JsonProperty("link_title") final String linkTitle, @JsonProperty("link_author") final String linkAuthor,
      @JsonProperty("new") final Boolean unread,
      @JsonProperty("subreddit_name_prefixed") final String subredditNamePrefixed,
      @JsonProperty("author_flair_css_class") final String authorFlairCssClass,
      @JsonProperty("author_flair_text") final String authorFlairText, @JsonProperty("downs") final Integer downvotes,
      @JsonProperty("edited") final Object edited, @JsonProperty("archived") final Boolean archived,
      @JsonProperty("ups") final Integer upvotes, @JsonProperty("saved") final Boolean saved,
      @JsonProperty("locked") final Boolean locked, @JsonProperty("permalink") final String permalink,
      @JsonProperty("link_permalink") final String linkPermalink, @JsonProperty("stickied") final Boolean stickied,
      @JsonProperty("likes") final Boolean liked, @JsonProperty("gilded") final Integer gilded,
      @JsonProperty("approved_by") final String approvedBy, @JsonProperty("author") final String author,
      @JsonProperty("banned_by") final String bannedBy, @JsonProperty("score") final Integer score,
      @JsonProperty("approved") final Boolean approved, @JsonProperty("removed") final Boolean removed,
      @JsonProperty("num_reports") final Integer numReports, @JsonProperty("created") final Double created,
      @JsonProperty("created_utc") final Double createdUtc, @JsonProperty("id") final String id,
      @JsonProperty("name") final String name, @JsonProperty("replies") final Object replies, @JsonProperty("author_fullname") final String authorFullname) {
      

    super(id, name);

    this.body = body;
    this.bodyHtml = bodyHtml;
    this.parentId = parentId;
    this.subreddit = subreddit;
    this.subredditId = subredditId;
    this.linkId = linkId;
    this.linkTitle = linkTitle;
    this.linkAuthor = linkAuthor;
    this.unread = unread;
    this.subredditNamePrefixed = subredditNamePrefixed;
    this.authorFlairCssClass = authorFlairCssClass;
    this.authorFlairText = authorFlairText;
    this.downvotes = downvotes;
    this.edited = !(edited instanceof Boolean);
    this.editedAt = this.edited ? new Double(edited.toString()) : null;
    this.archived = archived;
    this.upvotes = upvotes;
    this.saved = saved;
    this.locked = locked;
    this.permalink = permalink;
    this.linkPermalink = linkPermalink;
    this.stickied = stickied;
    this.liked = liked;
    this.gilded = gilded;
    this.approvedBy = approvedBy;
    this.author = author;
    this.bannedBy = bannedBy;
    this.score = score;
    this.approved = approved;
    this.removed = removed;
    this.numReports = numReports;
    this.created = created;
    this.createdUtc = createdUtc;
    this.replies = replies;
    this.authorFullname = authorFullname;
  }

  public String getBody() {
    return this.body;
  }

  public String getBodyHtml() {
    return this.bodyHtml;
  }

  public String getParentId() {
    return this.parentId;
  }

  public String getSubreddit() {
    return this.subreddit;
  }

  public String getSubredditId() {
    return this.subredditId;
  }

  public String getLinkId() {
    return this.linkId;
  }

  public String getLinkTitle() {
    return this.linkTitle;
  }

  public String getLinkAuthor() {
    return this.linkAuthor;
  }

  public Boolean getUnread() {
    return this.unread;
  }

  public Boolean isUnread() {
    return this.unread;
  }

  public String getSubredditNamePrefixed() {
    return this.subredditNamePrefixed;
  }

  public String getAuthorFlairCssClass() {
    return this.authorFlairCssClass;
  }

  public String getAuthorFlairText() {
    return this.authorFlairText;
  }

  public Integer getDownvotes() {
    return this.downvotes;
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

  public Boolean getArchived() {
    return this.archived;
  }

  public Boolean isArchived() {
    return this.archived;
  }

  public Integer getUpvotes() {
    return this.upvotes;
  }

  public Boolean getSaved() {
    return this.saved;
  }

  public Boolean isSaved() {
    return this.saved;
  }

  public Boolean getLocked() {
    return this.locked;
  }

  public Boolean isLocked() {
    return this.locked;
  }

  public String getPermalink() {
    return this.permalink;
  }

  public String getLinkPermalink() {
    return this.linkPermalink;
  }

  public Boolean getStickied() {
    return this.stickied;
  }

  public Boolean isStickied() {
    return this.stickied;
  }

  public Boolean getLiked() {
    return this.liked;
  }

  public Boolean isLiked() {
    return this.liked;
  }

  public Integer getGilded() {
    return this.gilded;
  }

  public String getApprovedBy() {
    return this.approvedBy;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getBannedBy() {
    return this.bannedBy;
  }

  public Integer getScore() {
    return this.score;
  }

  public Boolean getApproved() {
    return this.approved;
  }

  public Boolean isApproved() {
    return this.approved;
  }

  public Boolean getRemoved() {
    return this.removed;
  }

  public Boolean isRemoved() {
    return this.removed;
  }

  public Integer getNumReports() {
    return this.numReports;
  }

  public Double getCreated() {
    return this.created;
  }

  public Double getCreatedUtc() {
    return this.createdUtc;
  }

  public String getAuthorFullname() { return this.authorFullname; }
  
  public Object getReplies() {
    return replies;
  }
}