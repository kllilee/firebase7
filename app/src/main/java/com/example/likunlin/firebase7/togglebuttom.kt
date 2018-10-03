package com.example.likunlin.firebase7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_togglebuttom.*

class togglebuttom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_togglebuttom)

        tgb_check.setOnCheckedChangeListener(object:CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(CompoundButton: CompoundButton?, isChecked: Boolean) {
                Toast.makeText(this@togglebuttom,isChecked.toString(),Toast.LENGTH_SHORT).show()
            }

        })
    }
}
