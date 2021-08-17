package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import br.trainingForme.com.databinding.ActivityFormeTreinoBinding
import com.google.firebase.auth.FirebaseAuth


class FormeTreino : AppCompatActivity() {

    private lateinit var binding: ActivityFormeTreinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeTreinoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_deslogar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_sair -> {
                FirebaseAuth.getInstance().signOut()
                voltarTelaLogin()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun voltarTelaLogin() {
        val intent = Intent(this, FormeLogin::class.java)
        startActivity(intent)
        finish()
    }


}