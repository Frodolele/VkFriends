package frodolele.ru.helpers

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.utils.VKUtils

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
    }
}