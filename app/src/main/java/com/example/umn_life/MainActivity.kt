package com.example.umn_life

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var currentAvatar = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val avatar: ImageView = findViewById(R.id.avatar)
        val name: EditText = findViewById(R.id.name)
        val left: ImageButton = findViewById(R.id.btnLeft)
        val right: ImageButton = findViewById(R.id.btnRight)
        val play: Button = findViewById(R.id.btnPlay)
        val avatarList: IntArray = intArrayOf(R.drawable.man, R.drawable.woman, R.drawable.amongus)

        left.setOnClickListener {
            if (currentAvatar == 0) currentAvatar = avatarList.size - 1
            else currentAvatar--
            avatar.setImageResource(avatarList[currentAvatar])
        }
        right.setOnClickListener {
            if (currentAvatar == avatarList.size - 1) currentAvatar = 0
            else currentAvatar++
            avatar.setImageResource(avatarList[currentAvatar])
        }

        play.setOnClickListener {
            if (name.text.toString() == "") Toast.makeText(this, "Tolong masukkan nama pemain", Toast.LENGTH_SHORT).show()
            else {
                val i = Intent(this, GameActivity::class.java)
                i.putExtra("name", name.text.toString())
                i.putExtra("avatar", avatarList[currentAvatar])
                startActivity(i)
            }
        }
    }
}
