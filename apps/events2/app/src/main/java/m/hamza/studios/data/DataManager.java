package m.hamza.studios.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import m.hamza.studios.data.model.Event;
import m.hamza.studios.data.model.EventListResponse;
import m.hamza.studios.data.model.NamedResource;
import m.hamza.studios.data.model.Pokemon;
import m.hamza.studios.data.model.PokemonListResponse;
import m.hamza.studios.data.remote.MvpStarterService;
import retrofit2.Retrofit;
import rx.Single;
import rx.functions.Func1;

@Singleton
public class DataManager {

    private final MvpStarterService mMvpStarterService;

    @Inject
    public DataManager(Retrofit retrofit) {
        mMvpStarterService = retrofit.create(MvpStarterService.class);
    }

    public Single<List<String>> getPokemonList(int limit) {
        return mMvpStarterService.getPokemonList(limit)
                .flatMap(new Func1<PokemonListResponse, Single<List<String>>>() {
                    @Override
                    public Single<List<String>> call(PokemonListResponse pokemonListResponse) {
                        List<String> pokemonNames = new ArrayList<>();
                        for (NamedResource pokemon : pokemonListResponse.results) {
                            pokemonNames.add(pokemon.name);
                        }
                        return Single.just(pokemonNames);
                    }
                });
    }

    public Single<List<Event>> getEventList(int limit){
        return mMvpStarterService.getEventList(limit)
                .flatMap(new Func1<EventListResponse, Single<? extends List<Event>>>() {
                    @Override
                    public Single<? extends List<Event>> call(EventListResponse eventListResponse) {
                        List<Event> events = new ArrayList<>();
                        for (Event event : eventListResponse.results) {
                            events.add(event);
                        }
                        return null;
                    }
                });
    }

    public Single<Pokemon> getPokemon(String name) {
        return mMvpStarterService.getPokemon(name);
    }

}