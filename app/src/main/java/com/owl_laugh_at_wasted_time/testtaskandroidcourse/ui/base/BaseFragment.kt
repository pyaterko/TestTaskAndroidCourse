package com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.MainActivity
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.ViewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


abstract class BaseFragment(layout: Int) : Fragment(layout) {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    protected val component by lazy {
        (activity as MainActivity).component
    }

    protected fun launchScope(block: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                block.invoke()
            }
        }
    }

    protected fun <T> Flow<T>.collectWhileStarted(block: (T) -> Unit) {
        launchAndRepeatOnStart {
            collect { block.invoke(it) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        setOnClickListener()
    }

    abstract fun setData()
    abstract fun setOnClickListener()

}