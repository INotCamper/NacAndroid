package com.example.escolhas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_lost.*

class GameLost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_lost)
        val extras = intent.extras
        val faseAtual = extras!!.getInt("fase")
        val array = resources.getStringArray(R.array.loseInLevel)
        tvLost.text = array[faseAtual -1]

        //botao voltar
        btnBackLost.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
