package com.example.movie_list.model

data class AppState (
    val list: List<Movie>? = null,
    val movieClicked: Boolean? = null,
    val pageChangeRequest: Boolean? = null
)