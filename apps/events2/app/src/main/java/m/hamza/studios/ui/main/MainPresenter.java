package m.hamza.studios.ui.main;


import java.util.List;

import javax.inject.Inject;

import m.hamza.studios.data.DataManager;
import m.hamza.studios.injection.ConfigPersistent;
import m.hamza.studios.ui.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;
    private CompositeSubscription mSubscriptions;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mSubscriptions.unsubscribe();
        mSubscriptions = null;
    }

    public void getPokemon(int limit) {
        checkViewAttached();
        getMvpView().showProgress(true);
        mSubscriptions.add(mDataManager.getPokemonList(limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(pokemon -> {
                    getMvpView().showProgress(false);
                    getMvpView().showPokemon(pokemon);
                }, error -> {
                        getMvpView().showProgress(false);
                        getMvpView().showError();
                        Timber.e(error, "There was an error retrieving the pokemon");
                    }));
    }


}
