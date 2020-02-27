package jp.techacademy.naoki.kawamata.blechartapp

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // デバイスがBLEに対応していなければトースト表示.
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, R.string.ble_is_not_supported, Toast.LENGTH_SHORT).show()
            finish()
        }

        var buttonCentral = findViewById(R.id.button_central) as Button
        buttonCentral.setOnClickListener{
            var intentCentral = Intent(this, CentralActivity::class.java)
            startActivity(intentCentral)
        }
        var buttonPeripheral = findViewById(R.id.button_peripheral) as Button
        buttonPeripheral.setOnClickListener{
            var intentPeripheral = Intent(this, PeripheralActivity::class.java)
            startActivity(intentPeripheral)
        }
        // MP
        var buttonGraph = findViewById(R.id.button_graph) as Button
        buttonGraph.setOnClickListener{
            var intentShow = Intent(this, ShowGraphActivity::class.java)
            var DataArray = FloatArray(5)
            DataArray[0] = Random().nextInt(500).toString().toFloat()
            DataArray[1] = Random().nextInt(500).toString().toFloat()
            DataArray[2] = Random().nextInt(500).toString().toFloat()
            DataArray[3] = Random().nextInt(500).toString().toFloat()
            DataArray[4] = Random().nextInt(500).toString().toFloat()
            intentShow.putExtra("DATA", DataArray)

            /*
            intentPeripheral.putExtra("DATA1", 100f)
            intentPeripheral.putExtra("DATA2", 120f)
            intentPeripheral.putExtra("DATA3", 150f)
            intentPeripheral.putExtra("DATA4", 250f)
            intentPeripheral.putExtra("DATA5", 500f)

             */
            startActivity(intentShow)
        }
    }

}
