package com.example.jurajsolarml.simpleapp.view

interface ILoginView {
    // volanie metódy prezentátora vždy, keď je vykonaná akcia používateľa
    fun onLoginSuccess(message:String)
    fun onLoginError(message:String)
}