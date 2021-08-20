package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.trainingForme.com.databinding.ActivityFormeLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class FormeLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormeLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        

        verificaUsuarioLogado()

        binding.btnEntrar.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()
            val mensagem_erro = binding.txtAvisoError

            if (email.isEmpty() || senha.isEmpty()) {
                mensagem_erro.text = getString(R.string.aviso_prenecher_campos)
            } else {
                autenticarUsuario()
            }
        }

        binding.txtTelaLoginParte2.setOnClickListener {
            val intent = Intent(this, FormeCadastro::class.java)
            startActivity(intent)
        }

        binding.loginFacecook.setOnClickListener {
            val intent = Intent(this, FormeTreino::class.java)
            startActivity(intent)
        }

    }

    private fun autenticarUsuario() {

        val email = binding.edtEmail.text.toString()
        val senha = binding.edtSenha.text.toString()
        val mensagem_erro = binding.txtAvisoError

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Usuário logado com sucesso", Toast.LENGTH_SHORT).show()
                irParaTelaFormTreino()
            }
        }.addOnFailureListener { erro ->

            when (erro) {
                is FirebaseAuthInvalidCredentialsException -> mensagem_erro.text =
                    getString(R.string.erro_login_password)
                is FirebaseNetworkException -> mensagem_erro.text =
                    getString(R.string.erro_sem_conexao_internet)
                else -> mensagem_erro.text = getString(R.string.erro_logar)
            }
        }
    }

    private fun verificaUsuarioLogado() {
        val usuarioLogado = FirebaseAuth.getInstance().currentUser

        if (usuarioLogado != null) {
            irParaTelaFormTreino()
        }

    }

    private fun irParaTelaFormTreino() {

        val intent = Intent(this, FormeTreino::class.java)
        startActivity(intent)
        finish()
    }
}
