package com.example.escolhas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_escolher_items.*
import kotlin.random.Random

class EscolherItems : AppCompatActivity() {

    var position:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolher_items)
        val topCorrect : Boolean = Random.nextBoolean()
        setTextsNoActivityChange(topCorrect)

        //clicks dos botoes
        btnTop.setOnClickListener {
            if (topCorrect){
                if (position > 3){
                    ganhou()
                }
                else{
                    setTextsNoActivityChange(topCorrect)
                }
            }
            else{
                escolhaErrada()
            }
        }
        btnBot.setOnClickListener {
            if (!topCorrect){
                if (position > 3){
                    ganhou()
                }
                else{
                    setTextsNoActivityChange(topCorrect)
                }
            }
            else{
                escolhaErrada()
            }
        }
    }

    private fun escolhaErrada(){
        val intent = Intent(this, GameLost::class.java)
        intent.putExtra("fase", position)
        startActivity(intent)
    }
    private fun ganhou(){
        val intent = Intent(this, GameWon::class.java)
        startActivity(intent)
    }

    private fun setTextsNoActivityChange(topCorrect:Boolean){
        val array = resources.getStringArray(R.array.levelTexts)
        val arrayButCorrect = resources.getStringArray(R.array.buttonCorrect)
        val arrayButWrong = resources.getStringArray(R.array.buttonWrong)
        if (topCorrect){
            btnTop.text = arrayButCorrect[position]
            btnBot.text = arrayButWrong[position]
        }
        else{
            btnTop.text = arrayButWrong[position]
            btnBot.text = arrayButCorrect[position]
        }
        tvInformation.text = array[position]
        position++
    }
}
