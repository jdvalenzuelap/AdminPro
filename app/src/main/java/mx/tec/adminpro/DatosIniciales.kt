package mx.tec.adminpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DatosIniciales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_iniciales)
    }

    fun regresar(view: View?){
        finish()
    }

    fun continuar(view: View?){

    }
}