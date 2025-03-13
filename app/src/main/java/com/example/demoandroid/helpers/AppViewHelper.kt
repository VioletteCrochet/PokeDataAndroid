package com.example.demoandroid.helpers

import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

class AppViewHelper {
    companion object {
        fun openActivity (context: Context, kClass: KClass<*>) {

            val intent = Intent(context, kClass.java)
            // Ouvrir l'ativity
            context.startActivity(intent)
        }
    }
}