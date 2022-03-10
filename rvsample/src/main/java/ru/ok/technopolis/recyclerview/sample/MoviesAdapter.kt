package ru.ok.technopolis.recyclerview.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ok.technopolis.recyclerview.sample.MoviesAdapter.MovieViewHolder

class MoviesAdapter(
    private val movies: List<Movie>,
    private val onMovieClickListener: Listener,
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.movie_item, viewGroup, false)
        view.setOnClickListener { v: View -> onMovieClickListener.onMovieClick(v.tag as Movie) }
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, i: Int) {
        val movie = movies[i]
        viewHolder.bind(movie)
        viewHolder.itemView.tag = movie
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.movie_item__tv_name)
        private val descriptionTextView: TextView =
            itemView.findViewById(R.id.movie_item__tv_description)
        private val posterImageView: ImageView = itemView.findViewById(R.id.movie_item__iv_poster)

        fun bind(movie: Movie) {
            nameTextView.text = movie.name
            descriptionTextView.text = movie.description
            posterImageView.setImageResource(movie.poster)
        }

    }

    interface Listener {
        fun onMovieClick(movie: Movie)
    }
}