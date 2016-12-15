package m.hamza.studios.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import m.hamza.studios.data.DataManager;
import m.hamza.studios.injection.ApplicationContext;
import m.hamza.studios.injection.module.ApplicationModule;
import m.hamza.studios.injection.module.NetworkModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    Retrofit provideRetrofit();
}
