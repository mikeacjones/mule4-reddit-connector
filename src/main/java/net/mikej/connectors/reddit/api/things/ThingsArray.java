package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ThingsArray<T extends Thing> {
  private final ListingChild<T>[] things;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public ThingsArray(@JsonProperty("things") ListingChild<T>[] things) {
    this.things = things;
  }

  public ListingChild<T>[] getThings() { return things; }
}