package com.gokul.thepromo

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gokul.thepromo.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    //*** view binding ***

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // *** view Binding ***
        // yo binding ko sabai vanda important line
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer", "Other")
        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter
    }

    // *** View Binding ***

    private fun onPreviewClicked() {
        val message = Message(
            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextDisplayName.text.toString(),
            binding.editTextStartDate.text.toString(),
            binding.checkBoxImmediateStart.isChecked,
            binding.checkBoxJunior.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message",message)
        startActivity(previewActivityIntent)
    }

}
