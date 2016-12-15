package m.hamza.studios.injection.component;

import dagger.Component;
import m.hamza.studios.injection.ConfigPersistent;
import m.hamza.studios.injection.module.ActivityModule;
import m.hamza.studios.injection.module.FragmentModule;
import m.hamza.studios.ui.base.BaseActivity;
import m.hamza.studios.ui.base.BaseFragment;

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't
 * be destroy during configuration changes. Check {@link BaseActivity} and {@link BaseFragment} to
 * see how this components survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

}
