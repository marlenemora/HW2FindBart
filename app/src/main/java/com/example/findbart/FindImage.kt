package com.example.findbart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView

class FindImage : AppCompatActivity() {
    lateinit var countDownTimer: CountDownTimer
    var counterActive = false
    lateinit var timerView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_image)

        timerView = findViewById(R.id.timerView)

        startTimer()

    }//onCreate


    fun startTimer () {
        if (!counterActive) {
            counterActive = true

            countDownTimer = object : CountDownTimer(16000, 1000) {
                override fun onTick(p0: Long) {
                    updateTimer((p0 / 1000).toInt())
                }

                override fun onFinish() {
                    //TODO("Not yet implemented")
                }
            }// countDownTimer
            countDownTimer.start()
        }//startTimer
        else {
            countDownTimer.cancel()
            counterActive = false
        }
    }//startTimer
    fun updateTimer(secondsLeft : Int) {
        val minutes = secondsLeft / 60
        val seconds = secondsLeft - minutes * 60
        var secondString = seconds.toString()
        if (seconds <= 9) {
            secondString = "0$secondString"
        }
        timerView.text =  minutes.toString()+":" + secondString
    }//updateTimer
}//FindImage
