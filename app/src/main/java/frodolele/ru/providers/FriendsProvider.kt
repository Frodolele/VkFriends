package frodolele.ru.providers

import android.os.Handler
import frodolele.ru.models.FriendModel
import frodolele.ru.presenters.FriendsPresenter

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriends(hasFriends: Boolean){
        Handler().postDelayed({
            val friendsList: ArrayList<FriendModel> = ArrayList()
            if (hasFriends) {
                val friend1 = FriendModel(name = "Ivan", surname = "Petrov", city = "Muhosransk", avatar = null, isOnline = false)
                val friend2 = FriendModel(name = "Ivan", surname = "Petrov", city = "Muhosransk", avatar = null, isOnline = true)
                val friend3 = FriendModel(name = "Arabian", surname = "King", city = "AOE", avatar = null, isOnline = false)

                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
            }

            presenter.friendsLoaded(friendList = friendsList)
        }, 500)
    }
}