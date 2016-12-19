package m.hamza.studios.ui.home;

import javax.inject.Inject;

import m.hamza.studios.data.DataManager;
import m.hamza.studios.ui.base.BasePresenter;
import m.hamza.studios.ui.events.EventMvpView;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hamzaadad on 12/17/16.
 */

public class HomePresenter  extends BasePresenter<HomeMvpView> {

    private final DataManager mDataManager;
    private CompositeSubscription mSubscriptions;

    @Inject
    public HomePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(HomeMvpView mvpView) {
        super.attachView(mvpView);
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mSubscriptions.unsubscribe();
        mSubscriptions = null;
    }
}
