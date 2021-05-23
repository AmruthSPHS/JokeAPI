package com.example.jokeapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jokeapi.R
import com.example.jokeapi.helpers.JokesAdapter
import com.example.jokeapi.models.MyJoke
import com.example.jokeapi.services.JokeService
import com.example.jokeapi.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJokes()
    }

    private fun loadJokes() {
        //initiate the service
        val destinationService = ServiceBuilder.buildService(JokeService::class.java)
        val requestCall = destinationService.getAffectedJokeList()

        requestCall.enqueue(object : Callback<List<MyJoke>> {

            override fun onResponse(call: Call<List<MyJoke>>, response: Response<List<MyJoke>>) {
                val jokeList = response.body() ?: emptyList<MyJoke>()
                Log.d(TAG, "onResponse: " + jokeList)
                joke_recycler.apply {
                    setHasFixedSize(true)
                    layoutManager = GridLayoutManager(this@MainActivity, 2)
                    adapter = JokesAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<MyJoke>>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }


        })

    }
}