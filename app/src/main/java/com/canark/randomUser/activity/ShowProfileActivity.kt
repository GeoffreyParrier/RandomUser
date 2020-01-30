package com.canark.randomUser.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canark.randomUser.R
import kotlinx.android.synthetic.main.activity_show_profile.*

class ShowProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_profile)

        val imageProfile = profileImageView
        val firstName = firstNameTextView
        val lastName = lastNameTextView
        val birthDate = birthDateTextView
        val age = ageTextView
        val address = addressTextView


    }
}
