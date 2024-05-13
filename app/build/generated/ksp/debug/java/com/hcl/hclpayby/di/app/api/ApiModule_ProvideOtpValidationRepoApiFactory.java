package com.hcl.hclpayby.di.app.api;

import com.hcl.hclpayby.data.microservices.api.DemoApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class ApiModule_ProvideOtpValidationRepoApiFactory implements Factory<DemoApi> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideOtpValidationRepoApiFactory(ApiModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public DemoApi get() {
    return provideOtpValidationRepoApi(module, retrofitProvider.get());
  }

  public static ApiModule_ProvideOtpValidationRepoApiFactory create(ApiModule module,
      Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideOtpValidationRepoApiFactory(module, retrofitProvider);
  }

  public static DemoApi provideOtpValidationRepoApi(ApiModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideOtpValidationRepoApi(retrofit));
  }
}
