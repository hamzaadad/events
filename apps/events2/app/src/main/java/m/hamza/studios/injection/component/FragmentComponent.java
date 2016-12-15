package m.hamza.studios.injection.component;

import dagger.Subcomponent;
import m.hamza.studios.injection.PerFragment;
import m.hamza.studios.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

}