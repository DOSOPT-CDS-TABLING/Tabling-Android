package org.sopt.tabling.presentation.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.tabling.data.model.response.ResponsePopularStoreDto

class StoreViewModel : ViewModel() {
    private val _popularStoreList = MutableLiveData<List<ResponsePopularStoreDto.StoreData>>()
    val popularStoreList = _popularStoreList

    fun setDummyList() {
        _popularStoreList.value = listOf(
            ResponsePopularStoreDto.StoreData(
                1,
                "파이브가이즈 여의도",
                3.0,
                64,
                "양식",
                "여의도동",
                4753,
                14,
                "https://github-production-user-asset-6210df.s3.amazonaws.com/67463603/284251896-4d2f58ad-11c6-466a-828a-bd4290e064e9.png"
            ),
            ResponsePopularStoreDto.StoreData(
                2,
                "파이브가이즈 여의도",
                3.0,
                64,
                "양식",
                "여의도동",
                4753,
                14,
                "https://github-production-user-asset-6210df.s3.amazonaws.com/67463603/284251896-4d2f58ad-11c6-466a-828a-bd4290e064e9.png"
            ),
            ResponsePopularStoreDto.StoreData(
                3,
                "청화옥 방이점",
                2.0,
                300,
                "양식",
                "방이동",
                1083,
                0,
                "https://github-production-user-asset-6210df.s3.amazonaws.com/67463603/284251896-4d2f58ad-11c6-466a-828a-bd4290e064e9.png"
            ),
            ResponsePopularStoreDto.StoreData(
                4,
                "청화옥 사당직영점",
                5.0,
                300,
                "양식",
                "사당동",
                852,
                0,
                "https://github-production-user-asset-6210df.s3.amazonaws.com/67463603/284251896-4d2f58ad-11c6-466a-828a-bd4290e064e9.png"
            ),

            ResponsePopularStoreDto.StoreData(
                5,
                "청화옥 양재점",
                4.0,
                300,
                "양식",
                "양재동",
                773,
                1,
                "https://github-production-user-asset-6210df.s3.amazonaws.com/67463603/284251896-4d2f58ad-11c6-466a-828a-bd4290e064e9.png"
            ),
            ResponsePopularStoreDto.StoreData(
                6,
                "아라네 부대찌개 여의도점",
                3.0,
                300,
                "양식",
                "여의도동",
                631,
                0,
                "https://github-production-user-asset-6210df.s3.amazonaws.com/67463603/284251896-4d2f58ad-11c6-466a-828a-bd4290e064e9.png"
            ),
        )
    }
}