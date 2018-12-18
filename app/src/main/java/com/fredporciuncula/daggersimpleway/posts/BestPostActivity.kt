package com.fredporciuncula.daggersimpleway.posts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.fredporciuncula.daggersimpleway.R
import com.fredporciuncula.daggersimpleway.di.getViewModel
import com.fredporciuncula.daggersimpleway.di.injector
import kotlinx.android.synthetic.main.post_activity.*

class BestPostActivity : AppCompatActivity() {

    private val viewModel by lazy {
        getViewModel { injector.bestPostViewModel }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_activity)

        if (savedInstanceState == null) viewModel.loadPosts()

        viewModel.bestPost().observe(this, Observer { result ->
            result?.let { bestPost.text = it.body }
        })
    }
}
