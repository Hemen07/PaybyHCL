package com.hcl.hclpayby.di.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hcl.hclpaybay.R

class AdapterBeneficiaries(private val dataSet: Array<String>) : RecyclerView.Adapter<AdapterBeneficiaries.TransactionViewHolder>() {

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val mFavIcon: ImageView
        val mTVBeneName: TextView
        val mTVBeneAccount: TextView

        init {
            // Define click listener for the ViewHolder's View
            mFavIcon = view.findViewById(R.id.iv_favourite)
            mTVBeneName = view.findViewById(R.id.tv_beneficiary)
            mTVBeneAccount = view.findViewById(R.id.tv_account_num)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_beneficiaries_list_item, parent, false)

        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

        if (position % 3 == 0) {
            holder.mFavIcon.setBackgroundResource(R.drawable.fav_empty_icon)
        } else {
            holder.mFavIcon.setBackgroundResource(R.drawable.fav_filled_icon)
        }
    }

    override fun getItemCount(): Int {
        return 50
    }

}
