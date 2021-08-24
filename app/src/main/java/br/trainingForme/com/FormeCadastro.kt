package br.trainingForme.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import br.trainingForme.com.databinding.ActivityFormeCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormeCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormeCadastroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormeCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        toolbarCadastro()

        buttonCadastrar()

    }

    private fun buttonCadastrar() {

        binding.btnCadastrar.setOnClickListener {

            val email = binding.editTxtEmail.text.toString()
            val senha = binding.editTxtSenha.text.toString()
            val mensagem_erro = binding.txtMsgErro

            if (email.isEmpty() || senha.isEmpty()) {
                mensagem_erro.text = getString(R.string.aviso_prenecher_campos)
            } else {
                cadastraUsuario()
            }
        }


    }

    private fun cadastraUsuario() {

        val email = binding.editTxtEmail.text.toString()
        val senha = binding.editTxtSenha.text.toString()
        val mensagem_erro = binding.txtMsgErro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { success ->
                if (success.isSuccessful) {
                    Toast.makeText(this, "Cadastrado com sucesso!!", Toast.LENGTH_SHORT).show()
                    binding.editTxtEmail.setText("")
                    binding.editTxtSenha.setText("")
                    mensagem_erro.text = ""
                }
            }.addOnFailureListener { error ->
                when (error) {
                    is FirebaseAuthWeakPasswordException -> mensagem_erro.text =
                        getString(R.string.erro_senha_pequena)
                    is FirebaseAuthUserCollisionException -> mensagem_erro.text =
                        getString(R.string.erro_usuario_ja_cadastrado)
                    else -> mensagem_erro.text = getString(R.string.erro_ao_cadastrar_usuario)
                }

            }
    }

    private fun toolbarCadastro() {
        val toolbarDetalhes = binding.toolbarFrameCadastro
        toolbarDetalhes.navigationIcon = AppCompatResources.getDrawable(this, R.drawable.ic_voltar)
        toolbarDetalhes.setOnClickListener {
            val intent = Intent(this, FormeLogin::class.java)
            startActivity(intent)
            finish()
        }
    }


}


