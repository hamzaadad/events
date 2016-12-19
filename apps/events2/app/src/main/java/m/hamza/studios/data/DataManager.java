package m.hamza.studios.data;

import android.util.Log;
import android.widget.Toast;

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
                .flatMap(new Func1<EventListResponse, Single<List<Event>>>() {
                    @Override
                    public Single<List<Event>> call(EventListResponse eventListResponse) {
                        List<Event> events = new ArrayList<>();
                        if(eventListResponse.status.equalsIgnoreCase("ok")){
                            Log.e("HAMZA", "OK this is an error even if status is ok");
                            //Toast.makeText(get)
                        }
                        for (Event event : eventListResponse.events) {
                            events.add(event);
                        }
                        return Single.just(events);
                    }
                });
    }

    public Single<Pokemon> getPokemon(String name) {
        return mMvpStarterService.getPokemon(name);
    }

}