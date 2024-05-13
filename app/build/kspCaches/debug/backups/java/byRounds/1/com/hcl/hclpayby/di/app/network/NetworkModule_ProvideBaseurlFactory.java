package com.hcl.hclpayby.di.app.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvideBaseurlFactory implements Factory<String> {
  private final NetworkModule module;

  public NetworkModule_ProvideBaseurlFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideBaseurl(module);
  }

  public static NetworkModule_ProvideBaseurlFactory create(NetworkModule module) {
    return new NetworkModule_ProvideBaseurlFactory(module);
  }

  public static String provideBaseurl(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideBaseurl());
  }
}
