package m.hamza.studios.ui.events;

import java.util.List;

import m.hamza.studios.data.model.Event;
import m.hamza.studios.ui.base.MvpView;

/**
 * Created by DevBlaan on 15/12/2016.
 */

public interface EventMvpView  extends MvpView {

    void showEvents(List<Event> events);

    void showProgress(boolean show);

    void showError();

}
