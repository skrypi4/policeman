package com.example.policeman

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mySettings = "mysettings"
        val myLogin = "login"
        val myPassword = "password"
        val settings: SharedPreferences
        settings = getSharedPreferences(mySettings, Context.MODE_PRIVATE)

        val login = findViewById<EditText>(R.id.plainTextName)
        val password = findViewById<EditText>(R.id.textPassword)
        val button = findViewById<Button>(R.id.Button)
        val button2 = findViewById<Button>(R.id.button6)
        val check = findViewById<CheckBox>(R.id.checkBox)
        val editor = settings.edit()

        fun plavno(a:ImageView){//доделать!!!!!!!!!!!!!!
            var b = 1f
            for (i in 1..20) {
                a.alpha = b
                b -= 0.10f
                Handler().postDelayed(Runnable {
                }, 2000)
            }
        }
        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
        fun random(n1: Int, n2: Int) = Random.nextInt(n1, n2 + 1)
        fun loadScreen(){
            val imageScreen = arrayOf<Int>(R.drawable.bmw, R.drawable.car, R.drawable.car2, R.drawable.chevrolet,R.drawable.dtp, R.drawable.japan, R.drawable.lada, R.drawable.semerka) //9
            val imageLoad = findViewById<ImageView>(R.id.imageView5)
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            button.visibility = View.INVISIBLE
            button2.visibility = View.INVISIBLE
             imageLoad?.setImageResource(imageScreen[random(1,9)])

            val handler = Handler().postDelayed(Runnable {
                button.visibility = View.VISIBLE
                button2.visibility = View.VISIBLE
               //imageLoad.visibility = View.INVISIBLE
                progressBar.visibility = View.INVISIBLE
                plavno(imageLoad)

            }, 2000)
        }
        loadScreen()
        if (settings.contains(myLogin)) {
            login.text = settings.getString(myLogin, "")?.toEditable()
            password.text = settings.getString(myPassword, "")?.toEditable()
            check.isChecked = true
        }

        button.setOnClickListener {

            val service = ServiceBuilder.buildService(Service::class.java) //!!!!!!!!!!
                service.logIn(login.text.toString(), password.text.toString()).enqueue(object:Callback<Response.response>{ //вызываем метод
                    override fun onResponse(
                        p0: Call<Response.response>?,
                        p1: retrofit2.Response<Response.response>?
                    ) {
                        if(p1?.code()==200) {
                            Toast.makeText(this@MainActivity, "Вход прошел успешно", Toast.LENGTH_LONG).show()

                            if (!check.isChecked){
                                editor.clear()
                                editor.apply()
                            }

                            val intent = Intent(this@MainActivity, Menu::class.java)
                            startActivity(intent)  //открыть меню.
                        }

                            if(p1?.code()!=200){
                                Toast.makeText(this@MainActivity, "Логин или пароль неверный", Toast.LENGTH_LONG).show()
                            }
                    }

                    override fun onFailure(p0: Call<Response.response>?, p1: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
        }
        check.setOnCheckedChangeListener { buttonView, isChecked ->
            var strName = login.text.toString()
            var strPassword = password.text.toString()

            //val editor = settings.edit()
            editor.putString(myLogin, strName)
            editor.putString(myPassword, strPassword)
            editor.apply()
        }
    }
}