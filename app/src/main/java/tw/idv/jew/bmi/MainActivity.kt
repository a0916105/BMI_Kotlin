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

        binding.bHelp.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("BMI說明")
                    .setMessage("體重(kg)/身高的平方(m)")
                    .setPositiveButton("OK", null)
                    .show()
        }
    }

    fun bmi(view: View){
        val weight = binding.edWeight.text.toString().toFloat()
        val height = binding.edHeight.text.toString().toFloat()
        val bmi = weight / (height * height)
        Log.d("BMI", bmi.toString())

        Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()

        //產生Builder物件
        AlertDialog.Builder(this)
                //呼叫setMessage()方法設定顯示文字
                .setMessage(bmi.toString())
                .setTitle(getString(R.string.your_bmi))
                .setPositiveButton(getString(R.string.ok), null)
                .setNeutralButton(getString(R.string.cancel), null)
                //顯示對話框
                .show()
    }
}