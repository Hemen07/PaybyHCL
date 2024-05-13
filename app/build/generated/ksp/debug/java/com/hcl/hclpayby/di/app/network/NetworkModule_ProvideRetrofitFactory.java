package com.hcl.hclpayby.di.app.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<String> baseUrlProvider;

  private final Provider<OkHttpClient> clientProvider;

  public NetworkModule_ProvideRetrofitFactory(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<OkHttpClient> clientProvider) {
    this.module = module;
    this.baseUrlProvider = baseUrlProvider;
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, baseUrlProvider.get(), clientProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<OkHttpClient> clientProvider) {
    return new NetworkModule_ProvideRetrofitFactory(module, baseUrlProvider, clientProvider);
  }

  public static Retrofit provideRetrofit(NetworkModule instance, String baseUrl,
      OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(baseUrl, client));
  }
}
