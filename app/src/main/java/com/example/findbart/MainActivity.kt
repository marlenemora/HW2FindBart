package com.example.findbart

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var bartAnimation: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bartAnimation = findViewById(R.id.imageView)
        //bartAnimation.animate().translationXBy(-2000f)

        bartAnimation.animate().rotation(720f).duration = 2000
    }//onCreate
    fun playGame (view : View) {
        val intent = Intent(this, FindImage::class.java)
        startActivity(intent)
    }//playGame
}//MainActivity