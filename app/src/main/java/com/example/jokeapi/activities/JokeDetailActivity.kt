package com.example.jokeapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jokeapi.R
import com.example.jokeapi.models.MyJoke
import kotlinx.android.synthetic.main.activity_joke_detail.*

class JokeDetailActivity : AppCompatActivity() {

    val TAG = "CountryDetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_detail)

        val joke = intent.getParcelableExtra<MyJoke>(EXTRA_JOKE)
        Log.d(TAG, "onCreate: " + joke)

        if(joke != null)
        {
            textView_detail_setup.text = joke.setup
            textView_detail_punch.text = joke.punchline
        }
    }

    companion object{
        val EXTRA_JOKE = "joke"
    }
}
