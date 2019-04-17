package com.example.jurajsolarml.simpleapp.presenter

import com.example.jurajsolarml.simpleapp.model.User
import com.example.jurajsolarml.simpleapp.view.ILoginView

class LoginPresenter (private var iLoginView:ILoginView):ILoginPresenter {
    //trieda na spracovanie prihlasovacích funkcií a podávanie správ o aktivite
    override fun onLogin(email: String, password: String) {
        val user = User(email,password)
        val loginCode = user.isDataValid()
        when (loginCode) {
            0 -> iLoginView.onLoginError("Prázdny email a heslo")
            1 -> iLoginView.onLoginError("Prázdny email a heslo")
            2 -> iLoginView.onLoginError("Heslo musí byť väčšie ako 6")
            else -> iLoginView.onLoginSuccess("Prihlásenie úspešné")
        }


    }
}