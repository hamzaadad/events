package m.hamza.studios.injection.component;

import dagger.Subcomponent;
import m.hamza.studios.injection.PerActivity;
import m.hamza.studios.injection.module.ActivityModule;
import m.hamza.studios.ui.base.BaseActivity;
import m.hamza.studios.ui.detail.DetailActivity;
import m.hamza.studios.ui.events.EventActivity;
import m.hamza.studios.ui.home.HomeActivty;
import m.hamza.studios.ui.main.MainActivity;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);

    void inject(EventActivity eventActivity);

    void inject(HomeActivty homeActivity);
}
