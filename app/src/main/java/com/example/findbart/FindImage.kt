package com.example.findbart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class FindImage : AppCompatActivity() {
    lateinit var countDownTimer: CountDownTimer
    var counterActive = false
    lateinit var timerView : TextView
    var firstGame = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_image)

        timerView = findViewById(R.id.timerView)

       if (firstGame) {
           startTimer()
       }//if
        else {
           countDownTimer.cancel()

       }

    }//onCreate

    fun startTimer () {
        if (!counterActive) {
            counterActive = true

            countDownTimer = object : CountDownTimer(11000, 1000) {
                override fun onTick(p0: Long) {
                    updateTimer((p0 / 1000).toInt())
                }

                override fun onFinish() {
                    resetTime()
                }
            }// countDownTimer
            countDownTimer.start()
        }//startTimer
        else {
            countDownTimer.cancel()
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
        failed()
    }//updateTimer

    fun wrong (view: View) {
        Toast.makeText(applicationContext, "WRONG", Toast.LENGTH_SHORT).show()
    }//wrong
    fun correct (view : View) {
        //Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT).show()
        firstGame = false
        countDownTimer.cancel()

        resetTime()

        val alertDialog = AlertDialog.Builder(this, R.style.AlertDialogStyle)
        alertDialog.apply {
            setTitle("CONGRATS! You found Bart!")
        }.create().show()

    }//correct

    fun resetTime(){
        counterActive = false
        timerView.text = "0:10"
    }//resetTime

    fun playAgain(view: View){
        countDownTimer.cancel()
        counterActive = false
        startTimer()
    }//playAgain

    fun failed () {
        if (timerView.text == "0:00") {
            val alertDialog = AlertDialog.Builder(this, R.style.AlertDialogStyle)
            alertDialog.apply {
                setTitle("LOSER, WHY CAN'T YOU FIND BART?! Try Again!")
            }.create().show()
        }

    }//failed
}//FindImage
