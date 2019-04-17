package com.example.jurajsolarml.simpleapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    // Initialize
    private lateinit var regFirstName: EditText
    private lateinit var regLastName: EditText
    private lateinit var regEmail: EditText
    private lateinit var regPassword: EditText
    private lateinit var regCnfpass: EditText
    private lateinit var registerUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.jurajsolarml.simpleapp.R.layout.activity_register)

        //find view name,email,password
        regFirstName = findViewById(R.id.regFirstName)
        regLastName = findViewById(R.id.regLastName)
        regEmail = findViewById(R.id.regEmail)
        regPassword = findViewById(R.id.regPassword)
        regCnfpass = findViewById(R.id.regCnfpass)
        registerUser = findViewById(R.id.registerUser)

        //setOnClickListener on button
        registerUser.setOnClickListener {

            if (regEmail.text.toString().length < 5)

            //you can use email address validator here*,overenie email a password
                regEmail.error = "Zadajte prihlasovací email"

            if (regPassword.text.toString().length < 6) {
                regPassword.error = "Heslo musí byť  vačšie ako 6 písmien"

                if (regCnfpass.text.toString().length < 6) {
                    regCnfpass.error = "Heslo musí byť  vačšie ako 6 písmien"

                }
                regEmail.text.toString().length >= 5 && regPassword.text.toString().length >= 6

                //checking if email and passwords are empty,keď email a password je prázdny
                if (TextUtils.isEmpty(regFirstName.toString())) {
                    Toast.makeText(this, "Zadajte meno", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(regLastName.toString())) {
                    Toast.makeText(this, "Zadajte priezvisko", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                } else if (TextUtils.isEmpty(regEmail.toString())) {
                    Toast.makeText(this, "Zadajte email", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                } else if (TextUtils.isEmpty(regPassword.toString())) {
                    Toast.makeText(this, "Zadajte heslo", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(regCnfpass.toString())) {
                    Toast.makeText(this, "Zadajte overenie hesla", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                    //porovnanie hesiel a zhoda hesiel
                } else if (regPassword != regCnfpass) {
                    Toast.makeText(this, "Hesla sa nezhodujú", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }//spustenie activity
                    val intent = Intent(applicationContext, DataSave::class.java)
                    startActivity(intent)
                }

                    Toast.makeText(this, "Registrácia úspešna", Toast.LENGTH_SHORT).show()

                }

            }
        }



























