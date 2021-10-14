package com.geektech.kotlin1hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.kotlin1hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        registerForResult()
        setupListener()
    }

    private fun registerForResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK)
                    checkData(result.data)
            }
    }

    private fun checkData(data: Intent?) {
        if (data != null) {
            val text = data.getStringExtra("title")
            binding.etTitle.setText(text)
        }
    }

    private fun setupListener() {
        binding.btnNext.setOnClickListener {
            if (!binding.etTitle.text.isNullOrEmpty()) send()
            else binding.etTitle.error = "Ошибка, пожалуйста заполните поле"
        }
    }

    private fun send() {
        val intent = Intent(this, SecondScreenActivity::class.java)
        intent.putExtra("title", binding.etTitle.text.toString())
        resultLauncher.launch(intent)
    }
}