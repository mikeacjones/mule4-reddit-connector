package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResult<T> {
  private final Object[] errors;
  private final T data;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public JsonResult(@JsonProperty("errors") Object[] errors, @JsonProperty("data") T data) {
    this.errors = errors;
    this.data = data;
  }


  public Object[] getErrors() {
    return this.errors;
  }

  public T getData() {
    return this.data;
  }
  
}