package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingChild<T extends Thing> {
  private final String kind;
  private final T data;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public ListingChild(
    @JsonProperty("kind") final String kind,
    @JsonProperty("data") final T data
  ) {
    this.kind = kind;
    this.data = data;
  }


  public String getKind() {
    return this.kind;
  }

  public T getData() {
    return this.data;
  }

}