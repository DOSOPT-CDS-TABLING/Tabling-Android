package org.sopt.tabling.presentation.queue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.tabling.databinding.FragmentQueueReservationBinding
import org.sopt.tabling.presentation.common.ReservationViewModel

class QueueReservationFragment : Fragment() {
    private var _binding: FragmentQueueReservationBinding? = null
    private val binding: FragmentQueueReservationBinding
        get() = requireNotNull(_binding){ "바인딩 객체가 생성되지 않았습니다." }
    private val viewModel by viewModels<ReservationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQueueReservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reservationAdapter = ReservationAdapter(requireContext())
        binding.rvReservationItems.adapter = reservationAdapter
        reservationAdapter.setReservationList(viewModel.mockReservationList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
