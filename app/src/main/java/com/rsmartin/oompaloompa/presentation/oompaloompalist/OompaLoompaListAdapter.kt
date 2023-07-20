package com.rsmartin.oompaloompa.presentation.oompaloompalist

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rsmartin.domain.model.OompaLoompaItem
import com.rsmartin.oompaloompa.BuildConfig
import com.rsmartin.oompaloompa.databinding.ItemOompaLoompaBinding
import com.rsmartin.oompaloompa.presentation.common.toOompaLoompaGender
import com.rsmartin.oompaloompa.presentation.oompaloompadetail.OompaLoompaDetailActivity

class OompaLoompaListAdapter(
    private val context: Activity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<OompaLoompaItem> = ArrayList()

    fun setItemList(itemList: List<OompaLoompaItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return OompaLoompaViewHolder(
            ItemOompaLoompaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder).bind(itemList[position], position)
    }

    override fun getItemCount(): Int = itemList.size

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(oompaLoompaItem: OompaLoompaItem, position: Int)
    }

    internal inner class OompaLoompaViewHolder(
        private val itemBinding: ItemOompaLoompaBinding
    ) : BaseViewHolder(itemBinding.root) {
        override fun bind(oompaLoompaItem: OompaLoompaItem, position: Int) {
            with(itemBinding) {
                tvHeroName.text = StringBuilder()
                    .append(oompaLoompaItem.first_name)
                    .append(" ")
                    .append(oompaLoompaItem.last_name).toString()

                Glide.with(context)
                    .load(oompaLoompaItem.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgCardBackground)

                Glide.with(context)
                    .load(oompaLoompaItem.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgOLThumbnail)

                tvEmail.text = oompaLoompaItem.email
                tvProfession.text = oompaLoompaItem.profession
                tvGender.text = oompaLoompaItem.gender.toOompaLoompaGender()
                tvCountry.text = oompaLoompaItem.country
            }

            itemView.setOnClickListener {
                val oompaLoompaId = itemList[position].id
                val detailHeroIntent = Intent(context, OompaLoompaDetailActivity::class.java)
                detailHeroIntent.putExtra(BuildConfig.EXTRA_OL_ID, oompaLoompaId)
                context.startActivity(detailHeroIntent)
            }
        }
    }
}