package com.s74823.lab2_personalanalysis_s74823

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNama = findViewById<EditText>(R.id.editNama)
        val editTarikh = findViewById<EditText>(R.id.editTarikh)
        val btnAnalisis = findViewById<Button>(R.id.btnAnalisis)

        btnAnalisis.setOnClickListener {
            val nama = editNama.text.toString().trim()
            val tarikhLahir= editTarikh.text.toString().trim()

            if (nama.isEmpty() && tarikhLahir.isEmpty()) {
                Toast.makeText(this, "Sila isi semua field", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nama", nama)
                intent.putExtra("tarikhLahir", tarikhLahir)
                startActivity(intent)
            }
        }
    }
}