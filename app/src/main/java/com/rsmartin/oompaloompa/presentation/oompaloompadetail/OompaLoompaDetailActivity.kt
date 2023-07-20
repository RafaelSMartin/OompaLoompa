package com.rsmartin.oompaloompa.presentation.oompaloompadetail

import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.rsmartin.oompaloompa.BuildConfig
import com.rsmartin.oompaloompa.R
import com.rsmartin.oompaloompa.databinding.ActivityOompaLoompaDetailBinding
import com.rsmartin.oompaloompa.presentation.common.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class OompaLoompaDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityOompaLoompaDetailBinding

    private val viewModel by viewModel<OompaLoompaDetailViewModel>()

    private var ommpaLoompaId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOompaLoompaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()
        observeStatus()

        viewModel.getOompaLoompaDetail(ommpaLoompaId)
    }

    private fun getExtras() {
        ommpaLoompaId = intent.extras?.getInt(BuildConfig.EXTRA_OL_ID, 0)!!
    }

    private fun observeStatus() {
        super.observeStatus(viewModel, binding.root)

        viewModel.getHeroDetailObservable().observe(this, {
            if (it == null) {
                viewModel.showGeneralError()
            } else {
                with(binding) {
                    Glide.with(this@OompaLoompaDetailActivity)
                        .load(it.image ?: R.drawable.ic_launcher_background)
                        .into(imgOLDetail)

                    tvNameOLDetail.text = StringBuilder()
                        .append(it.first_name)
                        .append(" ")
                        .append(it.last_name).toString()

                    tvGenderOLDetail.text = it.gender
                    tvSongOLDetail.text = it.favorite.song

                    Log.d("OLDetailActivity", "observeStatus: ${it.toString()}")
                }
            }
        })
    }
}