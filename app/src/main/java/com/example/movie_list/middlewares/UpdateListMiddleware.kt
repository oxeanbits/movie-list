package com.example.movie_list.middlewares

import android.content.Context
import android.util.Log
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.actions.Actions
import com.example.movie_list.api.TmdbApi.Companion.api
import com.github.raulccabreu.redukt.middlewares.BaseAnnotatedMiddleware
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.model.MoviesResponse
import com.github.raulccabreu.redukt.actions.Action
import com.github.raulccabreu.redukt.middlewares.BeforeAction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateListMiddleware : BaseAnnotatedMiddleware<AppState>() {

    @BeforeAction(Actions.UPDATE_MOVIE_LIST)
    fun getListFromApi(state: AppState, action: Action<*>) {
        api.getMovies(page = 1)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            ActionCreator.instance.updateMovieList2(responseBody.movies)
                            Log.d("Repository", "Movies: ${responseBody.movies}")
                        } else {
                            Log.d("Repository", "Failed to get response")
                        }
                    }
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.e("Repository", "onFailure", t)
                }
        })
        /*var movies = mutableListOf<Movie>()
        (1..10).forEach {
            movies.add(
                Movie(
                    "id${(1..12).shuffled().first()}",
                    "title${(1..12).shuffled().first()}",
                    "overview${(1..12).shuffled().first()}",
                    "201${(1..9).shuffled().first()}",
                    "poster${(1..12).shuffled().first()}",
                    "backdrop${(1..12).shuffled().first()}")
            )
        }
        ActionCreator.instance.updateMovieList2(movies)*/
    }

}