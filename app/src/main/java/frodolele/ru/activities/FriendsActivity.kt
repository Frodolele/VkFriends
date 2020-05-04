package frodolele.ru.activities


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import frodolele.ru.R
import frodolele.ru.adapters.FriendsAdapter
import frodolele.ru.models.VKUser
import frodolele.ru.presenters.FriendsPresenter
import frodolele.ru.views.FriendsView
import kotlinx.android.synthetic.main.activity_friends.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    private lateinit var mAdapter: FriendsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        friendsPresenter.loadFriends()

        mAdapter = FriendsAdapter()

        txt_friends_search.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mAdapter.filter(s.toString())
            }

        })

        recycler_friends.adapter = mAdapter
        recycler_friends.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        recycler_friends.setHasFixedSize(true)
    }

    override fun showError(textResource: Int) {
        txt_friends_no_items.text = getString(textResource)
    }

    override fun setupEmptyList() {
        recycler_friends.visibility = View.GONE
        txt_friends_no_items.visibility = View.VISIBLE
    }

    override fun setupFriendsList(friendList: List<VKUser>) {
        recycler_friends.visibility = View.VISIBLE
        txt_friends_no_items.visibility = View.GONE

        mAdapter.setupFriends(friendsList = friendList)
    }

    override fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            recycler_friends.visibility = View.GONE
            txt_friends_no_items.visibility = View.GONE
            cpv_friends.visibility = View.VISIBLE
        } else {
            cpv_friends.visibility = View.GONE
        }
    }
}
