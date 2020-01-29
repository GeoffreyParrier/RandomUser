package com.canark.randomUser.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.canark.randomUser.R
import com.canark.randomUser.model.RandomUsersResults
import com.canark.randomUser.model.Results
import com.canark.randomUser.network.ApiError
import com.canark.randomUser.network.ApiHelpers
import com.canark.randomUser.network.ApiRequestCallback
import com.canark.randomUser.recyclerview.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user.*
import java.io.Console
import java.util.function.UnaryOperator


class MainActivity : AppCompatActivity() {

    //Declare var
    lateinit var apiHelpersInstance: ApiHelpers
    lateinit var userAdapter: UserAdapter
    lateinit var userList : MutableList<Results>
    lateinit var add: Button
    lateinit var reset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init empty userList
        userList = mutableListOf()

        //init userAdapter
        userAdapter = UserAdapter(userList) { user: Results -> userItermClicked(user) }

        //Init recyclerView
        val recyclerView = recycleview_main

        // Setup layour manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Give his adapter
        recyclerView.adapter = userAdapter

        // Give context to apiHelper
        apiHelpersInstance = ApiHelpers(this)

        add = addData
        reset = resetDatas

        add.setOnClickListener {
            apiHelpersInstance.apiRequestUsersByCount(
                30, // Request parameter
                // Callback
                object : ApiRequestCallback<RandomUsersResults>() {
                    // Override super onSuccess method to apply changes to UI when get data
                    override fun onSuccess(result: RandomUsersResults) {
                        super.onSuccess(result)
                        // Log.d(MainActivity::class.java.canonicalName, "API Request SUCCESS !")

                        runOnUiThread {
                            userList.addAll(result.users) // Add data to adapter list
    //                        Log.d(MainActivity::class.java.canonicalName, "UserList modified !")
                            numberOfPerson.text = userList.size.toString()
                            userAdapter.notifyDataSetChanged() // refresh the adapter => RecyclerView
                            //                        Log.d(MainActivity::class.java.canonicalName, "Adapter Notified !")
                        }
                    }

                    // Override super onErrpr method to apply changes to UI when get data
                    override fun onError(error: ApiError?) {
                        super.onError(error)

                        runOnUiThread {
                            Log.e(
                                MainActivity::class.java.canonicalName,
                                "An error as occured on the API request"
                            )
                        }
                    }
                }
            )
        }

        reset.setOnClickListener {
            apiHelpersInstance.apiRequestUsersByCount(
                30, // Request parameter
                // Callback
                object : ApiRequestCallback<RandomUsersResults>() {
                    // Override super onSuccess method to apply changes to UI when get data
                    override fun onSuccess(result: RandomUsersResults) {
                        super.onSuccess(result)
                        // Log.d(MainActivity::class.java.canonicalName, "API Request SUCCESS !")

                        runOnUiThread {
                            userList.clear()
                            userList.addAll(result.users) // Add data to adapter list
                            //                        Log.d(MainActivity::class.java.canonicalName, "UserList modified !")
                            numberOfPerson.text = userList.size.toString()
                            userAdapter.notifyDataSetChanged() // refresh the adapter => RecyclerView
                            //                        Log.d(MainActivity::class.java.canonicalName, "Adapter Notified !")
                        }
                    }

                    // Override super onErrpr method to apply changes to UI when get data
                    override fun onError(error: ApiError?) {
                        super.onError(error)

                        runOnUiThread {
                            Log.e(
                                MainActivity::class.java.canonicalName,
                                "An error as occured on the API request"
                            )
                        }
                    }
                }
            )
        }

        // Call apiHelper to do the request
        apiHelpersInstance.apiRequestUsersByCount(
            30, // Request parameter
            // Callback
            object : ApiRequestCallback<RandomUsersResults>() {
                // Override super onSuccess method to apply changes to UI when get data
                override fun onSuccess(result: RandomUsersResults) {
                    super.onSuccess(result)
                    // Log.d(MainActivity::class.java.canonicalName, "API Request SUCCESS !")

                    runOnUiThread {
                        userList.addAll(result.users) // Add data to adapter list
//                        Log.d(MainActivity::class.java.canonicalName, "UserList modified !")
                        numberOfPerson.text = userList.size.toString()
                        userAdapter.notifyDataSetChanged() // refresh the adapter => RecyclerView
//                        Log.d(MainActivity::class.java.canonicalName, "Adapter Notified !")
                    }
                }

                // Override super onErrpr method to apply changes to UI when get data
                override fun onError(error: ApiError?) {
                    super.onError(error)

                    runOnUiThread {
                        Log.e(
                            MainActivity::class.java.canonicalName,
                            "An error as occured on the API request"
                        )
                    }
                }
            }
        )
    }

    private fun userItermClicked(user: Results) {
        Toast.makeText(this, "test", Toast.LENGTH_LONG).show()
    }
}
