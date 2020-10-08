package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingData<T extends Thing> {
  private final String modhash;
  private final Integer dist;
  private final ListingChild<T>[] children;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public ListingData(
    @JsonProperty("modhash") final String modhash,
    @JsonProperty("dist") final Integer dist,
    @JsonProperty("children") final ListingChild<T>[] children
  ) {
    this.modhash = modhash;
    this.dist = dist;
    this.children = children;
  }


  public String getModhash() {
    return this.modhash;
  }

  public Integer getDist() {
    return this.dist;
  }

  public ListingChild<T>[] getChildren() {
    return this.children;
  }

}