package com.rsmartin.oompaloompa.presentation.oompaloompalist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsmartin.oompaloompa.databinding.ActivityOompaLoompaListBinding
import com.rsmartin.oompaloompa.presentation.common.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class OompaLoompaListActivity : BaseActivity() {

    private lateinit var binding: ActivityOompaLoompaListBinding

    private val viewModel by viewModel<OompaLoompaListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOompaLoompaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        observeStatus()

        viewModel.getOompaLoompasList()
    }

    private fun initViews() {
        initHeroesRecycler()
    }

    private fun initHeroesRecycler() {
        with(binding.recyclerOopaLoompas) {
            layoutManager = LinearLayoutManager(this@OompaLoompaListActivity)

            val heroesAdapter = OompaLoompaListAdapter(this@OompaLoompaListActivity)
            adapter = heroesAdapter
        }
    }

    private fun observeStatus() {
        super.observeStatus(viewModel, binding.root)

        viewModel.getOompaLoompaListObservable().observe(this, {
            binding.tvNoResults.visibility = if (it.results.isEmpty()) {
                View.VISIBLE
            } else {
                View.GONE
            }
            (binding.recyclerOopaLoompas.adapter as OompaLoompaListAdapter).setItemList(it.results)
            setRecyclerViewScrollListener()
        })
    }

    private fun setRecyclerViewScrollListener() {
        with(binding.recyclerOopaLoompas) {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if ((layoutManager as LinearLayoutManager).findLastVisibleItemPosition() == (adapter as OompaLoompaListAdapter).itemCount - 1) {
                        viewModel.getOompaLoompasList()
                        removeOnScrollListener(this)
                    }
                }
            })
        }
    }
}