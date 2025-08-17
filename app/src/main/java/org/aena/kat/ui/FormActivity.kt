package org.aena.kat.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.aena.kat.data.AppDatabase
import org.aena.kat.data.FormEntity
import org.aena.kat.databinding.ActivityFormBinding
import org.aena.kat.network.RetrofitClient

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)

        binding.btnSave.setOnClickListener {
            val field1 = binding.editField1.text.toString()
            val field2 = binding.editField2.text.toString()
            if (field1.isNotBlank() && field2.isNotBlank()) {
                val form = FormEntity(field1 = field1, field2 = field2)
                lifecycleScope.launch {
                    db.formDao().insert(form)
                    try {
                        RetrofitClient.api.sendForm(form)
                    } catch (e: Exception) { /* ignorar falha offline */ }
                    Toast.makeText(this@FormActivity, "Formulário salvo!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}
