package com.example.hiltdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.R
import com.example.hiltdemo.data.LoggerLocalDataSource
import com.example.hiltdemo.util.DateFormatter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays the database logs.
 */
@AndroidEntryPoint
class LogsFragment : Fragment() {
    @Inject
    lateinit var logger: LoggerLocalDataSource
    @Inject
    lateinit var dateFormatter: DateFormatter
/*
    private lateinit var logger: LoggerLocalDataSource
    private lateinit var dateFormatter: DateFormatter*/

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
        }
    }

    /* override fun onAttach(context: Context) {
         super.onAttach(context)

         populateFields(context)
     }

     private fun populateFields(context: Context) {
         logger = (context.applicationContext as LogApplication).serviceLocator.loggerLocalDataSource
         dateFormatter =
             (context.applicationContext as LogApplication).serviceLocator.provideDateFormatter()
     }
 */
    override fun onResume() {
        super.onResume()

        logger.getAllLogs { logs ->
            recyclerView.adapter =
                LogsViewAdapter(
                    logs,
                    dateFormatter
                )
        }
    }
}

