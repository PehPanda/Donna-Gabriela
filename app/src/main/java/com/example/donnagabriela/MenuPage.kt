package com.example.donnagabriela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MenuPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)

        //Hide the StatusBar and Action Bar:
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()

    }

    fun Return1(view: View?) {

        val ReturnPage1 = Intent(
            baseContext,
            Localization_Page::class.java
        )
        startActivity(ReturnPage1)

    }

    fun Exit(view: View) {

        finishAffinity();

    }
}