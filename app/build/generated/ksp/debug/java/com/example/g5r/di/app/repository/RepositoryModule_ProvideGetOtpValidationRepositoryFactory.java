package com.example.g5r.di.app.repository;

import com.hcl.hclpayby.data.microservices.service.GetOtpValidationService;
import com.hcl.hclpayby.data.repositories.otpvalidation.GetOtpValidationRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class RepositoryModule_ProvideGetOtpValidationRepositoryFactory implements Factory<GetOtpValidationRepo> {
  private final RepositoryModule module;

  private final Provider<GetOtpValidationService> getOtpValidationServiceProvider;

  public RepositoryModule_ProvideGetOtpValidationRepositoryFactory(RepositoryModule module,
      Provider<GetOtpValidationService> getOtpValidationServiceProvider) {
    this.module = module;
    this.getOtpValidationServiceProvider = getOtpValidationServiceProvider;
  }

  @Override
  public GetOtpValidationRepo get() {
    return provideGetOtpValidationRepository(module, getOtpValidationServiceProvider.get());
  }

  public static RepositoryModule_ProvideGetOtpValidationRepositoryFactory create(
      RepositoryModule module, Provider<GetOtpValidationService> getOtpValidationServiceProvider) {
    return new RepositoryModule_ProvideGetOtpValidationRepositoryFactory(module, getOtpValidationServiceProvider);
  }

  public static GetOtpValidationRepo provideGetOtpValidationRepository(RepositoryModule instance,
      GetOtpValidationService getOtpValidationService) {
    return Preconditions.checkNotNullFromProvides(instance.provideGetOtpValidationRepository(getOtpValidationService));
  }
}
