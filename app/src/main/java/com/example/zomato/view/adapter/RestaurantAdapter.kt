package com.example.zomato.view.adapter

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.zomato.R
import com.android.databinding.library.baseAdapters.BR
import com.example.zomato.databinding.CategoriesRecyclerViewBinding
import com.example.zomato.databinding.RecyclerSingleBinding
import com.example.zomato.models.Restaurants
import com.example.zomato.view.DetailActivity

class RestaurantAdapter(
    val resList: List<Restaurants>,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_DETAIL = 2
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(p0.context)

        return when (p1) {
            TYPE_HEADER -> {
                HeaderViewHolder(
                    DataBindingUtil.inflate(
                        layoutInflater,
                        R.layout.categories_recycler_view,
                        p0,
                        false
                    )
                )
            }

            TYPE_DETAIL -> {
                DetailViewHolder(
                    DataBindingUtil.inflate(
                        layoutInflater,
                        R.layout.recycler_single,
                        p0,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {
        return resList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val element = resList.get(p1)

        when (p0) {
            is DetailViewHolder -> {
                p0.bind(element)
                p0.navigate(resList.get(p1).restaurant!!.url)

            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (position == 0) {
            TYPE_HEADER
        } else {
            TYPE_DETAIL
        }
    }

    inner class HeaderViewHolder(private val binding: CategoriesRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageList: Array<Int>) = with(binding) {
            binding.categoryRecyclerView.adapter = categoriesAdapter(imageList)
            binding.categoryRecyclerView.layoutManager = LinearLayoutManager(
                binding.categoryRecyclerView.context,
                LinearLayout.HORIZONTAL, false
            )
            binding.executePendingBindings()
        }
    }

    inner class DetailViewHolder(private val binding: RecyclerSingleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(response: Restaurants) = with(binding) {
            binding.setVariable(BR.restaurants, response)
            binding.executePendingBindings()
        }

        fun navigate(url: String) {
            binding.nameTextView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("url", url)
                context.startActivity(intent)
            }
        }
    }

    inner class SearchViewHolder(inflate: View?) : RecyclerView.ViewHolder(inflate!!)
}

