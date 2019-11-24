package com.example.movie_list

import android.view.View
import android.widget.LinearLayout
import android.content.Intent
import com.example.movie_list.model.Movie

import trikita.anvil.DSL.*
import trikita.anvil.RenderableAdapter
import trikita.anvil.RenderableView

import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies


class ListAdapter<T : Any>(private val renderable: (T) -> Unit) : RenderableAdapter() {

    var items: List<T> = mutableListOf()
        set(items) {
            field = items
            notifyDataSetChanged()
        }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.let { it::class.java.hashCode() } ?: 0
    }

    override fun getItem(position: Int): T? {
        return items.getOrNull(position)
    }

    override fun view(position: Int) {
        getItem(position)?.let { renderable.invoke(it) }
    }

}
