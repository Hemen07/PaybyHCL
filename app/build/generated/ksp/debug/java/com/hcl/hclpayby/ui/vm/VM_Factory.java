package com.hcl.hclpayby.ui.vm;

import androidx.lifecycle.SavedStateHandle;
import com.hcl.hclpayby.domain.usecases.GetOtpValidationUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata({
    "com.hcl.hclpayby.di.app.dispatcher.DefaultDispatcher",
    "com.hcl.hclpayby.di.app.dispatcher.IODispatcher"
})
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
public final class VM_Factory implements Factory<VM> {
  private final Provider<GetOtpValidationUseCase> getOtpValidationUseCaseProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public VM_Factory(Provider<GetOtpValidationUseCase> getOtpValidationUseCaseProvider,
      Provider<CoroutineDispatcher> dispatcherProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getOtpValidationUseCaseProvider = getOtpValidationUseCaseProvider;
    this.dispatcherProvider = dispatcherProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public VM get() {
    return newInstance(getOtpValidationUseCaseProvider.get(), dispatcherProvider.get(), ioDispatcherProvider.get(), savedStateHandleProvider.get());
  }

  public static VM_Factory create(Provider<GetOtpValidationUseCase> getOtpValidationUseCaseProvider,
      Provider<CoroutineDispatcher> dispatcherProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new VM_Factory(getOtpValidationUseCaseProvider, dispatcherProvider, ioDispatcherProvider, savedStateHandleProvider);
  }

  public static VM newInstance(GetOtpValidationUseCase getOtpValidationUseCase,
      CoroutineDispatcher dispatcher, CoroutineDispatcher ioDispatcher,
      SavedStateHandle savedStateHandle) {
    return new VM(getOtpValidationUseCase, dispatcher, ioDispatcher, savedStateHandle);
  }
}
