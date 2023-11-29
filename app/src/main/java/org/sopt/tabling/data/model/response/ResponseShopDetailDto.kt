package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.tabling.domain.model.Menu
import org.sopt.tabling.domain.model.MenuInfo
import org.sopt.tabling.domain.model.ShopDetail

@Serializable
data class ResponseShopDetailDto(
    @SerialName("shop_id")
    val shopId: Long,
    @SerialName("detail_photo_list")
    val detailPhotoList: List<String>,
    @SerialName("current_waiting")
    val currentWaiting: Int,
    @SerialName("name")
    val name: String,
    @SerialName("long_address")
    val longAddress: String,
    @SerialName("sales_time")
    val salesTime: String,
    @SerialName("waiting_time")
    val waitingTime: String,
    @SerialName("rest_time")
    val restTime: String,
    @SerialName("rest_day")
    val restDay: String,
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("hash_tag_list")
    val hashTagList: List<String>,
    @SerialName("introduce_content")
    val introduceContent: String,
    @SerialName("menu_list")
    val menuList: List<Menu>,
    @SerialName("average_star")
    val averageStar: Float,
    @SerialName("review_count")
    val reviewCount: Int,
    @SerialName("detail_star_list")
    val detailStarList: List<Float>,
    @SerialName("review_list")
    val reviewList: List<Review>
) {
    @Serializable
    data class Menu(
        @SerialName("menu_category")
        val menuCategory: String,
        @SerialName("menu_info_list")
        val menuInfoList: List<MenuInfo>
    ) {
        @Serializable
        data class MenuInfo(
            @SerialName("menu_id")
            val menuId: Long,
            @SerialName("menu_photo_url")
            val menuPhotoUrl: String,
            @SerialName("menu_name")
            val menuName: String,
            @SerialName("price")
            val price: Int
        )
    }

    @Serializable
    data class Review(
        @SerialName("review_id")
        val reviewId: Long,
        @SerialName("star")
        val star: Float,
        @SerialName("reviewer_name")
        val reviewerName: String,
        @SerialName("day_before")
        val dayBefore: Int,
        @SerialName("review_content")
        val reviewContent: String
    )

    fun toShopDetail() = ShopDetail(
        shopId = this.shopId,
        detailPhotoList = this.detailPhotoList,
        currentWaiting = this.currentWaiting,
        name = this.name,
        longAddress = this.longAddress,
        salesTime = this.salesTime,
        waitingTime = this.waitingTime,
        restTime = this.restTime,
        restDay = this.restDay,
        phoneNumber = this.phoneNumber,
        hashTagList = this.hashTagList,
        introduceContent = this.introduceContent,
        menuList = this.menuList.map { menu ->
            Menu(
                menuCategory = menu.menuCategory,
                menuInfoList = menu.menuInfoList.map { menuInfo ->
                    MenuInfo(
                        menuId = menuInfo.menuId,
                        menuPhotoUrl = menuInfo.menuPhotoUrl,
                        menuName = menuInfo.menuName,
                        price = menuInfo.price
                    )
                }
            )
        },
        averageStar = this.averageStar,
        reviewCount = this.reviewCount,
        detailStarList = this.detailStarList,
        reviewList = this.reviewList.map { review ->
            org.sopt.tabling.domain.model.Review(
                reviewId = review.reviewId,
                star = review.star,
                reviewerName = review.reviewerName,
                dayBefore = review.dayBefore,
                reviewContent = review.reviewContent
            )
        }
    )
}
