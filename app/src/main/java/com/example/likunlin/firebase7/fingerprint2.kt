package com.example.likunlin.firebase7

import android.annotation.SuppressLint
import android.app.Activity
import android.app.KeyguardManager
import android.hardware.fingerprint.FingerprintManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fingerprint2.*

class fingerprint2 : AppCompatActivity() {

    var mkeyguardManager : KeyguardManager? =null
    var mFingerprintManager : FingerprintManager? = null
    var CancellationSignal: CancellationSignal? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint2)
        mkeyguardManager = getSystemService(Activity.KEYGUARD_SERVICE) as KeyguardManager
        mFingerprintManager = getSystemService(FingerprintManager::class.java)

        if (!mkeyguardManager!!.isDeviceSecure()){
            Toast.makeText(this, "Secure lock screen hasn't set up.\n" + "Go to 'Settings -> Security -> Fingerprint' to set up a fingerprint",
                    Toast.LENGTH_LONG).show()
            return;
        }
        if(!mFingerprintManager!!.isHardwareDetected()){
            Toast.makeText(this, "No Fingerprint reader", Toast.LENGTH_LONG).show()
            return
        }
        if(!mFingerprintManager!!.hasEnrolledFingerprints()){
            Toast.makeText(this, "Go to 'Settings -> Security -> Fingerprint' and register at least one fingerprint",
                    Toast.LENGTH_LONG).show()
            return
        }

        startListing()


    }


    override fun onPause() {
        super.onPause()
        CancellationSignal!!.cancel()
        CancellationSignal =null
    }

    private val mHandler_1= @SuppressLint("HandlerLeak")
    object:Handler(){
        override fun handleMessage(msg: Message?) {
            when(msg!!.what){
                1-> {
                    tpc_progress2.setProgress(count.num,100f)
                }
            }
            super.handleMessage(msg)

        }
    }
    private val fingerprint_task = object: Thread() {

        override fun run() {
            super.run()
            for (i in 0 ..100){
                try {

                    if(count.num == 50){
                        Thread.sleep(5000)
                    }

                    Thread.sleep(3)
                    val msg = Message()
                    msg.what = 1
                    count.num = i
                    mHandler_1.sendMessage(msg)





                }catch (e:InterruptedException){
                    e.printStackTrace()
                }

            }

        }
    }

    fun startListing() {
        CancellationSignal = CancellationSignal()
        mFingerprintManager!!.authenticate(null, CancellationSignal, 0,
                object: FingerprintManager.AuthenticationCallback() {


                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                        super.onAuthenticationError(errorCode, errString)
                        Log.e("", "error " + errorCode + " " + errString);
                    }

                    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult?) {
                        super.onAuthenticationSucceeded(result)
                        Log.i("", "onAuthenticationSucceeded")
                        tpc_progress2.setOnNumchange(100)

                        fingerprint2_text.text = "指紋辨識成功"
                        fingerprint2_text.visibility = View.VISIBLE
                        val t = Thread(fingerprint_task)
                        t.start()

                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        Log.e("", "onAuthenticationFailed")
                        fingerprint2_text.text = "指紋辨識失敗"
                    }
                },null)
    }


}
