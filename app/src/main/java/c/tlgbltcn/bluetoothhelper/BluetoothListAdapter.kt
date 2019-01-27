package c.tlgbltcn.bluetoothhelper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bluetooth_device.view.*

/**
 * Created by tolga bolatcan on 26.01.2019
 */
class BluetoothListAdapter(private var item: ArrayList<BluetoothDeviceModel>) :
    RecyclerView.Adapter<BluetoothListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bluetooth_device, parent, false)
        return ViewHolder(view as ConstraintLayout)
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.apply {
            device_name.text = item[position].name
            macAddress.text = item[position].macNumber
        }
    }

    class ViewHolder(val view: ConstraintLayout) : RecyclerView.ViewHolder(view)
}