package frodolele.ru.presenters

import android.os.Handler
import frodolele.ru.views.GeneralView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class GeneralPresenter: MvpPresenter<GeneralView>() {

    fun login(isSuccess: Boolean){
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess){
                viewState.openFriends()
            } else {
                viewState.showError("Login data is incorrect")
            }
        }, 500)
    }
}