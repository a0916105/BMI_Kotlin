package tw.idv.jew.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import tw.idv.jew.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //View Binding(import tw.idv.jew.bmi.databinding.ActivityMainBinding)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }

    fun bmi(view: View){
        val weight = binding.edWeight.text.toString().toFloat()
        val height = binding.edHeight.text.toString().toFloat()
        val bmi = weight / (height * height)
        Log.d("BMI", bmi.toString())
        Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
                .setMessage(bmi.toString())
                .setTitle("Your BMI")
                .setPositiveButton("OK", null)
                .setNeutralButton("Cancel", null)
                .show()
    }
}