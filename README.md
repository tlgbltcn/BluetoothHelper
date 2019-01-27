Bluetooth Helper
=============

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
