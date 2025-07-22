package ca.georgiancollege.movie_app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movies = new ArrayList<>();

    // Constructor
    public MovieAdapter() {
    }

    // Update movie list
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public void updateMovies(ArrayList<Movie> newMovies) {
        movies.clear();
        movies.addAll(newMovies);
        notifyDataSetChanged();
    }

    // Inflate layout for each row
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);  // Make sure your XML is named movie_item.xml
        return new MovieViewHolder(view);
    }

    // Bind data to each row
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.titleText.setText(movie.getTitle());
        holder.yearText.setText(movie.getYear());

        // Click listener for each movie row
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivity.EXTRA_TITLE, movie.getTitle());
            intent.putExtra(MovieDetailActivity.EXTRA_YEAR, movie.getYear());
            intent.putExtra(MovieDetailActivity.EXTRA_TYPE, movie.getType());
            intent.putExtra(MovieDetailActivity.EXTRA_POSTER, movie.getPoster());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    // ViewHolder for movie_item.xml
    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, yearText;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.movieTitle);  // ID from movie_item.xml
            yearText = itemView.findViewById(R.id.movieYear);    // ID from movie_item.xml
        }
    }
}
