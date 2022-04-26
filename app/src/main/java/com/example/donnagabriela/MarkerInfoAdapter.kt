package com.example.donnagabriela

import android.content.Context;
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class MarkerInfoAdapter(private val context:Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? = null

    override fun getInfoContents(marker: Marker): View? {

        val place = marker.tag as? Localization_Page.Place ?: return null

        val view =  LayoutInflater.from(context).inflate(R.layout.custom_marker_info, null)

        view.findViewById<TextView>(R.id.txt_title_map_description).text = place.name
        view.findViewById<TextView>(R.id.txt_address_map_description).text = place.address
        view.findViewById<TextView>(R.id.txt_rating_map_description).text = context.getString(R.string.rating, place.rating)

        return view
    }
}