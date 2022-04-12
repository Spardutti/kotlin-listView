package com.example.numberlist

import android.content.Context
import android.media.Image
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var arrayList: ArrayList<Data>) : BaseAdapter() {
    override fun getCount() = arrayList.size

    override fun getItem(p0: Int) = arrayList[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var rowView: View? = p1

        val context = p2?.context
        val inflater: LayoutInflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if (rowView == null) {
            rowView = inflater.inflate(R.layout.item_list, p2, false)
        }

        val item = arrayList[p0]

        val numberTextView = rowView?.findViewById<TextView>(R.id.number_text_view)

        numberTextView?.text = item.number

        val audioImageView = rowView?.findViewById<ImageView>(R.id.audio_image_view)

        audioImageView?.setOnClickListener {

            val mediaPlayer =
                MediaPlayer.create(
                    context,
                    context.resources.getIdentifier(item.audioFileName, "raw", context.packageName)
                )
            mediaPlayer.start()
        }

        return rowView!!
    }
}