package jp.techacademy.naoki.kawamata.blechartapp

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

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
        var buttonGraph = findViewById(R.id.button_graph) as Button
        buttonGraph.setOnClickListener{
            var intentPeripheral = Intent(this, ShowGraphActivity::class.java)
            startActivity(intentPeripheral)
        }
    }

}
