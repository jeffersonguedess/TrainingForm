package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.trainingForme.com.databinding.ActivityFormeCadastroBinding
import br.trainingForme.com.databinding.ActivityFormeLoginBinding

class FormeLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormeLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()


        binding.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormeCadastro::class.java)
            startActivity(intent)
        }
    }
}