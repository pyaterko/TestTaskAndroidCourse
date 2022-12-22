package com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.R
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.databinding.FragmentDetailsBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.BaseFragment
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.getStringOfBoolean
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.delegate.viewBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.DetailsViewModel


class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val viewModel by viewModels<DetailsViewModel> { viewModelFactory }
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var data: CardItem

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
        data = args.cardinfo
    }

    override fun setOnClickListener() {
        with(binding) {
            tvBankPhone.setOnClickListener {
                viewModel.openDialPad(requireContext(), data.bank_phone)
            }
            tvBankName.setOnClickListener {
                viewModel.openMap(requireContext(), data.country_latitude, data.country_longitude)
            }
            tvBankUrl.setOnClickListener {
                (data.bank_url)?.let {
                    viewModel.openWebPage(requireContext(), it)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setData() {
        with(binding) {
            tvBin.text = "${data.bin.take(4)} ${data.bin.drop(4)}"
            tvScheme.text = data.scheme
            tvType.text = data.type
            tvBrand.text = data.brand
            tvPrepaid.text = getStringOfBoolean(requireContext(), data.prepaid ?: false)
            tvLength.text = data.number_length.toString()
            tvLuhn.text = getStringOfBoolean(requireContext(), data.number_luhn ?: false)
            tvCountry.text = "${data.country_emoji ?: ""} ${data.country_name ?: ""}"
            tvLongitude.text = String.format(
                getString(R.string.latitude_56_longitude_10),
                data.country_latitude, data.country_longitude
            )
            tvBankName.text = "${data.bank_name ?: ""}  ${data.bank_city ?: ""}"
            tvBankUrl.text = data.bank_url
            tvBankPhone.text = data.bank_phone
        }

    }

}