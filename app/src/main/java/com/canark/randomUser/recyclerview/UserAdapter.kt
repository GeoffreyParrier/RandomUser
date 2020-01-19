package com.canark.randomUser.recyclerview;

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.canark.randomUser.R
import com.canark.randomUser.model.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val myDataset: MutableList<Results>)  : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Setup element to update on itemView by ID
        val _firstName = itemView.item_user_firstName
        val _lastName = itemView.item_user_lastName
        val _picture = itemView.item_user_thumbnail
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): UserViewHolder {
        var itemView =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_user, parent, false) // Change the name of item layout
                    as View
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder._firstName.text = myDataset[position].name.first // Setup data on elements
        holder._lastName.text = myDataset[position].name.last // Setup data on elements
        Picasso.get().load(myDataset[position].picture.thumbnail).into(holder._picture)
//        Log.d(UserAdapter::class.java.canonicalName, "new username : ${myDataset[position].login.username}")
    }

    override fun getItemCount() = myDataset.size
}
