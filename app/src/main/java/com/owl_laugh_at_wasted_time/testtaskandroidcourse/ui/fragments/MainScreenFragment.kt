package com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.R
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.databinding.FragmentMainScreenBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.BaseFragment
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.delegate.viewBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.MainScreenViewModel

class MainScreenFragment : BaseFragment(R.layout.fragment_main_screen) {
    private val binding by viewBinding(FragmentMainScreenBinding::bind)
    private val viewModel by viewModels<MainScreenViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun setOnClickListener() {
        binding.cardInfo.setOnClickListener {
            isProgressBar(true)
            launchScope {
                if (getConnectionType(requireContext()) > 0) {
                    kotlin.runCatching {
                        val data = viewModel.getData(binding.etBin.text.toString())
                        val cardItem = CardItem(
                            bin = binding.etBin.text.toString(),
                            number_length = data.number.length,
                            number_luhn = data.number.luhn,
                            scheme = data.scheme,
                            type = data.type,
                            brand = data.brand,
                            prepaid = data.prepaid,
                            country_name = data.country.name,
                            country_emoji = data.country.emoji,
                            country_latitude = data.country.latitude,
                            country_longitude = data.country.longitude,
                            bank_name = data.bank.name,
                            bank_url = data.bank.url,
                            bank_phone = data.bank.phone,
                            bank_city = data.bank.city
                        )
                        viewModel.add(cardItem)
                        val directions =
                            MainScreenFragmentDirections.actionMainScreenFragmentToDetailsFragment(
                                cardItem
                            )
                        findNavController().navigate(directions)
                        isProgressBar(false)
                    }.onFailure {
                        isProgressBar(false)
                        Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                        Log.d("TAG", it.message.toString())
                    }
                } else {
                    isProgressBar(false)
                    Toast.makeText(requireContext(), "no internet", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun getConnectionType(context: Context): Int {
        var result = 0
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    result = 2
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    result = 1
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    result = 3
                }
            }
        }
        return result
    }

    private fun isProgressBar(isShow: Boolean) = if (isShow) {
        binding.cardInfo.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
    } else {
        binding.cardInfo.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }

    override fun setData() {}
}