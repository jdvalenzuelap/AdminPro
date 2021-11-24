package mx.tec.adminpro

import android.content.Intent
import android.icu.number.CurrencyPrecision
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.logging.Logger
import kotlin.math.pow

class Resultados : AppCompatActivity() {
    lateinit var txtISR: TextView
    lateinit var txtVPN: TextView
    lateinit var txtTIR: TextView
    lateinit var txtWacc: TextView
    var tir : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        txtISR = findViewById(R.id.setISR)
        txtVPN = findViewById(R.id.setVPN)
        txtTIR = findViewById(R.id.setTir)
        txtWacc = findViewById(R.id.SetWacc)

        val baseGravable = MyGlobal.Ventas.toDouble() - MyGlobal.Costos.toDouble() - MyGlobal.Depreciacion.toDouble()
        var ISR = 0.0
        if (baseGravable > 0) {
            ISR = baseGravable * 0.3
        }

        val resultado = baseGravable - ISR
        val flujoMensual = resultado+MyGlobal.Depreciacion.toInt()
        val tasaMensual = (1+(MyGlobal.Trema.toDouble()/100)).pow((1/12)-1)/100

        val valorPresenteNeto = vpn(flujoMensual, MyGlobal.InversionInicial.toDouble(), MyGlobal.Plazo.toInt(),tasaMensual)
//        val tir = 15
        tir = irr(MyGlobal.InversionInicial.toDouble(), flujoMensual, 3)

        txtISR.text = ISR.toString()
        txtTIR.text = tir.toString()
        txtVPN.text = valorPresenteNeto.toString()

        val wacc = MyGlobal.RetLibre.toDouble() + (MyGlobal.BMerc.toDouble()*(MyGlobal.RetMerc.toDouble()-MyGlobal.RetLibre.toDouble()))
//        Toast.makeText(this, "$wacc", Toast.LENGTH_SHORT).show()
        if (wacc - 1 > MyGlobal.Trema.toDouble() || wacc + 1 < MyGlobal.Trema.toDouble()){
            txtWacc.text = "La TREMA es bastante diferente del WACC estimado, porfavor considera ajustar tu TREMA a algo más realista."
        }else{
            txtWacc.text = "La TREMA es muy cercana al WACC, los calculos deberían de ser una buena referencia."
        }
    }

    fun vpn(flujo:Double, inversion:Double, periodos:Int, tasa:Double) : Double{
//        Log.wtf("fin", "empezamos vpn")
        var valorPresente = 0.0
        for (i in 1..periodos){
            var res = flujo/((1+tasa).pow(i))
            valorPresente += res
        }
        valorPresente -= inversion


        Log.wtf("fin", "$valorPresente")
        return valorPresente
    }

    fun irr(inversion: Double, flujo: Double, precision: Int) : Double{
        Log.wtf("fin", "empezamos tir")
        var rate = 0.1
        var npv_calc = precision+1.0
        while (npv_calc > precision || npv_calc < -precision){
            npv_calc = vpn(flujo, inversion, MyGlobal.Plazo.toInt(), rate)
//            Log.wtf("fin","$npv_calc")
            if (npv_calc > precision){

                rate += 0.0001
            }else if (npv_calc < -precision){
                rate -= 0.0001
            }
            Log.wtf("fin", "$rate")
        }
        Log.wtf("fin", "terminamos tir")
        if (rate >= 0){
            return rate
        }else{
            Toast.makeText(this, "TIR negativa!", Toast.LENGTH_SHORT).show()
            return rate
        }
    }

    fun regresar(view: View?){
        finish()
    }

    fun consejoExperto(view: View?){

        if(tir < MyGlobal.Trema.toDouble()){
            val intent = Intent(this, ConsejoNegativo::class.java)
            startActivity(intent)
        }else{
            val intent = Intent(this, ConsejoPositivo::class.java)
            startActivity(intent)
        }
    }
}