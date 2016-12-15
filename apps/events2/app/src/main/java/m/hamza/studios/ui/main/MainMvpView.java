package m.hamza.studios.ui.main;

import java.util.List;

import m.hamza.studios.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showPokemon(List<String> pokemon);



    void showProgress(boolean show);

    void showError();

}