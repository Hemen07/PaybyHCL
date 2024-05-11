package com.hcl.hclpayby.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.google.android.material.snackbar.Snackbar
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.ActivityMainBinding
import com.hcl.hclpayby.ui.base.BaseActivity
import com.hcl.hclpayby.ui.extensions.commonBackLogic
import com.hcl.hclpayby.ui.extensions.onBackPressManagement
import com.msi.tnav32.ui.vm.SharedNavigationVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


private const val TAG = "Pixel-MA : "

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var navController: NavController

    private val sharedNavigationVM: SharedNavigationVM by viewModels()

    private val mainMenuProvider = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.menu_main, menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return when (menuItem.itemId) {
                R.id.menu_action_about -> {
                    Log.i(TAG, "onOptionsItemSelected: about : TAP TAP ")
                    true
                }

                else -> false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        Log.e(TAG, "onCreate: ||||| MA ||||| ")
        // Trust me, I would not have used this, but this is for mainly, onCreateOptionsMenu to show
        setSupportActionBar(binding.toolbarMain.toolbar)
        addOptionsMainMenu()
        // nav controller
        navController =
            (supportFragmentManager.findFragmentById(R.id.fcv_activity_main) as NavHostFragment).navController

        // TRACK or debug info
        someTracking()

        // BACK-PRESS Management, exit app only at HomeFragment else POP
        onBackPressManagement(
            tag = TAG,
            navController = navController,
        )
        //-----------------------------------------------------------------------------

        sharedNavigationVmObserver()


        //
        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED, block = {
                navController.currentBackStackEntryFlow.collect {
                    Log.i(TAG, "currentBackStackEntryFlow : <<< Observe >>> = $it")
                    //
                    setTvActivityStatus()
                    //
                    toolbarThingy(label = it.destination.label)
                }
            })
        }
    }

    /**
     * Overridden from Base
     * Here,      // BACK-PRESS Management, for Toolbar back
     */
    override fun onStart() {
        super.onStart()
        getUpButton().setOnClickListener {
            commonBackLogic(tag = TAG, activity = this@MainActivity, navController = navController)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun getToolbarTitle() = getString(R.string.app_name)

    private fun addOptionsMainMenu() {
        // New API ....cha cha cha
        addMenuProvider(
            provider = mainMenuProvider,
            owner = this@MainActivity,
            state = Lifecycle.State.RESUMED
        )
    }

    private fun removeOptionsMenu() {
        removeMenuProvider(provider = mainMenuProvider)
    }

    private fun toolbarThingy(label: CharSequence? = "HomeFragment") {
        Log.d(TAG, "toolbarThingy: label = $label")
        // modifying main toolbar, like adding a different options menu for Email
    }

    /**
     * Shared Navigation related Vm Observer
     */
    private fun sharedNavigationVmObserver() {
        Log.d(TAG, "sharedNavigationVmObserver: ")
        // navigation bundle and popUpTo related.
        sharedNavigationVM.uiStateNavigation().observe(this@MainActivity) { state ->
            Log.i(TAG, "NAVIGATION: ||||| OBSERVE |||||")
            goTo(actionId = state.keys.first(), bundle = state.values.first())
        }

        // for toolbar title
        sharedNavigationVM.uiStateToolbar().observe(this@MainActivity) { title ->
            Log.i(TAG, "TOOLBAR TITLE: ||||| OBSERVE ||||| : title = $title")
            setToolbarTitle(title)
        }
    }


    /**
     * Helper for Navigating to a different screen
     *
     * This is much easier to pass bundle
     * @param actionId : Action Id destination
     * @param bundle : Bundle, default will be empty
     */
    private fun goTo(@IdRes actionId: Int, bundle: Bundle) {
        Log.v(TAG, "goTo: ---->>>> bundle any? = $bundle")
        try {
            // for popup To
            if (bundle.containsKey("POPUPTO")) {
                Log.v(TAG, "goTo--------POPUPTO")

                navController.navigate(
                    resId = actionId,
                    args = null,
                    navOptions = navOptions {
                        //
                        this.popUpTo(R.id.settingsFragment) {
                            inclusive = true
                        }
                        //
                        anim {
                            enter = android.R.animator.fade_in
                            exit = android.R.animator.fade_out
                        }
                    }
                )

            } else {
                // for typical navigation, adding to backstack with  each navigation
                navController.navigate(
                    resId = actionId,
                    args = bundle,
                    navOptions = navOptions {
                        anim {
                            enter = android.R.animator.fade_in
                            exit = android.R.animator.fade_out
                        }
                    }
                )
            }
        } catch (e: Exception) {
            Log.v(TAG, "Exception = $e")
            Snackbar.make(
                binding.root,
                "WHOAAA !! What happened = ${e.message}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }


    /**
     * Just that TextView of MA giving some debug info
     *
     */
    @SuppressLint("SetTextI18n")
    private fun setTvActivityStatus() {
        binding.tvStatusActivityMain.text = "STATUS : ${navController.currentDestination?.label}"
    }

    /**
     * Some tracking
     */
    private fun someTracking() {
        //
        setTvActivityStatus()
        //
        binding.tvStatusActivityMain.setOnClickListener {
            Log.i(TAG, "tvStatusActivity: TAP TAP ")
            Log.v(TAG, "currentBackStack = ${navController.currentBackStack.value}")
            Log.v(TAG, "currentBackStack size = ${navController.currentBackStack.value.size}")
            Log.v(TAG, "currentDestination = ${navController.currentDestination}")
            Log.v(TAG, "label = ${navController.currentDestination?.label}")
            Log.v(TAG, "displayName = ${navController.currentDestination?.displayName}")
        }
    }
}