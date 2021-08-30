package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import br.trainingForme.com.databinding.ActivityCadastroAlunoBinding
import com.google.android.material.snackbar.Snackbar

class CadastroAluno : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroAlunoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        toolbarCadastroAluno()


    }

    private fun toolbarCadastroAluno() {
        val toolbarDetalhes = binding.toolbarCadastroAlunos
        toolbarDetalhes.navigationIcon = AppCompatResources.getDrawable(this, R.drawable.ic_voltar)
        toolbarDetalhes.setOnClickListener {
            val intent = Intent(this, ListaAlunos::class.java)
            startActivity(intent)
            finish()
        }
    }
}