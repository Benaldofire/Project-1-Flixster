package com.example.flixster

import org.json.JSONArray

//represent 1 movie object to display in the UI, bundle up different data
data class Movie(
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
    private val backdrop: String
) {
    val posterImgUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    val backdropImgUrl = "https://image.tmdb.org/t/p/w342/$backdrop"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getString("backdrop_path")
                    )
                )
            }
            return movies
        }
    }
}

