package com.example.jurajsolarml.simpleapp.model

import android.text.TextUtils
import android.util.Patterns


class User(override val email:String,override val password:String):IUser {
    //validation
    override fun isDataValid(): Int {
        if(TextUtils.isEmpty(email))
            return 0 // 0 "chyba,Prázdny email"
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1 // 1 error code Nesprávny vzor
        else if (password.length <=6)
            return 2 // 2 error code Heslo musí byť väčšie ako 6
        else
            return -1 // -1 Prihlásenie úspešné
    }
}
