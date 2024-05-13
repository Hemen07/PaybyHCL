package com.hcl.hclpayby.domain.usecases;

import com.hcl.hclpayby.data.repositories.otpvalidation.GetOtpValidationRepo;
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
public final class GetOtpValidationUseCase_Factory implements Factory<GetOtpValidationUseCase> {
  private final Provider<GetOtpValidationRepo> getOtpValidationRepoProvider;

  public GetOtpValidationUseCase_Factory(
      Provider<GetOtpValidationRepo> getOtpValidationRepoProvider) {
    this.getOtpValidationRepoProvider = getOtpValidationRepoProvider;
  }

  @Override
  public GetOtpValidationUseCase get() {
    return newInstance(getOtpValidationRepoProvider.get());
  }

  public static GetOtpValidationUseCase_Factory create(
      Provider<GetOtpValidationRepo> getOtpValidationRepoProvider) {
    return new GetOtpValidationUseCase_Factory(getOtpValidationRepoProvider);
  }

  public static GetOtpValidationUseCase newInstance(GetOtpValidationRepo getOtpValidationRepo) {
    return new GetOtpValidationUseCase(getOtpValidationRepo);
  }
}
