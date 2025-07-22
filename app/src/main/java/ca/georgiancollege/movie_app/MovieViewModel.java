package ca.georgiancollege.movie_app;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Movie>> moviesLiveData = new MutableLiveData<>();
    private OkHttpClient client = new OkHttpClient();

    public LiveData<ArrayList<Movie>> getMovies() {
        return moviesLiveData;
    }

    public void fetchMovies(String query, String apiKey) {
        String url = "https://www.omdbapi.com/?apikey=" + apiKey + "&s=" + query;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Optional: handle failure, maybe post empty list or error state
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful() && response.body() != null) {
                    String json = response.body().string();
                    ArrayList<Movie> movies = parseMovies(json);
                    moviesLiveData.postValue(movies);
                }
            }
        });
    }

    private ArrayList<Movie> parseMovies(String json) {
        ArrayList<Movie> moviesList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.getString("Response").equals("True")) {
                JSONArray searchArray = jsonObject.getJSONArray("Search");
                for (int i = 0; i < searchArray.length(); i++) {
                    JSONObject movieObj = searchArray.getJSONObject(i);
                    Movie movie = new Movie(
                            movieObj.getString("Title"),
                            movieObj.getString("Year"),
                            movieObj.getString("imdbID"),
                            movieObj.getString("Type"),
                            movieObj.getString("Poster")
                    );
                    moviesList.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moviesList;
    }
}
