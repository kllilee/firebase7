package com.example.likunlin.firebase7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonToken
import android.util.JsonWriter
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_read.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class read : AppCompatActivity(),firebase_read {


    override fun on_success(arrayList: ArrayList<String>) {

        Log.v("data",arrayList.toString())
        tv_firebase_read.text = arrayList[1]

    }

    override fun on_fail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val myref = FirebaseDatabase.getInstance()


    private val btn_firebase_read_click = View.OnClickListener{

        var arrayList: ArrayList<String> = ArrayList()

        val useref=myref.getReference("test1").child("mem")
        useref.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(DatabaseError: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange( dataSnapshot: DataSnapshot?) {
                try {

                    dataSnapshot!!.children.iterator().forEach{
 //                       Log.d("data ",it.value.toString())
                        val JSONObject = JSONObject(it.value.toString())
                        val name = JSONObject.getJSONObject("name2").getString("name2_1")
                        arrayList.add(name)


                    }

                }catch (e: InterruptedException){
                    on_fail()

                }
                on_success(arrayList)
            }

        })


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        btn_firebase_read.setOnClickListener(btn_firebase_read_click)
    }


}
class firebase_read_object(val name:String,val name1:String,val name2:firebase_read_object_1){

}

class firebase_read_object_1(val name2_1:String,val name2_2:String)
interface firebase_read{
    fun on_success(arrayList: ArrayList<String>)
    fun on_fail()
}

