package frodolele.ru.presenters


import com.vk.api.sdk.exceptions.VKApiExecutionException
import frodolele.ru.R
import frodolele.ru.models.VKUser
import frodolele.ru.providers.FriendsProvider
import frodolele.ru.views.FriendsView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FriendsPresenter: MvpPresenter<FriendsView>() {

    fun loadFriends(){
        viewState.setLoading(true)
        FriendsProvider(presenter = this).loadFriends()
    }

    fun friendsLoaded(friendList: List<VKUser>) {
        viewState.setLoading(false)
        if (friendList.isEmpty()) {
            viewState.setupEmptyList()
            viewState.showError(textResource = R.string.friends_no_items)
        } else {
            viewState.setupFriendsList(friendList = friendList)
        }
    }

    fun showError(error: VKApiExecutionException){
        viewState.showError(R.string.list_error_notification)
    }
}