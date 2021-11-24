package mx.tec.adminpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class DatosIniciales : AppCompatActivity() {
    lateinit var txtNombre: EditText
    lateinit var txtMoneda: EditText
    lateinit var txtPlazo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_iniciales)

        txtNombre = findViewById(R.id.txtNombre)
        txtMoneda = findViewById(R.id.txtMoneda)
        txtPlazo = findViewById(R.id.txtPlazo)
    }

    fun regresar(view: View?){
        finish()
    }

    fun continuar(view: View?){
        if (txtNombre.text.toString() != "" && txtMoneda.text.toString() != "" && txtPlazo.text.toString() != ""){
            MyGlobal.Nombre = txtNombre.text.toString()
            MyGlobal.Moneda = txtMoneda.text.toString()
            MyGlobal.Plazo = txtPlazo.text.toString()

            val intent = Intent(this, DatosGenerales::class.java)
            startActivity(intent)
        }
    }
}