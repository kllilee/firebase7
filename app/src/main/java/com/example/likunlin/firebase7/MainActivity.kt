package com.example.likunlin.firebase7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val btn_Aread_click = View.OnClickListener{
        val intent = Intent(this,read::class.java)
        startActivity(intent)

    }

    private val btn_Awrite_click = View.OnClickListener{
        val intent = Intent(this,save::class.java)
        startActivity(intent)
    }

    private val btn_Atogglebuttom_click = View.OnClickListener{
        val intent = Intent(this,togglebuttom::class.java)
        startActivity(intent)
    }

    private val btn_fingerprint_click = View.OnClickListener{
        val intent = Intent(this,fingerprint::class.java)
        startActivity(intent)
    }

    private val btn_fingerprint2_click = View.OnClickListener{
        val intent = Intent(this,fingerprint2::class.java)
        startActivity(intent)
    }

    private val btn_cycle_process_click = View.OnClickListener{
        val intent = Intent(this,CircleProgressBar::class.java)
        startActivity(intent)
    }

    private val btn_anim_click = View.OnClickListener{
        val intent = Intent(this,anim::class.java)
        startActivity(intent)
    }

    private val btn_password_click= View.OnClickListener{
        val intent = Intent(this,passwordeditview::class.java)
        startActivity(intent)
    }

    private val btn_webview_click = View.OnClickListener{
        val intent = Intent(this,webview::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Aread.setOnClickListener(btn_Aread_click)
        btn_Awrite.setOnClickListener(btn_Awrite_click)
        btn_Atogglebuttom.setOnClickListener(btn_Atogglebuttom_click)
        btn_fingerprint.setOnClickListener(btn_fingerprint_click)
        btn_fingerprint2.setOnClickListener(btn_fingerprint2_click)
        btn_cycle_process.setOnClickListener(btn_cycle_process_click)
        btn_anim.setOnClickListener(btn_anim_click)
        btn_password.setOnClickListener(btn_password_click)
        btn_webview.setOnClickListener(btn_webview_click)
    }
}
