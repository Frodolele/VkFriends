package frodolele.ru.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import frodolele.ru.R
import frodolele.ru.models.FriendModel
import frodolele.ru.presenters.FriendsPresenter
import frodolele.ru.views.FriendsView
import kotlinx.android.synthetic.main.activity_friends.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
    }

    override fun showError(textResource: Int) {
        txt_friends_no_items.text = getString(textResource)
    }

    override fun setupEmptyList() {
        recycler_friends.visibility = View.GONE
        txt_friends_no_items.visibility = View.VISIBLE
    }

    override fun setupFriendsList(friendList: ArrayList<FriendModel>) {
        recycler_friends.visibility = View.VISIBLE
        txt_friends_no_items.visibility = View.GONE
    }
}
