package com.example.donnagabriela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


class Localization_Page : AppCompatActivity() {


    data class Place(
        val name: String,
        val latLng: LatLng,
        val address: String,
        val rating: Float
    )

    private val places = arrayListOf(
        Place(
            "Google",
            LatLng(-23.5867982, -46.6843459),
            "Av. Brg. Faria Lima, 3477 - 18º Andar - Itaim Bibi, São Paulo - SP",
            4.8f
        ),
        Place(
            "Microsoft",
            LatLng(-23.5924263, -46.6905388),
            "Avenida Presidente Juscelino Kubitscheck, 1909 Torre Sul, 16° andar - Vila Nova Conceição, São Paulo - SP",
            4.9f
        ),

        )

    private fun addMarkers(googleMap: GoogleMap) {
        places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .position(place.latLng)
                .icon(
                    BitmapHelper.vectorToBitmap(this, R.drawable.ic_baseline_location_on_24, ContextCompat.getColor(this, R.color.locate_icon))
                )
            )

            marker?.tag = place;

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Hide the StatusBar and Action Bar:
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()

        //Prepare the Activity XML.
        setContentView(R.layout.activity_localization_page)


        //-------------------------     From here you can program:    ------------------------------

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            googleMap.setInfoWindowAdapter(MarkerInfoAdapter(this))
            addMarkers(googleMap)

            googleMap.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()
                places.forEach {
                    bounds.include(it.latLng)
                }

                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 300))
            }
        }
    }

    fun Menu(view: View) {

        val OpenMenuPage = Intent(
            baseContext,
            MenuPage::class.java
        )
        startActivity(OpenMenuPage)
    }

    fun Share(view: View) {

        val OpenSharePage = Intent(
            baseContext,
            SharePage::class.java
        )
        startActivity(OpenSharePage)

    }
}