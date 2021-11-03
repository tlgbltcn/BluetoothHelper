package c.tlgbltcn.library

import android.bluetooth.BluetoothDevice

/**
 * Created by tolga bolatcan on 25.01.2019
 */
interface BluetoothHelperListener {

    fun onStartDiscovery()

    fun onFinishDiscovery()

    fun onEnabledBluetooth()

    fun onDisabledBluetooh()

    fun getBluetoothDeviceList(device: BluetoothDevice?)
}