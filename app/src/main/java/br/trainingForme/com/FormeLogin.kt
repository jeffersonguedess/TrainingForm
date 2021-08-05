package br.trainingForme.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FormeLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forme_login)

        supportActionBar!!.hide()


    }
}