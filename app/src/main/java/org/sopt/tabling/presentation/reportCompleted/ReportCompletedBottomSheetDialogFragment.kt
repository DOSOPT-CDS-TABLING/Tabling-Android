package org.sopt.tabling.presentation.reportCompleted

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.tabling.R
import org.sopt.tabling.databinding.DialogBottomVisitCompletedBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.util.binding.BindingBottomSheetDialogFragment

class ReportCompletedBottomSheetDialogFragment(
    private val clickBtn: () -> Unit = {}
) : BindingBottomSheetDialogFragment<DialogBottomVisitCompletedBinding>(
    R.layout.dialog_bottom_visit_completed
) {
    private val reportCompletedViewModel: ReportCompletedViewModel by viewModels { ViewModelFactory() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reportCompletedViewModel = reportCompletedViewModel

        initLayout()
        addListeners()
        collectData()
    }

    private fun initLayout() {
        with(binding) {
            tvVisitCompletedPersonCount.text = PERSON_INIT_VALUE.toString()

            reportCompletedViewModel?.let { reportCompletedViewModel ->
                ivVisitCompletedMinus.setOnClickListener {
                    if (reportCompletedViewModel.getPersonCountAsInt() > 0) {
                        reportCompletedViewModel.personCount.value =
                            (reportCompletedViewModel.getPersonCountAsInt() - 1).toString()
                    }
                }

                ivVisitCompletedPlus.setOnClickListener {
                    reportCompletedViewModel.personCount.value =
                        (reportCompletedViewModel.getPersonCountAsInt() + 1).toString()
                }
            }
        }
    }

    private fun addListeners() {
        binding.btnVisitCompletedApply.setOnClickListener {
            clickBtn.invoke()
            dismiss()
        }

        binding.ivVisitCompletedExit.setOnClickListener {
            dismiss()
        }
    }

    private fun collectData() {
        reportCompletedViewModel.personCount.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                binding.ivVisitCompletedMinus.setImageResource(
                    if (reportCompletedViewModel.personCount.value == PERSON_INIT_VALUE.toString()) {
                        R.drawable.ic_minus_gray_100_24
                    } else {
                        R.drawable.ic_minus_black_24
                    }
                )
            }.launchIn(lifecycleScope)
    }

    companion object {
        const val PERSON_INIT_VALUE = 0
    }
}
