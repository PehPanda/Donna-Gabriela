package com.example.donnagabriela

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.example.donnagabriela.databinding.ActivityLocalizationPageBinding

class RecyclerView_Locate : Fragment(R.layout.activity_localization_page) {

    private var binding: com.example.donnagabriela.databinding.ActivityLocalizationPageBinding? =
        null

    private val categoryAdapter = ATAdapter({ CategoryView(it) })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(
                1,
                "http://www.ifood.com.br/static/images/categories/market.png",
                "teste",
                0xFFB6D048
            ),
            Category(
                2,
                "http://www.ifood.com.br/static/images/categories/market.png",
                "teste2",
                0xFFFF0000
            )
        )

        binding = ActivityLocalizationPageBinding.bind(view)

        binding?.let {

            it.rvCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter
        }
    }
}