package com.example.likunlin.firebase7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_anim.*

class anim : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

       val anim_1 = AnimationUtils.loadAnimation(this,R.anim.anim1)

        anim_constraint.startAnimation(anim_1)

    }
}
