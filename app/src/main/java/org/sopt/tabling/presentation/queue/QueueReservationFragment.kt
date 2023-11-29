package org.sopt.tabling.presentation.queue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.tabling.data.ServicePool
import org.sopt.tabling.data.model.request.RequestApplyCodeDto
import org.sopt.tabling.data.model.response.ResponseApplyCodeDto
import org.sopt.tabling.data.model.response.ResponseReservationDto
import org.sopt.tabling.databinding.FragmentQueueReservationBinding
import org.sopt.tabling.util.extension.showToast
import retrofit2.Call
import retrofit2.Response

class QueueReservationFragment : Fragment() {
    private var _binding: FragmentQueueReservationBinding? = null
    private val binding: FragmentQueueReservationBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않았습니다." }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentQueueReservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setReservationList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setReservationList() {
        ServicePool.reservationListService.getReservationList()
            .enqueue(object : retrofit2.Callback<ResponseReservationDto> {
                override fun onResponse(
                    call: Call<ResponseReservationDto>,
                    response: Response<ResponseReservationDto>,
                ) {
                    if (response.isSuccessful) {
                        val data: ResponseReservationDto = response.body()!!
                        setReservationAdapter(data.reservationList)
                        if (response.code() == 500) {
                            context!!.showToast("서버 에러 발생")
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseReservationDto>, t: Throwable) {
                    context!!.showToast("네트워크 에러 발생")
                }
            })
    }

    private fun setReservationAdapter(reserveList: List<ResponseReservationDto.Reservation>) {
        val reservationAdapter = ReservationAdapter(requireContext(), ::patchApplyCode)
        reservationAdapter.setReservationList(reserveList)
        binding.rvReservationItems.adapter = reservationAdapter
    }

    private fun patchApplyCode(orderId: Int) {
        ServicePool.applyCodeService.applyCode(RequestApplyCodeDto(orderId))
            .enqueue(object : retrofit2.Callback<ResponseApplyCodeDto> {
                override fun onResponse(
                    call: Call<ResponseApplyCodeDto>,
                    response: Response<ResponseApplyCodeDto>,
                ) {
                    if (response.isSuccessful) {
                        val data: ResponseApplyCodeDto = response.body()!!
                        if (response.code() == 400) {
                            context!!.showToast("이미 이용 완료된 주문입니다.")
                        } else if (response.code() == 404) {
                            context!!.showToast("일치하는 주문 내역 정보가 없습니다.")
                        } else if (response.code() == 500) {
                            context!!.showToast("서버 에러 발생")
                        } else {
                            context!!.showToast("변경이 완료되었습니다.")
                            setReservationList()
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseApplyCodeDto>, t: Throwable) {
                    context!!.showToast("네트워크 에러 발생")
                }
            })
    }
}
