package mx.tec.adminpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MesConMes : AppCompatActivity() {

    lateinit var txtVentas: EditText
    lateinit var txtCostos: EditText
    lateinit var txtDepreciacion: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mes_con_mes)


        txtVentas = findViewById(R.id.textVentas)
        txtCostos = findViewById(R.id.textCostos)
        txtDepreciacion = findViewById(R.id.textDepre)
    }

    fun back(view : View?){
        finish()
    }

    fun next(view : View?){
        if(txtVentas.text.toString() != "" && txtCostos.text.toString() != "" && txtDepreciacion.text.toString() != ""){
            MyGlobal.Ventas = txtVentas.text.toString()
            MyGlobal.Costos = txtCostos.text.toString()
            MyGlobal.Depreciacion = txtDepreciacion.text.toString()

//            5


            val intent = Intent(this, Wacc::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show()
        }
    }
}