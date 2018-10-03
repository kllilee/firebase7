package com.example.likunlin.firebase7

import android.app.Activity
import android.app.KeyguardManager
import android.hardware.fingerprint.FingerprintManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fingerprint.*

class fingerprint : AppCompatActivity() {

    var mkeyguardManager : KeyguardManager? =null
    var mFingerprintManager : FingerprintManager? = null
    var CancellationSignal:CancellationSignal? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint)

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
                        fingerprint_text.text = "指紋辨識成功"
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        Log.e("", "onAuthenticationFailed")
                        fingerprint_text.text = "指紋辨識失敗"
                    }
                },null)
    }
}
