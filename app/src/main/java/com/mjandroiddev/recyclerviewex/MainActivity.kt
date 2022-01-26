package com.mjandroiddev.recyclerviewex

import android.content.res.TypedArray
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.TypedArrayUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyListAdapter()

    }
}

class MyListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val text = TextView(parent.context)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        text.setBackgroundColor(Color.LTGRAY)
        text.setPadding(8, 8, 8, 8)

        return MyVH(text)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyVH).bind()
    }

    override fun getItemCount(): Int {
        return 25
    }

}


class MyVH(view: View) : RecyclerView.ViewHolder(view) {
    val textView = view as TextView
    fun bind() {
        textView.setTextColor(ContextCompat.getColor(textView.context, R.color.purple_500))
        textView.text = textView.context.getString(
            R.string.placeholer,
            adapterPosition.plus(1),
            "my String",
            3.14f
        )
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, textView.text, Toast.LENGTH_SHORT).show()
        }
    }
}