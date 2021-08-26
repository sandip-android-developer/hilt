package com.example.hiltdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hiltdemo.R
import com.example.hiltdemo.data.LoggerLocalDataSource
import com.example.hiltdemo.navigator.AppNavigator
import com.example.hiltdemo.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays buttons whose interactions are recorded.
 */
@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @Inject
    lateinit var logger: LoggerLocalDataSource
    @Inject
    lateinit var navigator: AppNavigator
/*
    private lateinit var logger: LoggerLocalDataSource
    private lateinit var dateFormatter: DateFormatter*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    /* override fun onAttach(context: Context) {
         super.onAttach(context)

         populateFields(context)
     }

     private fun populateFields(context: Context) {
         logger = (context.applicationContext as LogApplication).
         serviceLocator.loggerLocalDataSource

         navigator = (context.applicationContext as LogApplication).
         serviceLocator.provideNavigator(requireActivity())
     }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}