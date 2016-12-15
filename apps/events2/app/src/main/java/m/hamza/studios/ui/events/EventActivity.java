package m.hamza.studios.ui.events;

import java.util.List;

import javax.inject.Inject;

import m.hamza.studios.data.model.Event;
import m.hamza.studios.ui.base.BaseActivity;
import m.hamza.studios.ui.common.ErrorView;
import m.hamza.studios.ui.main.MainMvpView;
import m.hamza.studios.ui.main.PokemonAdapter;

/**
 * Created by DevBlaan on 15/12/2016.
 */

public class EventActivity  extends BaseActivity implements EventMvpView, EventAdapter.ClickListener,
        ErrorView.ErrorListener {

    @Inject EventAdapter mEventAdapter;
    @Inject EventPresenter mEventPresenter;

    @Override
    public void showEvents(List<String> events) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onReloadData() {

    }

    @Override
    public void onEventClick(Event event) {

    }
}
