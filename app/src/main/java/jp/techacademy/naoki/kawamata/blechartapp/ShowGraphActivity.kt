package jp.techacademy.naoki.kawamata.blechartapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.util.*

class ShowGraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_graph)
        val lineChart = findViewById<View>(R.id.line_chart) as LineChart

        val dataSets = ArrayList<LineDataSet>()

        // MP データを受信する
        /*
        val data1 = intent.getFloatExtra("DATA1", 1f)
        val data2 = intent.getFloatExtra("DATA2", 1f)
        val data3 = intent.getFloatExtra("DATA3", 1f)
        val data4 = intent.getFloatExtra("DATA4", 1f)
        val data5 = intent.getFloatExtra("DATA5", 1f)
*/

        val rDataArray = intent.getFloatArrayExtra("DATA")


        // X���̒l
        val xValues = ArrayList<String>()
        xValues.add("No.1")
        xValues.add("No.2")
        xValues.add("No.3")
        xValues.add("No.4")
        xValues.add("No.5")

        // value
        val value = ArrayList<Entry>()
        value.add(Entry(rDataArray[0], 0))
        value.add(Entry(rDataArray[1], 1))
        value.add(Entry(rDataArray[2], 2))
        value.add(Entry(rDataArray[3], 3))
        value.add(Entry(rDataArray[4], 4))

        val valueDataSet = LineDataSet(value, "sample")
        dataSets.add(valueDataSet)

        lineChart.data = LineData(xValues, dataSets)
    }
}