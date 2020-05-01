package frodolele.ru.views


import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface GeneralView: MvpView {

    fun startLoading()
    fun endLoading()
    fun showError(text: String)
    fun openFriends()
}