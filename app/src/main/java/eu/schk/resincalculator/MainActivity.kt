package eu.schk.resincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    amount1.isEnabled = false
    amount2.isEnabled = false

    calcBtn.setOnClickListener{

      val curRatio1 = ratio1.text.toString().toDouble()
      val curRatio2 = ratio2.text.toString().toDouble()
      val curWhole = curRatio1 + curRatio2

      val curAmount = amountNeeded.text.toString().toDouble()

      val ratio1 = curWhole / curRatio1
      val ratio2 = curWhole / curRatio2

      val curAmount1 =  (curAmount / ratio1)
      val curAmount2 = curAmount / ratio2

      val df = DecimalFormat("#.##")
      df.roundingMode = RoundingMode.CEILING

      amount1.setText(df.format(curAmount1).toString())
      amount2.setText(df.format(curAmount2).toString())
    }
  }
}