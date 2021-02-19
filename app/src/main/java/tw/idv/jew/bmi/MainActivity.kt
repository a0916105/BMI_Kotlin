package tw.idv.jew.bmi

import android.content.Intent
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

        Log.d("MainActivity", "onCreate")

        binding.bHelp.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("BMI說明")
                    .setMessage("體重(kg)/身高的平方(m)")
                    .setPositiveButton(getString(R.string.ok), null)
                    .show()
        }
    }

    fun bmi(view: View){
        val weight = binding.edWeight.text.toString().toFloat()
        val height = binding.edHeight.text.toString().toFloat()
        val bmi = weight / (height * height)
        Log.d("BMI", bmi.toString())

        /*Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()

        //產生Builder物件
        AlertDialog.Builder(this)
                //呼叫setMessage()方法設定顯示文字
                .setMessage(bmi.toString())
                .setTitle(getString(R.string.your_bmi))
                .setPositiveButton(getString(R.string.ok), null)
                .setNeutralButton(getString(R.string.cancel), null)
                //顯示對話框
                .show()*/
        /*val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("BMI_EXTRA", bmi)
        startActivity(intent)*/
        Intent(this, ResultActivity::class.java).apply {
            val bag = Bundle()
//            putExtra("BMI_EXTRA", bmi)
            bag.putFloat(getString(R.string.BMI_EXTRA), bmi)
            bag.putString("TEST_EXTRA", "Testing")
            putExtras(bag)
            startActivity(this)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}