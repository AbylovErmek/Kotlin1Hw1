package com.geektech.kotlin1hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.geektech.kotlin1hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val title = intent.getStringExtra("title2")
        binding.etTitle.setText(title)

        binding.btnNext.setOnClickListener {
            if (binding.etTitle.text.isEmpty()) {
                binding.etTitle.error = "Ошибка, заполните поле"
                Toast.makeText(this, "Ошибка, заполните поле", Toast.LENGTH_SHORT).show()
            } else startActivity()
        }
    }

    private fun startActivity() {
        val intent = Intent(this, SecondScreenActivity::class.java)
        intent.putExtra("title", binding.etTitle.text.toString())
        startActivity(intent)
    }
}