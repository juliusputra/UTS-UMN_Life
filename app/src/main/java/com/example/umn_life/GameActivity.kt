package com.example.umn_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val img: ImageView = findViewById(R.id.ImgAvatar)
        val txt: TextView = findViewById(R.id.salam)

        img.setImageResource(intent.getIntExtra("avatar", R.drawable.man))
        txt.setText("Selamat "+"waktu "+intent.getStringExtra("name"))
    }
}