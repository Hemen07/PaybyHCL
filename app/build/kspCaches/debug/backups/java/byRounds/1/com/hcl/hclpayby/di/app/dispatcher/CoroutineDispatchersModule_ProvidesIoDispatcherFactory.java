package com.hcl.hclpayby.di.app.dispatcher;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata("com.hcl.hclpayby.di.app.dispatcher.IODispatcher")
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
public final class CoroutineDispatchersModule_ProvidesIoDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return providesIoDispatcher();
  }

  public static CoroutineDispatchersModule_ProvidesIoDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher providesIoDispatcher() {
    return Preconditions.checkNotNullFromProvides(CoroutineDispatchersModule.INSTANCE.providesIoDispatcher());
  }

  private static final class InstanceHolder {
    private static final CoroutineDispatchersModule_ProvidesIoDispatcherFactory INSTANCE = new CoroutineDispatchersModule_ProvidesIoDispatcherFactory();
  }
}
