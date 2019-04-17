package com.example.jurajsolarml.simpleapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.jurajsolarml.simpleapp.presenter.ILoginPresenter
import com.example.jurajsolarml.simpleapp.presenter.LoginPresenter
import com.example.jurajsolarml.simpleapp.view.ILoginView

class MainActivity : AppCompatActivity(),ILoginView {

    override fun onLoginSuccess(message: String) {
        //Ak je prihlásenie úspešné, LoginActivity je dokončená a MenuMain sa spustí
        val loginIntent = Intent(this, MenuMain::class.java)
        startActivity(loginIntent)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        //Ak je prihlásenie chybné, oznámi text.
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    // Initialize Presenter (also Model in the constructor of Presenter) & has object of Presenter
    private lateinit var loginPresenter: ILoginPresenter

    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btLogin: Button? = null
    private var btRegister: Button? = null
    private var btAccount: Button? = null
    private var btMap: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find view
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btLogin)
        btRegister = findViewById(R.id.btRegister)
        btAccount = findViewById(R.id.btAccount)
        btMap = findViewById(R.id.btMap)

        //set listener
        loginPresenter = LoginPresenter(this)

            btLogin?.setOnClickListener {
                loginPresenter.onLogin(etEmail?.text.toString(), etPassword?.text.toString())

                btLogin?.isFocusableInTouchMode = false

            }
            //find view button and activity
            val btRegister = findViewById<Button>(R.id.btRegister)

            btRegister.isFocusableInTouchMode = false

            btRegister.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)

            }
            //find view button and activity
            val btAccount = findViewById<Button>(R.id.btAccount)

            btAccount.isFocusableInTouchMode = false

            btAccount.setOnClickListener {
                Toast.makeText(this, "Musíte sa prihlásiť", Toast.LENGTH_SHORT).show()

            }
            //find view button and activity
            val btMap = findViewById<Button>(R.id.btMap)

            btMap.isFocusableInTouchMode = false

            btMap.setOnClickListener {
                startActivity(Intent(this, MapsActivity::class.java))

            }
        }
    }




