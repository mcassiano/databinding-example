package me.cassiano.randompeopledatabindingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cassiano.randompeopledatabindingexample.adapter.PersonAdapter;
import me.cassiano.randompeopledatabindingexample.model.PeopleResult;
import me.cassiano.randompeopledatabindingexample.service.RandomUserServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.peopleRV)
    RecyclerView peopleRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        peopleRV.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RandomUserServiceInterface service = retrofit.create(RandomUserServiceInterface.class);

        service.getRandomPeople(10, "json", "BR").enqueue(new Callback<PeopleResult>() {
            @Override
            public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {

                PersonAdapter adapter = new PersonAdapter();
                adapter.setResults(response.body().getResults());

                peopleRV.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<PeopleResult> call, Throwable t) {
                Log.d("ERROR", "UNKNOWN");
            }
        });


    }
}
