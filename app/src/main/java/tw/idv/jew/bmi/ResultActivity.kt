package tw.idv.jew.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        val bmi = intent.getFloatExtra("BMI_EXTRA", 0f)
        val bmi = intent.extras?.getFloat(getString(R.string.BMI_EXTRA), 0f)
        val testing = intent.extras?.getString("TEST_EXTRA")
        /*
        val bundle = intent.extras
        val bmi = bundle?.getFloat("BMI_EXTRA", 0f)
        val testing = bundle?.getString("TEST_EXTRA")
        */
        result.setText(bmi.toString())
    }
}