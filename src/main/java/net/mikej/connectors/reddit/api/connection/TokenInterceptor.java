package net.mikej.connectors.reddit.api.connection;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
  private final TokenProvider tokenProvider;

  public TokenInterceptor(final TokenProvider tokenProvider) {
    this.tokenProvider = tokenProvider;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Request.Builder builder = request.newBuilder();
    String token = tokenProvider.getToken();
    builder.header("Authorization", String.format("Bearer %s", token));

    request = builder.build();
    Response response = chain.proceed(request);

    if (response.code() == 401) {
      String currentToken = tokenProvider.getToken();

      if (currentToken != null && currentToken.equals(token)) {
        currentToken = tokenProvider.renewToken();
      }

      if (currentToken != null) {
        builder.header("Authorization", String.format("Bearer %s", currentToken));
        request = builder.build();
        response.close();
        return chain.proceed(request);
      }
    }
    return response;
  }
}