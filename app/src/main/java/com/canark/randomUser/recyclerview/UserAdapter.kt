package com.canark.randomUser.recyclerview;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canark.randomUser.R
import com.canark.randomUser.model.Results
import kotlinx.android.synthetic.main.activity_show_profile.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import org.w3c.dom.Text

class UserAdapter(private val myDataset: MutableList<Results>, val clickListener: (Results) -> Unit)  : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Setup element to update on itemView by ID
        val _firstName = itemView.item_user_firstName
        val _lastName = itemView.item_user_lastName
        val _picture = itemView.item_user_thumbnail
        val _age = itemView.birthDateTextView
        val _address = itemView.addressTextView
        val _profileImage = itemView.profileImageView
        val _phone =  itemView.ageTextView

        fun bind(result: Results, clickListener: (Results) -> Unit) {
            _firstName.text = result.name.first
            _lastName.text = result.name.first
            _picture.contentDescription = result.picture.thumbnail
            _age.text = result.dob.age.toString()
            _address.text = result.location.country
            _profileImage.contentDescription = result.picture.medium
            _phone.text = result.phone

            itemView.setOnClickListener { clickListener(result) }
        }
        init {
            itemView.setOnClickListener {
                println("Test")
                /*View.OnClickListener {
                    view ->
                    val intent = Intent(view.context, ShowProfileActivity::class.java)
                    view.context.startActivity(intent)
                }*/
            }
        }
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

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(myDataset[position], clickListener)

    override fun getItemCount() = myDataset.size

}
