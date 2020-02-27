package c.tlgbltcn.bluetoothhelper

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.tlgbltcn.library.BluetoothHelper
import c.tlgbltcn.library.BluetoothHelperListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BluetoothHelperListener {

    private lateinit var bluetoothHelper: BluetoothHelper

    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private var itemList = ArrayList<BluetoothDeviceModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bluetoothHelper = BluetoothHelper(this@MainActivity, this@MainActivity)
                .setPermissionRequired(true)
                .create()

        if (bluetoothHelper.isBluetoothEnabled()) enable_disable.text = "Bluetooth State Off"
        else enable_disable.text = "Bluetooth State On"

        if (bluetoothHelper.isBluetoothScanning()) start_stop.text = "Stop discovery"
        else start_stop.text = "Start discovery"


        enable_disable.setOnClickListener {
            if (bluetoothHelper.isBluetoothEnabled()) {

                bluetoothHelper.disableBluetooth()

            } else {
                bluetoothHelper.enableBluetooth()
            }
        }

        start_stop.setOnClickListener {
            if (bluetoothHelper.isBluetoothScanning()) {
                bluetoothHelper.stopDiscovery()

            } else {
                bluetoothHelper.startDiscovery()
            }
        }

        viewAdapter = BluetoothListAdapter(itemList)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter
        }
    }

    override fun onStartDiscovery() {
        start_stop.text = "Stop discovery"

    }

    override fun onFinishDiscovery() {
        start_stop.text = "Start discovery"
        itemList.clear()
    }

    override fun onEnabledBluetooth() {
        enable_disable.text = "Bluetooth State Off"
    }

    override fun onDisabledBluetooh() {
        enable_disable.text = "Bluetooth State On"

    }

    override fun getBluetoothDeviceList(device: BluetoothDevice) {
        itemList.add(BluetoothDeviceModel(device.name, device.address))
        viewAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        bluetoothHelper.registerBluetoothStateChanged()
    }


    override fun onStop() {
        super.onStop()
        bluetoothHelper.unregisterBluetoothStateChanged()
    }
}
