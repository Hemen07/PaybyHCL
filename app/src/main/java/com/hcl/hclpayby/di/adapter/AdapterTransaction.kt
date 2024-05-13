package com.hcl.hclpayby.ui.screens.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hcl.hclpaybay.R

class AdapterTransaction(private val dataSet: Array<String>) : RecyclerView.Adapter<AdapterTransaction.TransactionViewHolder>() {

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val mTransactionIcon: ImageView
        val mTVBeneName: TextView
        val mTVBankName: TextView
        val mTVAmountSent: TextView

        init {
            // Define click listener for the ViewHolder's View
            mTransactionIcon = view.findViewById(R.id.iv_transaction_type)
            mTVBeneName = view.findViewById(R.id.tv_bene_name)
            mTVBankName = view.findViewById(R.id.tv_bank_name)
            mTVAmountSent = view.findViewById(R.id.tv_amount_sent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_transaction_list_item, parent, false)

        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

        if (position % 3 == 0) {
            holder.mTransactionIcon.setBackgroundResource(R.drawable.credit_icon)
        } else {
            holder.mTransactionIcon.setBackgroundResource(R.drawable.debit_icon)
        }
    }

    override fun getItemCount(): Int {
        return 50
    }

}
