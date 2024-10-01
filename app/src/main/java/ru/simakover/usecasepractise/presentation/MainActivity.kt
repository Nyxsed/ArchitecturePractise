package ru.simakover.usecasepractise.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.simakover.usecasepractise.R

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val firstNameEditView = findViewById<TextView>(R.id.firstNameEditText)
        val lastNameEditView = findViewById<TextView>(R.id.lastNameEditText)
        val sendButton = findViewById<TextView>(R.id.sendButton)
        val receiveButton = findViewById<TextView>(R.id.receiveButton)

        vm.userLiveData.observe(this, Observer {
            dataTextView.text = "first name = ${it.firstName} last name = ${it.lastName}"
        })

        sendButton.setOnClickListener {
            val firstName = firstNameEditView.text.toString()
            val lastName = lastNameEditView.text.toString()
            vm.saveUser(firstName, lastName)
        }

        receiveButton.setOnClickListener {
            vm.loadUser()
        }
    }
}