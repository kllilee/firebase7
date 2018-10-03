package com.example.likunlin.firebase7

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_circle_progress_bar.*
import kotlin.concurrent.thread

class CircleProgressBar : AppCompatActivity() {


    private val text = object : Thread(){
        override fun run() {
            super.run()

            for (i in 0 ..100){

                try {
                    Thread.sleep(10)
                    val msg = Message()
                    msg.what = 1
                    count.num = i
                    mHandler.sendMessage(msg)
                }catch (e:InterruptedException){
                    e.printStackTrace()
                }

            }


        }
    }

    private val mHandler = object: Handler(){
        override fun handleMessage(msg: Message?) {
            when(msg!!.what){
                1-> {
                    tv_start.text = count.num.toString()
                    tpc_progress.setProgress(count.num,100f)

                }


            }

            super.handleMessage(msg)
        }
    }
    private val btn_start_click = View.OnClickListener{

        val t = Thread(text)
        t.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_progress_bar)

        btn_start.setOnClickListener(btn_start_click)


    }



}



object count{
    var num:Int = 0

    fun onlinstening(){
        num = 50
        Log.v("test_lis","test_lis")
    }
}


