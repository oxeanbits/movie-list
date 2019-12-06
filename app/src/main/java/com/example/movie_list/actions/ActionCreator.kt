package com.example.movie_list.actions

import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.Actions.LIST_MOVIES
import com.example.movie_list.actions.Actions.UPDATE_MOVIE_LIST
import com.example.movie_list.actions.Actions.SHOW_MOVIE
import com.example.movie_list.model.Movie
import com.example.movie_list.model.payloads.ChangePagePayload
import com.github.raulccabreu.redukt.actions.Action

class ActionCreator private constructor() {

    private object Holder {
        val INSTANCE  = ActionCreator()
    }

    companion object {
        val instance: ActionCreator by lazy { Holder.INSTANCE }
    }

    private fun asyncDispatch(action: Action<*>) {
        MovieListApp.redukt.dispatch(action, true)
    }

    fun listMovies(payload: ChangePagePayload) {
        asyncDispatch(Action(LIST_MOVIES, payload))
    }

    fun showMovie() {
        asyncDispatch(Action(SHOW_MOVIE, true))
    }

    fun updateMovieList(list: List<Movie>) {
        asyncDispatch(Action(UPDATE_MOVIE_LIST, list))
    }
}