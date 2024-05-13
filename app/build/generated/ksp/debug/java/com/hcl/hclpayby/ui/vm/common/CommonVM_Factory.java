package com.hcl.hclpayby.ui.vm.common;

import androidx.lifecycle.SavedStateHandle;
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
public final class CommonVM_Factory implements Factory<CommonVM> {
  private final Provider<CoroutineDispatcher> dispatcherProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public CommonVM_Factory(Provider<CoroutineDispatcher> dispatcherProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.dispatcherProvider = dispatcherProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public CommonVM get() {
    return newInstance(dispatcherProvider.get(), ioDispatcherProvider.get(), savedStateHandleProvider.get());
  }

  public static CommonVM_Factory create(Provider<CoroutineDispatcher> dispatcherProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new CommonVM_Factory(dispatcherProvider, ioDispatcherProvider, savedStateHandleProvider);
  }

  public static CommonVM newInstance(CoroutineDispatcher dispatcher,
      CoroutineDispatcher ioDispatcher, SavedStateHandle savedStateHandle) {
    return new CommonVM(dispatcher, ioDispatcher, savedStateHandle);
  }
}
