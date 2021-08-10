package br.trainingForme.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.content.res.AppCompatResources
import br.trainingForme.com.databinding.ActivityFormeCadastroBinding

class FormeCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormeCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()



    }

    private fun setupToolbar() {

        supportActionBar!!.hide()

        val toolbar = binding.toolbarFrameCadastro
        toolbar.title = getString(R.string.Titulo_cadastro)
        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.background = getDrawable(R.color.black_80) // Tem algum modo corre. E oque está errado?. Ponto de POG.
    }
}