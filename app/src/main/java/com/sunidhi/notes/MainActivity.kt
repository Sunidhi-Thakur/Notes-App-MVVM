package com.sunidhi.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunidhi.notes.databinding.ActivityMainBinding
import com.sunidhi.notes.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val userEntity = UserEntity(name = binding.editNote.text.toString())
            viewModel.insertRecord(userEntity)
            binding.editNote.setText("")
        }
        initVM()
    }

    private fun initVM(){
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecordObserver().observe(this, object : Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                binding.tvNote.text = ""
                t?.forEach {
                    binding.tvNote.append(it.name + "\n")
                }
            }

        })
    }
}