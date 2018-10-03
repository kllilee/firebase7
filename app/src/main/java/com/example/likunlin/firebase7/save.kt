package com.example.likunlin.firebase7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_save.*

class save : AppCompatActivity() {
    val myref = FirebaseDatabase.getInstance()

    private val btn_firebase_write_click = View.OnClickListener{
        val useref=myref.getReference("test1").child("mem").child("4")
        useref.setValue(mem(name = "004",name1 = "004-1"))
        useref.child("name2").setValue(mem_name2(name2_1 = "004-2-01",name2_2 = "004-2-02"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        btn_firebase_write.setOnClickListener(btn_firebase_write_click)

    }
}


class mem(val name:String ,val name1:String)
class mem_name2(val name2_1:String,val name2_2:String)


