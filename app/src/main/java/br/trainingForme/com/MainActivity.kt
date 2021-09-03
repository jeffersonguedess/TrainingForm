package br.trainingForme.com

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (supportActionBar ?: return).hide()

        Handler(Looper.getMainLooper()).postDelayed({
            abrirtelalogin()

        }, 2000)


    }

    private fun abrirtelalogin() {
        val intent = Intent(this, FormeLogin::class.java)
        startActivity(intent)
        finish()
    }

}