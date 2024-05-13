package com.hcl.hclpayby.data.microservices.service;

import com.hcl.hclpayby.data.microservices.api.DemoApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class GetOtpValidationService_Factory implements Factory<GetOtpValidationService> {
  private final Provider<DemoApi> demoApiProvider;

  public GetOtpValidationService_Factory(Provider<DemoApi> demoApiProvider) {
    this.demoApiProvider = demoApiProvider;
  }

  @Override
  public GetOtpValidationService get() {
    return newInstance(demoApiProvider.get());
  }

  public static GetOtpValidationService_Factory create(Provider<DemoApi> demoApiProvider) {
    return new GetOtpValidationService_Factory(demoApiProvider);
  }

  public static GetOtpValidationService newInstance(DemoApi demoApi) {
    return new GetOtpValidationService(demoApi);
  }
}
