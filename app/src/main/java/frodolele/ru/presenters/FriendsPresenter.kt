package frodolele.ru.presenters


import frodolele.ru.R
import frodolele.ru.models.FriendModel
import frodolele.ru.providers.FriendsProvider
import frodolele.ru.views.FriendsView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FriendsPresenter: MvpPresenter<FriendsView>() {

    fun loadFriends(){
        viewState.startLoading()
        FriendsProvider(presenter = this).testLoadFriends(hasFriends = true)
    }

    fun friendsLoaded(friendList: ArrayList<FriendModel>) {
        viewState.endLoading()
        if (friendList.size == 0) {
            viewState.setupEmptyList()
            viewState.showError(textResource = R.string.friends_no_items)
        } else {
            viewState.setupFriendsList(friendList = friendList)
        }
    }
}