package mx.tec.adminpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.cos

class Recap : AppCompatActivity() {
    lateinit var nombre : TextView
    lateinit var moneda : TextView
    lateinit var plazo : TextView
    lateinit var inversion : TextView
    lateinit var trema : TextView
    lateinit var rescate : TextView
    lateinit var ventas : TextView
    lateinit var costos : TextView
    lateinit var depreciacion : TextView
    lateinit var libre : TextView
    lateinit var mercado : TextView
    lateinit var beta : TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recap)

        nombre = findViewById(R.id.txtSetNombre)
        moneda = findViewById(R.id.txtSetMoneda)
        plazo = findViewById(R.id.txtSetPlazo)
        inversion = findViewById(R.id.txtSetInversion)
        trema = findViewById(R.id.txtSetTrema)
        rescate = findViewById(R.id.txtSetRescate)
        ventas = findViewById(R.id.txtSetVentas)
        costos = findViewById(R.id.txtSetCostos)
        depreciacion = findViewById(R.id.txtSetDepreciacion)
        libre = findViewById(R.id.txtSetLibre)
        mercado= findViewById(R.id.txtSetMercado)
        beta = findViewById(R.id.txtSetBeta)

        nombre.text = MyGlobal.Nombre
        moneda.text = MyGlobal.Moneda
        plazo.text = MyGlobal.Plazo+" meses"
        inversion.text = "$"+MyGlobal.InversionInicial
        trema.text = "%"+MyGlobal.Trema
        rescate.text = "$"+MyGlobal.ValorRescate
        ventas.text = "$"+MyGlobal.Ventas
        costos.text = "$"+MyGlobal.Costos
        depreciacion.text = "$"+MyGlobal.Depreciacion
        libre.text = "%"+MyGlobal.RetLibre
        mercado.text = "%"+MyGlobal.RetMerc
        beta.text = MyGlobal.BMerc

    }

    fun regresar(view: View?){
        finish()
    }

    fun continuar(view: View?){
        val intent = Intent(this, Resultados::class.java)
        startActivity(intent)
    }
}