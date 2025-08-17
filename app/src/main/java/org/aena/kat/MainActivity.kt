package org.aena.kat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.aena.kat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnForm.setOnClickListener {
            startActivity(Intent(this, ui.FormActivity::class.java))
        }
    }
}
