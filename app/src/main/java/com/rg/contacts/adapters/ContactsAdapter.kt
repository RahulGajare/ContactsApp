package com.rg.contacts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rg.contacts.R
import com.rg.contacts.entities.Contact
import com.rg.contacts.interfaces.ItemClick

class ContactAdapter(private val dataSet: List<Contact>, val itemClick : ItemClick) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val imageView : ImageView
        val number : ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.tvName)
            imageView = view.findViewById(R.id.ivPicture)
            number = view.findViewById(R.id.tvMobile)


        }

        fun bind(contact : Contact, clickListener: ItemClick)
        {
            name.text = contact.name
            imageView.setImageResource(R.drawable.ic_add)
            number.setOnClickListener(View.OnClickListener {
                clickListener.onItemClicked(contact)
            })


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)

        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val group = dataSet[position]

        holder.bind(group,itemClick)
    }
}