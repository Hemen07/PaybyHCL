package com.hcl.hclpayby.di.app;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineScope;

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
public final class AppModule_ProvideApplicationScopeFactory implements Factory<CoroutineScope> {
  private final AppModule module;

  public AppModule_ProvideApplicationScopeFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public CoroutineScope get() {
    return provideApplicationScope(module);
  }

  public static AppModule_ProvideApplicationScopeFactory create(AppModule module) {
    return new AppModule_ProvideApplicationScopeFactory(module);
  }

  public static CoroutineScope provideApplicationScope(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideApplicationScope());
  }
}
