package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResult<T> {
  private final JsonResult<T> json;
  
  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public PostResult(@JsonProperty("json") JsonResult<T> json) {
    this.json = json;
  }

  public JsonResult<T> getJson() { return json; }
}