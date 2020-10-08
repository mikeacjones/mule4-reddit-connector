package net.mikej.connectors.reddit.api.things;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import org.joda.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {
  private final String token;
  private final String type;
  private final Integer expiresIn;
  private final Instant expiration;
  private final String scope;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public AccessToken(@JsonProperty("access_token") final String token, @JsonProperty("token_type") final String type,
      @JsonProperty("expires_in") final Integer expiresIn, @JsonProperty("scope") final String scope) {
    this.token = token;
    this.type = type;
    this.expiresIn = expiresIn;
    this.scope = scope;
    this.expiration = DateTime.now().plusSeconds(this.expiresIn).toInstant();
  }

  public String getToken() {
    return this.token;
  }

  public String getType() {
    return this.type;
  }

  public Integer getExpiresIn() {
    return this.expiresIn;
  }

  public Instant getExpiration() {
    return this.expiration;
  }

  public String getScope() {
    return this.scope;
  }
}