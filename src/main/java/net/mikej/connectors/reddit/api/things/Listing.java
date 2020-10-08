package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Listing<T extends Thing> {
  private final String kind;
  private final ListingData<T> data;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Listing(
    @JsonProperty("kind") final String kind,
    @JsonProperty("data") final ListingData<T> data
  ) {
    this.kind = kind;
    this.data = data;
  }


  public String getKind() {
    return this.kind;
  }

  public ListingData<T> getData() {
    return this.data;
  }  
}