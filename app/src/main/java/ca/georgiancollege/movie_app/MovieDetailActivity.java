package ca.georgiancollege.movie_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;  // for loading poster image from URL

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_YEAR = "extra_year";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_POSTER = "extra_poster";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        TextView title = findViewById(R.id.movieTitle);
        TextView year = findViewById(R.id.movieYear);
        TextView type = findViewById(R.id.movieType);
        ImageView poster = findViewById(R.id.moviePoster);

        // Get data
        String movieTitle = getIntent().getStringExtra(EXTRA_TITLE);
        String movieYear = getIntent().getStringExtra(EXTRA_YEAR);
        String movieType = getIntent().getStringExtra(EXTRA_TYPE);
        String posterUrl = getIntent().getStringExtra(EXTRA_POSTER);

        // data to views
        title.setText(movieTitle);
        year.setText(movieYear);
        type.setText(movieType);

        Picasso.get()
                .load(posterUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(poster);
    }
}
