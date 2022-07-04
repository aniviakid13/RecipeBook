package com.codefresher.recipebook.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.codefresher.recipebook.MainActivity
import com.codefresher.recipebook.R
import com.codefresher.recipebook.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = com.codefresher.recipebook.databinding.ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        logIn()
        signUp()

        tvSignUp.setOnClickListener {
            tvSignUp.background = resources.getDrawable(R.drawable.switch_trcks, null)
            tvSignUp.setTextColor(resources.getColor(R.color.white, null))
            tvLogIn.background = null
            signUpLayout.visibility = View.VISIBLE
            logInLayout.visibility = View.GONE
            tvLogIn.setTextColor(resources.getColor(R.color.a, null))
            btnLogIn.visibility = View.GONE
            btnSignUp.visibility = View.VISIBLE
        }
        tvLogIn.setOnClickListener {
            tvLogIn.background = resources.getDrawable(R.drawable.switch_trcks, null)
            tvLogIn.setTextColor(resources.getColor(R.color.white, null))
            tvSignUp.background = null
            logInLayout.visibility = View.VISIBLE
            signUpLayout.visibility = View.GONE
            tvSignUp.setTextColor(resources.getColor(R.color.a, null))
            btnSignUp.visibility = View.GONE
            btnLogIn.visibility = View.VISIBLE

        }
        btnLogIn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    private fun signUp() {

        binding.btnSignUp.setOnClickListener {
            val emailSignUp = binding.edtEmailSignUp.text.toString()
            val passSignUp = binding.edtPassSignUp.text.toString()
            val rePass = binding.edtRePass.text.toString()



            if (emailSignUp.isNotEmpty() && passSignUp.isNotEmpty() && rePass.isNotEmpty()) {
                if (passSignUp == rePass) {
                    firebaseAuth.createUserWithEmailAndPassword(emailSignUp, passSignUp)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {

                                Toast.makeText(this, "Sign Up successfully", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun logIn() {
        binding.btnLogIn.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val pass = binding.edtPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}