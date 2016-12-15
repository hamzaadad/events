package m.hamza.studios.ui.detail;

import m.hamza.studios.data.model.Pokemon;
import m.hamza.studios.data.model.Statistic;
import m.hamza.studios.ui.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError();

}