package org.sopt.tabling.presentation.reserve

import android.content.Intent
import android.os.Bundle
import android.view.View
import org.sopt.tabling.R
import org.sopt.tabling.databinding.DialogReserveBinding
import org.sopt.tabling.domain.model.Reserve
import org.sopt.tabling.presentation.store.PopularStoreActivity
import org.sopt.tabling.util.binding.BindingDialogFragment

class ReserveDialog(
    private val reserve: Reserve
) : BindingDialogFragment<DialogReserveBinding>(R.layout.dialog_reserve) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        with(binding) {
            tvWaitingNumber.text = reserve.waitingNumber.toString()
            tvDialogNowWaitingNumber.text = reserve.beforeCount.toString()
            tvDialogStoreOutput.text = reserve.shopName
            tvDialogStoreNumberOutput.text = reserve.personCount.toString()
            tvDialogStoreStatusOutput.text = reserve.orderStatus
        }
    }

    private fun addListeners() {
        binding.btnDialogConfirm.setOnClickListener {
            startActivity(Intent(requireContext(), PopularStoreActivity::class.java))
        }
    }
}
