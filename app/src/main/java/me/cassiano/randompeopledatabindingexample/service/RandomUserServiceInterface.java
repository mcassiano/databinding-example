package me.cassiano.randompeopledatabindingexample.service;

import me.cassiano.randompeopledatabindingexample.model.PeopleResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by matheus on 7/13/16.
 */
public interface RandomUserServiceInterface {

    @GET("/api")
    Call<PeopleResult> getRandomPeople
            (@Query("results") Integer numberOfPeople,
             @Query("format") String format,
             @Query("nat") String nat);
}
