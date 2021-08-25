package br.trainingForme.com

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.trainingForme.com.databinding.ActivityListaAlunoBinding
import br.trainingForme.com.databinding.ItemVazioBinding
import br.trainingForme.com.databinding.UserItemAlunoBinding
import br.trainingForme.com.model.Users
import br.trainingForme.com.ui.GenericListAdapter
import br.trainingForme.com.ui.MyAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class ListaAlunos : AppCompatActivity() {

    private lateinit var binding: ActivityListaAlunoBinding
    private lateinit var dbref: DatabaseReference
    private lateinit var userRecycleview: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userArrayList = arrayListOf()
        getUserData()

    }

    private fun setupRecycler() {
        userRecycleview = findViewById(R.id.recyclerview_aluno)
        userRecycleview.layoutManager = LinearLayoutManager(this)
        userRecycleview.setHasFixedSize(true)

        userRecycleview.adapter = object : GenericListAdapter<Users>(
            R.layout.user_item_aluno,
            R.layout.item_vazio,
            bind = { item, holder, _ ->
                with(holder.itemView) {

                    val viewBinding = UserItemAlunoBinding.bind(this)

                    item.nome?.let { nome ->
                        viewBinding.txtNome.text = nome
                    }

                    item.telefone?.let { number ->
                        viewBinding.txtTelefone.text = number
                    }

                    viewBinding.cardAluno.setOnClickListener {

                    }

                }
            },
            bindEmpty = { holder ->
                with(holder.itemView) {

                    val viewBinding = ItemVazioBinding.bind(this)
                    viewBinding.txtVazio.text = getText(R.string.item_vazio)
                }
            }
        ) {}.apply {
            submitList(userArrayList)
        }

    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Users")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {

                        val user = userSnapshot.getValue(Users::class.java)
                        user?.let { aluno ->
                            userArrayList.add(aluno)

                            setupRecycler()
                        }

                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
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