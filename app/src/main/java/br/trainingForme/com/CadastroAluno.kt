package br.trainingForme.com

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.content.res.AppCompatResources
import br.trainingForme.com.databinding.ActivityCadastroAlunoBinding
import com.google.android.material.snackbar.Snackbar
import android.R.color
import android.graphics.PorterDuffColorFilter
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat


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