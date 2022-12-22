package com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.fragments

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.elveum.elementadapter.simpleAdapter
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.R
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.databinding.CardItemBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.databinding.FragmentHistoryBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.BaseFragment
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.delegate.viewBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.HistoryViewModel

class HistoryFragment : BaseFragment(R.layout.fragment_history) {

    private val binding by viewBinding(FragmentHistoryBinding::bind)
    private val viewModel by viewModels<HistoryViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun setData() {
        val adapter = simpleAdapter<CardItem, CardItemBinding> {
            areItemsSame = { oldItem, newItem -> oldItem.id == newItem.id }
            bind { item ->
                tvBin.text = item.bin
                tvBrand.text = item.brand
                tvTypes.text = item.type
                tvBank.text = item.bank_name
            }
        }
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistory.adapter = adapter
        viewModel.getData().collectWhileStarted {
            adapter.submitList(it)
        }
    }

    override fun setOnClickListener() {}
}