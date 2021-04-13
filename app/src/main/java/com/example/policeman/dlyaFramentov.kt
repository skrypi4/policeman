package com.example.policeman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation

class dlyaFramentov : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dlya_framentov)

        val navController = Navigation.findNavController(this@dlyaFramentov, R.id.fragment123)

        navController?.navigate(R.id.wanted)




    }
}