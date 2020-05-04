package frodolele.ru.providers

import android.os.Handler
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException
import frodolele.ru.R
import frodolele.ru.models.VKFriendsRequest
import frodolele.ru.models.VKUser
import frodolele.ru.presenters.FriendsPresenter

class FriendsProvider(var presenter: FriendsPresenter) {
//    fun testLoadFriends(hasFriends: Boolean){
//        Handler().postDelayed({
//            val friendsList: ArrayList<FriendModel> = ArrayList()
//            if (hasFriends) {
//                val friend1 = FriendModel(name = "Artyom", surname = "Tkachuk", city = "Muhosransk",
//                    avatar = "https://s00.yaplakal.com/pics/pics_original/0/2/5/5511520.jpg", isOnline = false)
//                val friend2 = FriendModel(name = "Ivan", surname = "Petrov", city = "Muhosransk", avatar = null, isOnline = true)
//                val friend3 = FriendModel(name = "Arabian", surname = "King", city = null,
//                    avatar = "https://i.imgur.com/DvpvklR.png", isOnline = false)
//
//                friendsList.add(friend1)
//                friendsList.add(friend2)
//                friendsList.add(friend3)
//            }
//
//            presenter.friendsLoaded(friendList = friendsList)
//        }, 500)
//    }

    fun loadFriends() {
        VK.execute(VKFriendsRequest(), object: VKApiCallback<List<VKUser>>{
            override fun fail(error: VKApiExecutionException) {
                presenter.showError(error)
            }

            override fun success(result: List<VKUser>) {
                presenter.friendsLoaded(result)
            }

        })
    }
}