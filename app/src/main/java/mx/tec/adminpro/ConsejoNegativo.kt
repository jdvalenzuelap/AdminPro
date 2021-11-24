package mx.tec.adminpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ConsejoNegativo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consejo_negativo)
    }

    fun regresar(view: View?){
        finish()
    }
}