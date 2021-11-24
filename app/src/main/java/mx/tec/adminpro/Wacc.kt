package mx.tec.adminpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Wacc : AppCompatActivity() {
    lateinit var txtRetLibre: EditText
    lateinit var txtRetMerc: EditText
    lateinit var txtBMerc: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wacc)

        txtRetLibre = findViewById(R.id.textRetLibre)
        txtRetMerc = findViewById(R.id.textRetMercado)
        txtBMerc = findViewById(R.id.textBMercado)
    }

    fun back(view : View?){
        finish()
    }

    fun next(view : View?){
        if(txtRetLibre.text.toString() != "" && txtRetMerc.text.toString() != "" && txtBMerc.text.toString() != ""){
            MyGlobal.RetLibre = txtRetLibre.text.toString()
            MyGlobal.RetMerc = txtRetMerc.text.toString()
            MyGlobal.BMerc = txtBMerc.text.toString()

            val intent = Intent(this, Recap::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show()
        }
    }
}