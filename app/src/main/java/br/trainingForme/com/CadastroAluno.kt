package br.trainingForme.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.trainingForme.com.databinding.ActivityCadastroAlunoBinding

class CadastroAluno : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroAlunoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}