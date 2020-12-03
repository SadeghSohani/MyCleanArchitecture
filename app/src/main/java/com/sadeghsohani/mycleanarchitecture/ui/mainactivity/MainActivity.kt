package com.sadeghsohani.mycleanarchitecture.ui.mainactivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sadeghsohani.mycleanarchitecture.R
import com.sadeghsohani.mycleanarchitecture.databinding.ActivityMainBinding
import com.sadeghsohani.mycleanarchitecture.utils.coloredToast
import com.sadeghsohani.mycleanarchitecture.utils.findCleanComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Provider


@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: Provider<MainViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.builder()
            .databaseComponent(findCleanComponent().provideDatabaseComponent())
            .networkComponent(findCleanComponent().provideNetworkComponent())
            .build()
            .inject(this)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                viewModelProvider.get() as T
        }).get(MainViewModel:: class.java)

        binding.viewModel = viewModel

        btn_getFromServer.setOnClickListener {
            progress.visibility = View.VISIBLE
            viewModel.fetchDataFromServer()
        }

        viewModel.serverMsgLD.observe(this, Observer {
            progress.visibility = View.GONE
            coloredToast(it)
        })

        viewModel.serverErrLD.observe(this, Observer {
            progress.visibility = View.GONE
            coloredToast(it)
        })

        viewModel.nameFamilyLD.observe(this, Observer {
            coloredToast(it)
        })

    }
}
