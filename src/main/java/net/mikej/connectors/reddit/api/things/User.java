package net.mikej.connectors.reddit.api.things;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Thing {
  private final boolean isEmployee;
  private final String iconImg;
  private final boolean prefShowSnoovatar;
  private final boolean isFriend;
  private final double created;
  private final boolean hasSubscribed;
  private final boolean hideFromRobots;
  private final double createdUtc;
  private final long linkKarma;
  private final long commentKarma;
  private final boolean isGold;
  private final boolean isMod;
  private final boolean verified;
  private final LinkedHashMap<String, Object> subreddit;
  private final boolean hasVerifiedEmail;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public User(@JsonProperty("is_employee") boolean isEmployee, @JsonProperty("icon_img") String iconImg,
      @JsonProperty("pref_show_snoovatar") boolean prefShowSnoovatar, @JsonProperty("name") String name,
      @JsonProperty("is_friend") boolean isFriend, @JsonProperty("created") double created,
      @JsonProperty("has_subscribed") boolean hasSubscribed, @JsonProperty("hide_from_robots") boolean hideFromRobots,
      @JsonProperty("created_utc") double createdUtc, @JsonProperty("link_karma") long linkKarma,
      @JsonProperty("comment_karma") long commentKarma, @JsonProperty("is_gold") boolean isGold,
      @JsonProperty("is_mod") boolean isMod, @JsonProperty("verified") boolean verified,
      @JsonProperty("subreddit") LinkedHashMap<String, Object> subreddit, @JsonProperty("has_verified_email") boolean hasVerifiedEmail,
      @JsonProperty("id") String id) {
    super(id, name);
    this.isEmployee = isEmployee;
    this.iconImg = iconImg;
    this.prefShowSnoovatar = prefShowSnoovatar;
    this.isFriend = isFriend;
    this.created = created;
    this.hasSubscribed = hasSubscribed;
    this.hideFromRobots = hideFromRobots;
    this.createdUtc = createdUtc;
    this.linkKarma = linkKarma;
    this.commentKarma = commentKarma;
    this.isGold = isGold;
    this.isMod = isMod;
    this.verified = verified;
    this.subreddit = subreddit;
    this.hasVerifiedEmail = hasVerifiedEmail;
  }

  public boolean getIsEmployee() {
    return this.isEmployee;
  }

  public boolean isIsEmployee() {
    return this.isEmployee;
  }

  public String getIconImg() {
    return this.iconImg;
  }

  public boolean getPrefShowSnoovatar() {
    return this.prefShowSnoovatar;
  }

  public boolean isPrefShowSnoovatar() {
    return this.prefShowSnoovatar;
  }

  public boolean getIsFriend() {
    return this.isFriend;
  }

  public boolean isIsFriend() {
    return this.isFriend;
  }

  public double getCreated() {
    return this.created;
  }

  public boolean getHasSubscribed() {
    return this.hasSubscribed;
  }

  public boolean isHasSubscribed() {
    return this.hasSubscribed;
  }

  public boolean getHideFromRobots() {
    return this.hideFromRobots;
  }

  public boolean isHideFromRobots() {
    return this.hideFromRobots;
  }

  public double getCreatedUtc() {
    return this.createdUtc;
  }

  public long getLinkKarma() {
    return this.linkKarma;
  }

  public long getCommentKarma() {
    return this.commentKarma;
  }

  public boolean getIsGold() {
    return this.isGold;
  }

  public boolean isIsGold() {
    return this.isGold;
  }

  public boolean getIsMod() {
    return this.isMod;
  }

  public boolean isIsMod() {
    return this.isMod;
  }

  public boolean getVerified() {
    return this.verified;
  }

  public boolean isVerified() {
    return this.verified;
  }

  public LinkedHashMap<String, Object> getSubreddit() {
    return this.subreddit;
  }

  public boolean getHasVerifiedEmail() {
    return this.hasVerifiedEmail;
  }

  public boolean isHasVerifiedEmail() {
    return this.hasVerifiedEmail;
  }
}