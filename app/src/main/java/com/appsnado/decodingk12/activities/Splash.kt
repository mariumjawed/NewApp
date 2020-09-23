package com.appsnado.decodingk12.activities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Base64
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.appsnado.decodingk12.R
import com.appsnado.decodingk12.helper.SharedPreferenceManager
import com.mikhaellopez.rxanimation.RxAnimation
import com.mikhaellopez.rxanimation.fadeIn
import com.mikhaellopez.rxanimation.resize
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_splash.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class Splash : AppCompatActivity() {

    private val ANIMATIONS_DELAY = 0
    private val ANIMATIONS_TIME_OUT: Long = 3000
    private val composite = CompositeDisposable()
    var subscribe: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        printHashKey(baseContext)
        //        contParentLayout.setVisibility(View.INVISIBLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //   val txtVersionNumber: TextView = findViewById(R.id.txtVersionNumber)

        try {
            val manager = packageManager
            val info = manager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            //txtVersionNumber.text = "Build Version: " + info.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            //txtVersionNumber.text = ""
            e.printStackTrace()
        }

    }

    private fun changeActivity(activityClass: Class<*>) {
        RxAnimation.together(
            imgLogo.fadeIn(ANIMATIONS_TIME_OUT),
            //  imgLogo.rotation(360f, ANIMATIONS_TIME_OUT )
            imgLogo.resize(200, 200, ANIMATIONS_TIME_OUT)
        ).subscribe()



        Handler().postDelayed(/*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            {
                val i: Intent = Intent(this@Splash, activityClass)
                // This method will be executed once the timer is over
                // Start your app main activity

                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                // close this activity
                finish()
            }, 1000 + ANIMATIONS_TIME_OUT.toLong())
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (hasFocus) {


        }
    }


    override fun onDestroy() {

        super.onDestroy()

    }

    fun printHashKey(context: Context) { // Add code to print out the key hash
        try {
            val info = context.packageManager.getPackageInfo(
                context.packageName,
                PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }
    }

    companion object {
        private val TAG = "SPLASH SCREEN"
    }
}