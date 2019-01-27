Bluetooth Helper
=============
[![](https://jitpack.io/v/tlgbltcn/BluetoothHelper.svg)](https://jitpack.io/#tlgbltcn/BluetoothHelper)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)


Allows you to access the Bluetooth of your mobile device, manage turn-on - turn off, and discover bluetooth devices around you.

![Alt Text](https://media.giphy.com/media/pG5z3OtMI5vfAyWuTs/giphy.gif)


## Getting started
### Setup
##### Step 1. Add the required permissions to the AndroidManifest.xml file
- Add Bluetooth permissions to your AndroidManifest.xml:
```xml
<uses-permission android:name = "android.permission.BLUETOOTH_ADMIN"/>
<uses-permission android:name = "android.permission.BLUETOOTH"/>
```
- if you want to access the device list, you must add the following to the AndroidManifest.xml file in the location permissions:
```xml
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```
##### Step 2. Add the JitPack repository to your build file
- Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
##### Step 3. Add the dependency
- Add it in app build.gradle
```gradle
dependencies {
	        implementation 'com.github.tlgbltcn:BluetoothHelper:v1.0'
	}
```

### Usage
- If you want to get a list of the bluetooth devices around you, you should use setPermission (true). Automatically request location permission for you

```kotlin
   val bluetoothHelper = BluetoothHelper(this, this)
            .setPermissionRequired(true)
            .create()  
```

- You have some commitment to handle the lifecycle BluetoothHelper to work properly

```kotlin
   override fun onResume() {
        super.onResume()
        bluetoothHelper.registerBluetoothStateChanged()
   }
   override fun onPause() {
        super.onPause()
        bluetoothHelper.unregisterBluetoothStateChanged()
   } 
```

- Turn Bluetooth on and off

```kotlin  
   enable_disable.setOnClickListener {
            if (bluetoothHelper.isBluetoothEnabled()) bluetoothHelper.disableBluetooth()
            else bluetoothHelper.enableBluetooth()
   }
```

- Instructions for locating devices

```kotlin
   start_stop.setOnClickListener {
            if (bluetoothHelper.isBluetoothScanning()) bluetoothHelper.stopDiscovery()
            else bluetoothHelper.startDiscovery()
   }
```

- And finally, you can update the UI in the following methods using the BluetoothHelperListener interface.

```kotlin
   override fun onStartDiscovery() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
   }

   override fun onFinishDiscovery() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
   }

   override fun onEnabledBluetooth() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
   }

   override fun onDisabledBluetooh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
   }

   override fun getBluetoothDeviceList(device: BluetoothDevice) {
        itemList.add(BluetoothDeviceModel(device.name, device.address))
        viewAdapter.notifyDataSetChanged()
   }
```


# Licence

	MIT License

	Copyright (c) 2018 Tolga Bolatcan

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
