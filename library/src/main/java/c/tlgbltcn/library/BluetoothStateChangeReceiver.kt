package c.tlgbltcn.library

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by tolga bolatcan on 24.01.2019
 */
abstract class BluetoothStateChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action

        when (action) {
            BluetoothAdapter.ACTION_STATE_CHANGED -> {
                val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)

                when (state) {
                    BluetoothAdapter.STATE_OFF -> onDisabledBluetooth()

                    BluetoothAdapter.STATE_ON -> onEnabledBluetooth()
                }
            }

            BluetoothAdapter.ACTION_DISCOVERY_STARTED -> onStartDiscovering()

            BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> onFinishDiscovering()
        }
    }

    abstract fun onEnabledBluetooth()

    abstract fun onDisabledBluetooth()

    abstract fun onStartDiscovering()

    abstract fun onFinishDiscovering()
}
