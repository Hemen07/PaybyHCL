package com.hcl.hclpayby.ui.vm;

import androidx.lifecycle.SavedStateHandle;
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
public final class SharedNavigationVM_Factory implements Factory<SharedNavigationVM> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public SharedNavigationVM_Factory(Provider<SavedStateHandle> savedStateHandleProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public SharedNavigationVM get() {
    return newInstance(savedStateHandleProvider.get());
  }

  public static SharedNavigationVM_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new SharedNavigationVM_Factory(savedStateHandleProvider);
  }

  public static SharedNavigationVM newInstance(SavedStateHandle savedStateHandle) {
    return new SharedNavigationVM(savedStateHandle);
  }
}
