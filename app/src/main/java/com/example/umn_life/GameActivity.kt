package com.example.umn_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.*

class GameActivity : AppCompatActivity() {
    private var currentSemester = 1
    private var wktJam = 0
    private var wktMenit = 0
    private var status = ""
    private var waktu = "malam "
    private lateinit var runnable: Runnable
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

        runnable = Runnable {
            jam.text = String.format("%02d:%02d", wktJam, wktMenit)
            wktMenit++
            if (wktMenit == 60){
                wktMenit = 0
                wktJam++
            }

            when(wktJam){
                6 -> {
                    waktu = "pagi "
                    img.setBackgroundResource(R.drawable.pagi)
                    salam.text = "Selamat "+waktu+intent.getStringExtra("name")
                }
                9 -> {
                    waktu = "siang "
                    img.setBackgroundResource(R.drawable.siang)
                    salam.text = "Selamat "+waktu+intent.getStringExtra("name")
                }
                15 -> {
                    waktu = "sore "
                    img.setBackgroundResource(R.drawable.sore)
                    salam.text = "Selamat "+waktu+intent.getStringExtra("name")
                }
                18 -> {
                    waktu = "malam "
                    img.setBackgroundResource(R.drawable.malam)
                    salam.text = "Selamat "+waktu+intent.getStringExtra("name")
                }
                24 -> wktJam = 0
            }

            when(status){
                "makan" -> {
                    if (wktMenit%12 == 0){
                        pgsGame.progress--
                        pgsSleep.progress--
                    }
                    if (wktMenit%4 == 0) pgsEat.progress++
                }
                "tidur" -> {
                    if (wktMenit%12 == 0){
                        pgsEat.progress--
                        pgsGame.progress--
                    }
                    if (wktMenit%4 == 0) pgsSleep.progress++
                }
                "main" -> {
                    if (wktMenit%12 == 0){
                        pgsEat.progress--
                        pgsSleep.progress--
                    }
                    if (wktMenit%4 == 0) pgsGame.progress++
                }
                "belajar" -> {
                    if (wktMenit%6 == 0){
                        pgsEat.progress--
                        pgsGame.progress--
                        pgsSleep.progress--
                        pgsStudy.progress++
                    }
                    if (pgsStudy.progress == pgsStudy.max){
                        currentSemester++
                        semester.text = "Semester "+currentSemester.toString()
                        pgsStudy.progress = 0
                        Toast.makeText(this, "Selamat anda lulus semester", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {
                    if (wktMenit%12 == 0){
                        pgsEat.progress--
                        pgsGame.progress--
                        pgsSleep.progress--
                    }
                }
            }

            when(pgsEat.progress){
                0 -> {
                    Toast.makeText(this, "Kamu kurang nutrisi dan keluar dari kuliah", Toast.LENGTH_SHORT).show()
                    pgsEat.progress = 50
                    pgsGame.progress = 50
                    pgsSleep.progress = 50
                    pgsStudy.progress = 0
                    currentSemester = 1
                    semester.text = "Semester "+currentSemester.toString()
                }
                25 -> Toast.makeText(this, "Kamu lapar, sebaiknya makan dulu", Toast.LENGTH_SHORT).show()
                pgsEat.max -> {
                    Toast.makeText(this, "Kamu sudah kenyang", Toast.LENGTH_SHORT).show()
                    status = ""
                }
            }

            when(pgsSleep.progress){
                0 -> {
                    Toast.makeText(this, "Kamu pingsan karena capek dan keluar dari kuliah", Toast.LENGTH_SHORT).show()
                    pgsEat.progress = 50
                    pgsGame.progress = 50
                    pgsSleep.progress = 50
                    pgsStudy.progress = 0
                    currentSemester = 1
                    semester.text = "Semester "+currentSemester.toString()
                }
                25 -> Toast.makeText(this, "Kamu lelah, sebaiknya tidur dulu", Toast.LENGTH_SHORT).show()
                pgsSleep.max -> {
                    Toast.makeText(this, "Kamu sudah segar", Toast.LENGTH_SHORT).show()
                    status = ""
                }
            }

            when(pgsGame.progress){
                0 -> {
                    Toast.makeText(this, "Kamu stress dan keluar dari kuliah", Toast.LENGTH_SHORT).show()
                    pgsEat.progress = 50
                    pgsGame.progress = 50
                    pgsSleep.progress = 50
                    pgsStudy.progress = 0
                    currentSemester = 1
                    semester.text = "Semester "+currentSemester.toString()
                }
                25 -> Toast.makeText(this, "Kamu bosan, sebaiknya istirahat main dulu", Toast.LENGTH_SHORT).show()
                pgsGame.max -> {
                    Toast.makeText(this, "Kamu sudah kebanyakan main", Toast.LENGTH_SHORT).show()
                    status = ""
                }
            }
            Handler(Looper.getMainLooper()).postDelayed(runnable, 250)
        }
        Handler(Looper.getMainLooper()).post(runnable)

        img.setImageResource(intent.getIntExtra("avatar", R.drawable.man))
        salam.text = "Selamat "+waktu+intent.getStringExtra("name")
        semester.text = "Semester "+currentSemester.toString()

        btnEat.setOnClickListener {
            if (status.equals("makan")) status = ""
            else status = "makan"
        }
        btnSleep.setOnClickListener {
            if (status.equals("tidur")) status = ""
            else status = "tidur"
        }
        btnGame.setOnClickListener {
            if (status.equals("main")) status = ""
            else status = "main"
        }
        btnStudy.setOnClickListener {
            if (status.equals("belajar")) status = ""
            else status = "belajar"
        }
    }
}