package com.example.escolhas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
            val intent = Intent(this, EscolherItems::class.java)
            //qual fase ele está
            intent.putExtra("fase", 1)
            startActivity(intent)
        }
    }
}
