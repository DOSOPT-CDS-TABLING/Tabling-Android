package org.sopt.tabling.presentation.dummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGogogo.setOnClickListener{
            WaitingDialog().show(
                supportFragmentManager, "WaitingDialog"
            )
        }
    }
}