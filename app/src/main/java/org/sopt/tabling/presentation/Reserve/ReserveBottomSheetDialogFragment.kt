package org.sopt.tabling.presentation.reserve

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.tabling.R
import org.sopt.tabling.databinding.DialogBottomReserveBinding
import org.sopt.tabling.domain.model.Reserve
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.util.UiState
import org.sopt.tabling.util.binding.BindingBottomSheetDialogFragment

class ReserveBottomSheetDialogFragment(
    private val shopId: Long,
    private val onReserveResponseSuccess: (Reserve) -> Unit
) : BindingBottomSheetDialogFragment<DialogBottomReserveBinding>(
    R.layout.dialog_bottom_reserve
) {
    private val reserveViewModel: ReserveViewModel by viewModels { ViewModelFactory() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reserveViewModel = reserveViewModel

        initLayout()
        addListeners()
        collectData()
    }

    private fun initLayout() {
        with(binding) {
            tvReservePersonCount.text = PERSON_INIT_VALUE.toString()

            reserveViewModel?.let { reserveViewModel ->
                ivReserveMinus.setOnClickListener {
                    if (reserveViewModel.getPersonCountAsInt() > 0) {
                        reserveViewModel.personCount.value =
                            (reserveViewModel.getPersonCountAsInt() - 1).toString()
                    }
                }

                ivReservePlus.setOnClickListener {
                    reserveViewModel.personCount.value =
                        (reserveViewModel.getPersonCountAsInt() + 1).toString()
                }
            }
        }
    }

    private fun addListeners() {
        binding.btnReserveApply.setOnClickListener {
            reserveViewModel.postReserve(shopId)
        }

        binding.ivReserveExit.setOnClickListener {
            dismiss()
        }
    }

    private fun collectData() {
        reserveViewModel.personCount.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                binding.ivReserveMinus.setImageResource(
                    if (reserveViewModel.personCount.value == PERSON_INIT_VALUE.toString()) {
                        R.drawable.ic_minus_gray_100_24
                    } else {
                        R.drawable.ic_minus_black_24
                    }
                )
            }.launchIn(lifecycleScope)

        reserveViewModel.postReserveState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { uiState ->
                when (uiState) {
                    is UiState.Success -> {
                        uiState.data?.let {
                            onReserveResponseSuccess(it)
                            dismiss()
                        }
                    }

                    else -> Unit
                }
            }.launchIn(lifecycleScope)
    }

    companion object {
        const val PERSON_INIT_VALUE = 0
    }
}
