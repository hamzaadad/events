package m.hamza.studios.data.remote;


import m.hamza.studios.data.model.EventListResponse;
import m.hamza.studios.data.model.Pokemon;
import m.hamza.studios.data.model.PokemonListResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Single;

public interface MvpStarterService {

    @GET("pokemon")
    Single<PokemonListResponse> getPokemonList(@Query("limit") int limit);

    @GET("pokemon/{name}")
    Single<Pokemon> getPokemon(@Path("name") String name);


    @GET("events")
    Single<EventListResponse> getEventList(@Query("limit") int limit);

}
