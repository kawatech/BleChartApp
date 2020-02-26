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

        // X���̒l
        val xValues = ArrayList<String>()
        xValues.add("No.1")
        xValues.add("No.2")
        xValues.add("No.3")
        xValues.add("No.4")
        xValues.add("No.5")

        // value
        val value = ArrayList<Entry>()
        value.add(Entry(100f, 0))
        value.add(Entry(120f, 1))
        value.add(Entry(150f, 2))
        value.add(Entry(250f, 3))
        value.add(Entry(500f, 4))

        val valueDataSet = LineDataSet(value, "sample")
        dataSets.add(valueDataSet)

        lineChart.data = LineData(xValues, dataSets)
    }
}