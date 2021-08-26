package com.example.hiltdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltdemo.LogApplication
import com.example.hiltdemo.R
import com.example.hiltdemo.navigator.AppNavigator
import com.example.hiltdemo.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Main activity of the application.
 *
 * Container for the Buttons & Logs fragments. This activity simply tracks clicks on buttons.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: AppNavigator
   // private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // navigator = (applicationContext as LogApplication).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}