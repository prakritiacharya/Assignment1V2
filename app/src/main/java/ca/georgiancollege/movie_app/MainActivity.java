package ca.georgiancollege.movie_app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;


import ca.georgiancollege.movie_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MovieViewModel movieViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class); //connect mainactivity and ViewModel

        setContentView(binding.getRoot());

        // Search button click
        //click listener
        binding.btnSearch.setOnClickListener(v -> {
            String query = binding.editSearch.getText().toString().trim();
            if (!query.isEmpty()) {
                //  method to search movies with 'query'
                searchMovies(query);
            } else {
                Toast.makeText(this, "Please enter a movie name", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void searchMovies(String query) {
        Toast.makeText(this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
        // API call
    }
}