package com.hcl.hclpayby.data.repositories.otpvalidation;

import com.hcl.hclpayby.data.microservices.service.GetOtpValidationService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class GetOtpValidationRepoImpl_Factory implements Factory<GetOtpValidationRepoImpl> {
  private final Provider<GetOtpValidationService> getOtpValidationServiceProvider;

  public GetOtpValidationRepoImpl_Factory(
      Provider<GetOtpValidationService> getOtpValidationServiceProvider) {
    this.getOtpValidationServiceProvider = getOtpValidationServiceProvider;
  }

  @Override
  public GetOtpValidationRepoImpl get() {
    return newInstance(getOtpValidationServiceProvider.get());
  }

  public static GetOtpValidationRepoImpl_Factory create(
      Provider<GetOtpValidationService> getOtpValidationServiceProvider) {
    return new GetOtpValidationRepoImpl_Factory(getOtpValidationServiceProvider);
  }

  public static GetOtpValidationRepoImpl newInstance(
      GetOtpValidationService getOtpValidationService) {
    return new GetOtpValidationRepoImpl(getOtpValidationService);
  }
}
