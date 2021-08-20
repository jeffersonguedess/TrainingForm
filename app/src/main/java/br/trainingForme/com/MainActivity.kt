package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            abrirtelalogin()

        },2000)

//        FacebookSdk.fullyInitialize()
//        AppEventsLogger.activateApp(application)
    }

    private fun abrirtelalogin(){
        val intent = Intent(this,FormeLogin::class.java)
        startActivity(intent)
        finish()
    }
    
}