package com.example.zomato.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zomato.R
import com.android.databinding.library.baseAdapters.BR
import com.example.zomato.models.Restaurants

class RecyclerAdapter(val resList: List<Restaurants>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    companion object {
        const val TYPE_HEAD = 0
        const val TYPE_LIST = 1
    }

    var binding: ViewDataBinding? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewHolder {

        return if (p1 == TYPE_LIST) {
            RecyclerViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(p0.context),
                    R.layout.recycler_single, p0, false
                ), TYPE_LIST
            )

        } else {
            RecyclerViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(p0.context),
                    R.layout.categories_recycler_view, p0, false
                ), TYPE_HEAD
            )
        }
    }

    override fun getItemCount(): Int {
        return resList.size
    }

    override fun onBindViewHolder(p0: RecyclerViewHolder, p1: Int) {
        if (p0.equals(TYPE_LIST)) {
            p0.bind(resList.get(p1))
        } else if (p0.equals(TYPE_HEAD)) {

        }
    }

    class RecyclerViewHolder(var binding: ViewDataBinding, var viewType: Int) :
        RecyclerView.ViewHolder(binding.getRoot()) {

        fun bind(data: Restaurants) {
            binding.setVariable(BR.restaurants, data)
            binding.executePendingBindings()
        }

        fun bind1() {

        }

        init {
            if (viewType == TYPE_HEAD) {
                viewType = 0
            } else if (viewType == TYPE_LIST) {
                viewType = 1
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (position != 0) {
            TYPE_LIST
        } else {
            TYPE_HEAD
        }
    }
}