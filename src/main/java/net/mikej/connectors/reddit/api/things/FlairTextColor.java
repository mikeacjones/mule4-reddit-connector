package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FlairTextColor {
  LIGHT("light"),
  DARK("dark");

  private final String value;
  private FlairTextColor(final String color) {
    this.value = color;
  }
  @JsonValue
  public String getValue() { return value; }
  @Override
  public String toString() { return value; }
}