package net.mikej.connectors.reddit.internal.connection;

import java.io.IOException;

import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.param.display.Placement;

import net.mikej.connectors.reddit.api.connection.RateLimitInterceptor;
import net.mikej.connectors.reddit.api.connection.RedditService;
import net.mikej.connectors.reddit.api.connection.TokenInterceptor;
import net.mikej.connectors.reddit.api.connection.TokenProvider;
import net.mikej.connectors.reddit.api.things.Me;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RedditConnectionProvider implements CachedConnectionProvider<RedditService> {

  @Parameter
  @Placement(order = 1)
  private String username;

  @Parameter
  @Password
  @Placement(order = 2)
  private String password;

  @Parameter
  @Placement(order = 3)
  @DisplayName("client_id")
  private String clientId;

  @Parameter
  @Placement(order = 4)
  @Password
  @DisplayName("client_secret")
  private String clientSecret;

  @Override
  public RedditService connect() throws ConnectionException {
    final TokenProvider tokenProvider = new TokenProvider.Builder().username(username).password(password)
        .clientId(clientId).clientSecret(clientSecret).build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://oauth.reddit.com")
        .addConverterFactory(JacksonConverterFactory.create()).client(new OkHttpClient.Builder()
            .addInterceptor(new TokenInterceptor(tokenProvider)).addInterceptor(new RateLimitInterceptor()).build())
        .build();

    return retrofit.create(RedditService.class);
  }

  @Override
  public void disconnect(RedditService service) {
  }

  @Override
  public ConnectionValidationResult validate(RedditService service) {
    Call<Me> meCall = service.getMe();
    try {
      Response<Me> meResponse = meCall.execute();
      if (!meResponse.isSuccessful())
        return ConnectionValidationResult.failure("Connection failed", null);
      return ConnectionValidationResult.success();
    } catch (IOException e) {
      return ConnectionValidationResult.failure("Connection failed", e);
    }
  }
}