package com.example.jurajsolarml.simpleapp.presenter

interface ILoginPresenter {
    //rozhranie, aby ste mohli komunikovať s LoginActivity
    fun onLogin(email:String,password:String)
}