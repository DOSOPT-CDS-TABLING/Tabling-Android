package org.sopt.tabling.presentation.queue

import android.os.Bundle
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityQueueDetailsBinding
import org.sopt.tabling.util.binding.BindingActivity

class QueueDetailsActivity : BindingActivity<ActivityQueueDetailsBinding>(R.layout.activity_queue_details) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_reservation)
        if(currentFragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_reservation, QueueReservationFragment())
                .commit()
        }

    }
}