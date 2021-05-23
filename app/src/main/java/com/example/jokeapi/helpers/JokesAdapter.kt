package com.example.jokeapi.helpers

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapi.R
import com.example.jokeapi.activities.JokeDetailActivity
import com.example.jokeapi.models.MyJoke

class JokesAdapter(private val jokesList: List<MyJoke>) : RecyclerView.Adapter<JokesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.joke_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return jokesList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${jokesList.size} ")


        return holder.bind(jokesList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var jokeType = itemView.findViewById<TextView>(R.id.textView_main_type)
        var jokeMain = itemView.findViewById<TextView>(R.id.textView_main_joke)
        fun bind(joke: MyJoke) {
            jokeType.text = joke.type
            jokeMain.text = joke.setup

            jokeMain.setOnClickListener {
                val specificJokeIntent = Intent(jokeMain.context, JokeDetailActivity::class.java)
                specificJokeIntent.putExtra(JokeDetailActivity.EXTRA_JOKE, joke)
                jokeMain.context.startActivity(specificJokeIntent)
            }
        }

    }
}
