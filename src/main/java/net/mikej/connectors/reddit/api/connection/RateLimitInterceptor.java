package net.mikej.connectors.reddit.api.connection;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class RateLimitInterceptor implements Interceptor {
  @Override
  public Response intercept(Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());
    if (!response.isSuccessful() && response.code() == 429) {
      try {
        int resetTime = Integer.parseInt(response.header("x-ratelimit-reset"));
        Thread.sleep(1000 * resetTime);
      } catch (InterruptedException e) {
      }
      response.close();
      response = chain.proceed(chain.request());
    }
    return response;
  }
}