package org.sopt.tabling.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.tabling.BuildConfig
import org.sopt.tabling.data.service.ApplyCodeService
import org.sopt.tabling.data.service.PopularStoreService
import org.sopt.tabling.data.service.ReservationListService
import org.sopt.tabling.data.service.ReserveService
import org.sopt.tabling.data.service.ShopDetailService
import org.sopt.tabling.data.service.WaitingDetailService
import retrofit2.Retrofit

object ApiFactory {
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            },
        ).build()
    }
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val reservationListService = ApiFactory.create<ReservationListService>()
    val applyCodeService = ApiFactory.create<ApplyCodeService>()
    val waitingDetailService = ApiFactory.create<WaitingDetailService>()
    val shopDetailService = ApiFactory.create<ShopDetailService>()
    val popularStoreService = ApiFactory.create<PopularStoreService>()
    val reserveService = ApiFactory.create<ReserveService>()
}
