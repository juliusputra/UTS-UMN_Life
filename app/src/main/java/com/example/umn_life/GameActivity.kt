package com.example.umn_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    private var currentSemester = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val img: ImageView = findViewById(R.id.ImgAvatar)
        val salam: TextView = findViewById(R.id.salam)
        val semester: TextView = findViewById(R.id.semester)
        val jam: TextView = findViewById(R.id.jam)
        val pgsEat: ProgressBar = findViewById(R.id.pgsEat)
        val pgsSleep: ProgressBar = findViewById(R.id.pgsSleep)
        val pgsGame: ProgressBar = findViewById(R.id.pgsGame)
        val pgsStudy: ProgressBar = findViewById(R.id.pgsStudy)
        val btnEat: Button = findViewById(R.id.btnEat)
        val btnSleep: Button = findViewById(R.id.btnSleep)
        val btnGame: Button = findViewById(R.id.btnGame)
        val btnStudy: Button = findViewById(R.id.btnStudy)

        img.setImageResource(intent.getIntExtra("avatar", R.drawable.man))
        salam.text = "Selamat "+"waktu "+intent.getStringExtra("name")
        semester.text = "Semester "+currentSemester.toString()

        btnEat.setOnClickListener {  }
        btnSleep.setOnClickListener {  }
        btnGame.setOnClickListener {  }
        btnStudy.setOnClickListener {  }
    }
}