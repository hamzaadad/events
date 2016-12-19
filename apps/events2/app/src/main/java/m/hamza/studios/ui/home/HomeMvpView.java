package m.hamza.studios.ui.home;

import java.util.List;

import m.hamza.studios.data.model.Event;
import m.hamza.studios.ui.base.MvpView;

/**
 * Created by hamzaadad on 12/17/16.
 */

public interface HomeMvpView  extends MvpView {

    //void showEvents(List<Event> events);

    void showState();

    void showProgress(boolean show);

    void showError();

}
