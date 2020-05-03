package frodolele.ru.views

import frodolele.ru.models.FriendModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView: MvpView {

    fun showError(textResource: Int)
    fun setupEmptyList()
    fun setupFriendsList(friendList: ArrayList<FriendModel>)
    fun startLoading()
    fun endLoading()

}