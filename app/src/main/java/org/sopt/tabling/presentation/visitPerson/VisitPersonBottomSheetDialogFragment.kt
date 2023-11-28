package org.sopt.tabling.presentation.visitPerson

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.tabling.R
import org.sopt.tabling.databinding.DialogBottomVisitPersonBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.util.binding.BindingBottomSheetDialogFragment

class VisitPersonBottomSheetDialogFragment(
    private val clickBtn: () -> Unit = {}
) : BindingBottomSheetDialogFragment<DialogBottomVisitPersonBinding>(
    R.layout.dialog_bottom_visit_person
) {
    private val reportCompletedViewModel: VisitPersonViewModel by viewModels { ViewModelFactory() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.visitPersonViewModel = reportCompletedViewModel

        initLayout()
        addListeners()
        collectData()
    }

    private fun initLayout() {
        with(binding) {
            tvVisitPersonPersonCount.text = PERSON_INIT_VALUE.toString()

            reportCompletedViewModel?.let { reportCompletedViewModel ->
                ivVisitPersonMinus.setOnClickListener {
                    if (reportCompletedViewModel.getPersonCountAsInt() > 0) {
                        reportCompletedViewModel.personCount.value =
                            (reportCompletedViewModel.getPersonCountAsInt() - 1).toString()
                    }
                }

                ivVisitPersonPlus.setOnClickListener {
                    reportCompletedViewModel.personCount.value =
                        (reportCompletedViewModel.getPersonCountAsInt() + 1).toString()
                }
            }
        }
    }

    private fun addListeners() {
        binding.btnVisitPersonApply.setOnClickListener {
            clickBtn.invoke()
            dismiss()
        }

        binding.ivVisitPersonExit.setOnClickListener {
            dismiss()
        }
    }

    private fun collectData() {
        reportCompletedViewModel.personCount.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                binding.ivVisitPersonMinus.setImageResource(
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
