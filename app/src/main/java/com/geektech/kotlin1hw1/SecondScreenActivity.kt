package com.geektech.kotlin1hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.geektech.kotlin1hw1.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        checkIntent()
        setupListener()
    }

    private fun setupListener() {
        binding.btnNext2.setOnClickListener {
            if (!binding.etTitle2.text.isNullOrEmpty()) send()
            else binding.etTitle2.error = "Ошибка, пожалуйста заполните поле"
        }
    }

    private fun send() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("title", binding.etTitle2.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun checkIntent() {
        val text: String? = intent.getStringExtra("title")
        binding.etTitle2.setText(text)
    }
}