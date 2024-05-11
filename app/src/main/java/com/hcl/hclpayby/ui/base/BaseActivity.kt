package com.hcl.hclpayby.ui.base

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hcl.hclpaybay.R

private const val TAG = "Pixel-BA : "

/**
 * Base class for activity
 */
abstract class BaseActivity : AppCompatActivity() {


    /**
     * Abstract to Get the toolbar title.
     *
     * @return
     */
    abstract fun getToolbarTitle(): String

    /**
     * OnStart
     *
     * 1. Setting up the toolbar
     * 2. Setting up the Home back button
     */
    override fun onStart() {
        super.onStart()
        setToolbarTitle(getToolbarTitle())
    }

    /**
     * Set toolbar title
     */
    protected fun setToolbarTitle(toolbarTitle: String) {
        getToolbar().text = toolbarTitle
    }

    /**
     * Get up button
     */
    protected fun getUpButton(): ImageView = findViewById(R.id.imbToolbarBack)

    /**
     * Get toolbar
     */
    private fun getToolbar(): TextView = findViewById(R.id.toolbarTitle)
}