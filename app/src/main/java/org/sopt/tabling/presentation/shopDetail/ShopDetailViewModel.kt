package org.sopt.tabling.presentation.shopDetail

import androidx.lifecycle.ViewModel
import org.sopt.tabling.domain.model.Menu
import org.sopt.tabling.domain.model.MenuInfo
import org.sopt.tabling.domain.model.Review
import org.sopt.tabling.domain.model.ShopDetail

class ShopDetailViewModel : ViewModel() {
    val mockShopDetailInfo = ShopDetail(
        shopId = 1,
        detailPhotoList = listOf(
            "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/8107a0a7-7e46-405a-b318-29d4e4289544",
            "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/af818e20-c2e0-43da-8415-4e2f012f6a2d",
            "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/78992b33-00a6-4ae4-bf94-f90bd7ddc325",
            "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/8107a0a7-7e46-405a-b318-29d4e4289544",
            "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/af818e20-c2e0-43da-8415-4e2f012f6a2d",
            "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/78992b33-00a6-4ae4-bf94-f90bd7ddc325"
        ),
        currentWaiting = 11,
        name = "파이브가이즈 여의도",
        longAddress = "서울 영등포구 여의대로 108 (여의도동, 파크원) 더현대서울 B1",
        salesTime = "오늘 10:30 ~ 20:00",
        waitingTime = "오늘 10:30 ~ 20:00",
        restTime = "-",
        restDay = "매주 화요일",
        phoneNumber = "020000000000",
        hashTagList = listOf(
            "깔끔한",
            "데이트하기 좋은",
            "친구랑 같이 가기 좋은",
            "양식",
            "버거",
            "홈테이블"
        ),
        introduceContent = "파이브 가이즈 한국상륙!!!",
        menuList = listOf(
            Menu(
                menuCategory = "BURGERS",
                menuInfoList = listOf(
                    MenuInfo(
                        menuId = 1,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "햄버거",
                        price = 13400
                    ),
                    MenuInfo(
                        menuId = 2,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "치즈버거",
                        price = 14900
                    ),
                    MenuInfo(
                        menuId = 3,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "베이컨 버거",
                        price = 15900
                    )
                )
            ),
            Menu(
                menuCategory = "DOGS",
                menuInfoList = listOf(
                    MenuInfo(
                        menuId = 4,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "비프 핫도그",
                        price = 13400
                    ),
                    MenuInfo(
                        menuId = 5,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "치즈 핫도그",
                        price = 14900
                    ),
                    MenuInfo(
                        menuId = 6,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "베이컨 핫도그",
                        price = 15900
                    )
                )
            ),
            Menu(
                menuCategory = "SANDWICHES",
                menuInfoList = listOf(
                    MenuInfo(
                        menuId = 7,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "베지 샌드위치",
                        price = 13400
                    ),
                    MenuInfo(
                        menuId = 8,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "치즈 베지 샌드위치",
                        price = 14900
                    ),
                    MenuInfo(
                        menuId = 9,
                        menuPhotoUrl = "https://github.com/DOSOPT-CDS-TABLING/Tabling-Android/assets/103172971/3e52988b-a95f-4270-badb-b7eef861738f",
                        menuName = "그릴드 치즈 샌드위치",
                        price = 15900
                    )
                )
            )
        ),
        averageStar = 3.0F,
        reviewCount = 64,
        detailStarList = listOf(3.8F, 3.1F, 3.7F, 3.5F),
        reviewList = listOf(
            Review(
                reviewId = 1,
                star = 2.0F,
                reviewerName = "동동섭",
                dayBefore = 1,
                reviewContent = "매장이 협소해서 편하게 식사할 수 없다는 점만 빼면 좋았어요."
            ),
            Review(
                reviewId = 2,
                star = 2.0F,
                reviewerName = "아라고",
                dayBefore = 2,
                reviewContent = "매장이 협소해서 편하게 식사할 수 없다는 점만 빼면 좋았어요."
            ),
            Review(
                reviewId = 3,
                star = 2.0F,
                reviewerName = "배쪽이",
                dayBefore = 2,
                reviewContent = "매장이 협소해서 편하게 식사할 수 없다는 점만 빼면 좋았어요."
            ),
            Review(
                reviewId = 4,
                star = 2.0F,
                reviewerName = "존잘승환",
                dayBefore = 3,
                reviewContent = "매장이 협소해서 편하게 식사할 수 없다는 점만 빼면 좋았어요."
            ),
            Review(
                reviewId = 5,
                star = 2.0F,
                reviewerName = "산타민우",
                dayBefore = 3,
                reviewContent = "매장이 협소해서 편하게 식사할 수 없다는 점만 빼면 좋았어요."
            ),
        )
    )
}
