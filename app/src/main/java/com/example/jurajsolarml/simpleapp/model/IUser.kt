package com.example.jurajsolarml.simpleapp.model

interface IUser {
    //validation,kontrola
    val email:String
    val password:String
    fun isDataValid():Int
}