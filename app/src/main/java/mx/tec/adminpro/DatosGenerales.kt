package mx.tec.adminpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DatosGenerales : AppCompatActivity() {

    lateinit var txtInv: EditText
    lateinit var txtTrema: EditText
    lateinit var txtValorR: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_generales)

        txtInv = findViewById(R.id.textInvInicial)
        txtTrema = findViewById(R.id.textTrema)
        txtValorR = findViewById(R.id.textValorRescate)
    }

    fun back(view : View?){
        finish()
    }

    fun next(view : View?){
        if(txtInv.text.toString() != "" && txtTrema.text.toString() != "" && txtValorR.text.toString() != ""){
            MyGlobal.InversionInicial = txtInv.text.toString()
            MyGlobal.Trema = txtTrema.text.toString()
            MyGlobal.ValorRescate = txtValorR.text.toString()


            val intent = Intent(this, MesConMes::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show()
        }

    }
}