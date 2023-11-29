package org.sopt.tabling.presentation.Reserve

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.sopt.tabling.databinding.DialogReserveBinding
import org.sopt.tabling.presentation.store.PopularStoreActivity

class ReserveDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = true
    }

    private lateinit var binding: DialogReserveBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DialogReserveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 서버통신
        var waitingNum = "86"
        binding.tvWaitingNumber.text = waitingNum

        var nowWaitingNum = "5"
        binding.tvDialogNowWaitingNumber.text = nowWaitingNum

        var shopName = "파이브가이즈 여의도"
        binding.tvDialogStoreOutput.text = shopName

        var personCount = "99"
        binding.tvDialogStoreNumberOutput.text = personCount

        var orderStatus = "확정 예정"
        binding.tvDialogStoreStatusOutput.text = orderStatus

        binding.ivIcExit24.setOnClickListener {
            dismiss()
        }

        // 버튼 클릭 시 이동
        binding.btnDialogConfirm.setOnClickListener {
            // 이용완료/예정 뷰로 이동
            val intent = Intent(activity, PopularStoreActivity::class.java)
            startActivity(intent)
        }
    }
}