package ru.simakover.usecasepractise.presentation

import android.os.Bundle
import android.widget.Button
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
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)
        val backToOldButton = findViewById<Button>(R.id.backToOldButton)

        vm.stateLiveData.observe(this, Observer {state ->
            dataTextView.text = "first name = ${state.firstName} last name = ${state.lastName}"
        })

        sendButton.setOnClickListener {
            val firstName = firstNameEditView.text.toString()
            val lastName = lastNameEditView.text.toString()
            vm.send(SaveUserEvent(firstName, lastName))
        }

        receiveButton.setOnClickListener {
            vm.send(LoadUserEvent())
        }

        backToOldButton.setOnClickListener {
            vm.send(BackToOldUserEvent())
        }

    }
}