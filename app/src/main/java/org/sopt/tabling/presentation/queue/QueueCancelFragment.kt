package org.sopt.tabling.presentation.queue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.tabling.databinding.FragmentQueueCancelBinding

class QueueCancelFragment : Fragment() {
    private var _binding: FragmentQueueCancelBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentQueueCancelBinding.inflate(inflater, container, false)
        return binding.root
    }
}
