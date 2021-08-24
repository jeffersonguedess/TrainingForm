package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.trainingForme.com.Model.Users
import br.trainingForme.com.databinding.ActivityListaAlunoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference


class ListaAlunos : AppCompatActivity() {

    private lateinit var binding: ActivityListaAlunoBinding
    private lateinit var dbref: DatabaseReference
    private lateinit var userRecycleview: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRecycleview = findViewById(R.id.recyclerview_aluno)
        userRecycleview.layoutManager = LinearLayoutManager(this)
        userRecycleview.setHasFixedSize(true)

        userArrayList = arrayListOf<Users>()
        //getU

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