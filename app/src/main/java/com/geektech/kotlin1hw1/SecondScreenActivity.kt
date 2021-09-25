package com.geektech.kotlin1hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.geektech.kotlin1hw1.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        binding.etTitle2.setText(title)

        binding.btnNext2.setOnClickListener {
            if (binding.etTitle2.text.isEmpty()) {
                binding.etTitle2.error = "Ошибка, заполните поле"
                Toast.makeText(this, "Ошибка, заполните поле", Toast.LENGTH_SHORT).show()
            } else finishActivity()
        }
    }

    private fun finishActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("title2", binding.etTitle2.text.toString())
        startActivity(intent)
    }
}