package org.sopt.tabling.presentation.dummy

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityDummyBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.util.binding.BindingActivity

class DummyActivity : BindingActivity<ActivityDummyBinding>(R.layout.activity_dummy) {
    private val dummyViewModel: DummyViewModel by viewModels { ViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dummyViewModel = dummyViewModel
    }
}
