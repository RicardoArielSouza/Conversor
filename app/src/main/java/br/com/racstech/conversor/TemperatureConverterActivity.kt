package br.com.racstech.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class TemperatureConverterActivity : AppCompatActivity() {
    lateinit var input: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_converter)
        val button = findViewById<Button>(R.id.convertButton)

        button.setOnClickListener {
            if (findViewById<RadioButton>(R.id.celsiusRadioButton).isChecked){
                input = findViewById<EditText>(R.id.temperatureInputText).toString()
                Log.v("entrada", "qual o valor: $input")
                    convertFromCelsius()
            }
        }
    }

    private fun convertFromCelsius() {

        Log.v("entrada", "input: $input")
        var value: Double? = input.toDoubleOrNull()
        if (value != null){
            value = ((value * 9 / 5) + 32)
            findViewById<TextView>(R.id.temperatureOutput1).text = value.toString()
        }else{
            Toast.makeText(this, "Preencha um valor", Toast.LENGTH_LONG).show()
        }

    }
}