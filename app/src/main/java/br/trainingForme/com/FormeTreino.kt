package br.trainingForme.com

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import br.trainingForme.com.databinding.ActivityFormeTreinoBinding

class FormeTreino : AppCompatActivity() {

    private lateinit var binding: ActivityFormeTreinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeTreinoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (supportActionBar ?: return).hide()
        toolbarCadastroAluno()

        val getName = intent.getStringExtra("nome") ?: ""

        binding.recebeNome.text = getName

    }

    private fun toolbarCadastroAluno() {
        val toolbarDetalhes = binding.toolbarCadastroTreino
        toolbarDetalhes.navigationIcon = AppCompatResources.getDrawable(this, R.drawable.ic_voltar)
        toolbarDetalhes.setOnClickListener {
            val intent = Intent(this, ListaAlunos::class.java)
            startActivity(intent)
            finish()
        }
    }

}