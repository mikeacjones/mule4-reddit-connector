package net.mikej.connectors.reddit.api.connection;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.json.JSONObject;

import okhttp3.Credentials;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class TokenProvider {
  private final String URL = "https://www.reddit.com/api/v1/access_token";

  private final String username;
  private final String password;
  private final String client_id;
  private final String client_secret;

  private String token;
  private Instant expiration;

  public TokenProvider(final String username, final String password, final String client_id,
      final String client_secret) {
    this.username = username;
    this.password = password;
    this.client_id = client_id;
    this.client_secret = client_secret;
  }

  public String getToken() throws IOException {
    if (token == null || expiration.isBeforeNow())
      return renewToken();
    return this.token;
  }

  public String renewToken() throws IOException {
    DateTime start = DateTime.now();
    Request request = new Request.Builder().url(URL)
        .method("POST",
            new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("grant_type", "password")
                .addFormDataPart("username", this.username).addFormDataPart("password", this.password).build())
        .addHeader("Authorization", Credentials.basic(this.client_id, this.client_secret)).build();

    OkHttpClient client = new OkHttpClient();
    Response response = client.newCall(request).execute();
    ResponseBody responseBody = response.body();
    JSONObject json = new JSONObject(responseBody.string());
    responseBody.close();
    this.token = json.getString("access_token");
    this.expiration = start.plusSeconds(json.getInt("expires_in")).toInstant();
    return this.token;
  }

  public static class Builder {
    private String username;
    private String password;
    private String client_id;
    private String client_secret;

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder clientId(String client_id) {
      this.client_id = client_id;
      return this;
    }

    public Builder clientSecret(String client_secret) {
      this.client_secret = client_secret;
      return this;
    }

    public TokenProvider build() {
      return new TokenProvider(this.username, this.password, this.client_id, this.client_secret);
    }
  }
}