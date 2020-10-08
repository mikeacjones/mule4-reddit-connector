package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Me extends Thing {

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Me(
    @JsonProperty("id") String id, 
    @JsonProperty("name") String name) {
    super(id, name);
  }
}