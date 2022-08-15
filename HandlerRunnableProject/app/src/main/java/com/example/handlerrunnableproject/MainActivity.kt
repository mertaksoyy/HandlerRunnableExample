package com.example.handlerrunnableproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var numara = 0
    var runnable : Runnable = Runnable{}
    var handler = Handler(Looper.myLooper()!!)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonBasla.setOnClickListener {
            numara = 0

            runnable = object :Runnable{
                override fun run() {
                    numara +=1
                    textView.text = "Sayaç :${numara}"
                    handler.postDelayed(runnable,1000)  // handlerın görevi runnable kullabılabilir hale getirmek
                }
            }
            handler.post(runnable) //runnable ı çalıştıran satır
        }


        buttonBitir.setOnClickListener {

            handler.removeCallbacks(runnable)
            numara = 0
            textView.text = "Sayaç :0 "
        }

    }
}