package m.hamza.studios.ui.events;

import java.util.List;

import javax.inject.Inject;

import m.hamza.studios.data.DataManager;
import m.hamza.studios.data.model.Event;
import m.hamza.studios.injection.ConfigPersistent;
import m.hamza.studios.ui.base.BasePresenter;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by DevBlaan on 15/12/2016.
 */



@ConfigPersistent
public class EventPresenter extends BasePresenter<EventMvpView> {

    private final DataManager mDataManager;
    private CompositeSubscription mSubscriptions;

    @Inject
    public EventPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(EventMvpView mvpView) {
        super.attachView(mvpView);
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mSubscriptions.unsubscribe();
        mSubscriptions = null;
    }

    public void getEvent(int limit){
        checkViewAttached();
        getMvpView().showProgress(true);
        mSubscriptions.add(mDataManager.getEventList(limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleSubscriber<List<Event>>() {
                    @Override
                    public void onSuccess(List<Event> events) {
                        getMvpView().showProgress(false);
                        getMvpView().showEvents(events);
                    }

                    @Override
                    public void onError(Throwable error) {
                        getMvpView().showProgress(false);
                        getMvpView().showError();
                        Timber.e(error, "There was an error retrieving the pokemon");
                    }
                }));
               /* .subscribe(events -> {
                    getMvpView().showProgress(false);
                    getMvpView().showEvents(events);
                }, error -> {
                    getMvpView().showProgress(false);
                    getMvpView().showError();
                    Timber.e(error, "There was an error retrieving the pokemon");
                }));*/
    }
}
