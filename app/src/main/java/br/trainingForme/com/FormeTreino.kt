package br.trainingForme.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import br.trainingForme.com.databinding.ActivityFormeTreinoBinding

class FormeTreino : AppCompatActivity() {

    private lateinit var binding: ActivityFormeTreinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeTreinoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        setupToolbar()
    }


    private fun setupToolbar() {

        supportActionBar!!.hide()

        val toolbarFichaTreino = findViewById<Toolbar>(R.id.toolbar_fichaTreino)
        toolbarFichaTreino.setTitle(getString(R.string.ficha_treino))
        toolbarFichaTreino.setTitleMargin(200, 0, 100, 0)
        toolbarFichaTreino.setBackgroundColor(getColor(R.color.black_80))

    }

}