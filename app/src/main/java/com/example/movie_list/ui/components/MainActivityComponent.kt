package com.example.movie_list.ui.components

import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import trikita.anvil.Anvil
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

abstract class MainActivityComponent : AppActivityLifecycleComponent() {

    fun getView(): View {
        return object : RenderableView(this) {
            override fun view() {
                linearLayout {
                    size(MATCH, MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)
                    gravity(CENTER)
                    textView {
                        size(WRAP,WRAP)
                        text("Hello! Click on the button below to show our movies list!")
                        textSize(64f)
                        gravity(CENTER_HORIZONTAL)
                    }
                    linearLayout{
                        size(WRAP,WRAP)
                        orientation(LinearLayout.HORIZONTAL)
                        gravity(CENTER)
                        button {
                            size(WRAP,WRAP)
                            text("Populate List")
                            textSize(56f)
                            onClick {
                                movies.add(MovieItem("title1","2010","poster1","comedy1"))
                                movies.add(MovieItem("title2","2011","poster2","comedy2"))
                                movies.add(MovieItem("title3","2012","poster3","comedy3"))
                                movies.add(MovieItem("title4","2013","poster4","comedy4"))
                                movies.add(MovieItem("title5", "2041", "poster5", "comedy5"))
                                movies.add(MovieItem("title6","2016","poster6","comedy6"))
                                movies.add(MovieItem("title7", "2015", "poster7", "comedy7"))
                                it.isEnabled = false
                                //ActionCreator.instance.populateMovieList(movies)
                            }
                        }
                        button {
                            size(WRAP, WRAP)
                            text("List movies")
                            textSize(56f)
                            onClick {
                                ActionCreator.instance.listMovies(movies)
                            }
                        }
                    }
                }
            }
        }
    }

}