package com.owl_laugh_at_wasted_time.testtaskandroidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.databinding.ActivityMainBinding
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base.delegate.viewBinding

class MainActivity : AppCompatActivity() {

    val component by lazy {
        Initializer.component(this)
    }

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.navView, navController)

    }
}