package frodolele.ru.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import frodolele.ru.R
import frodolele.ru.presenters.GeneralPresenter
import frodolele.ru.views.GeneralView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class GeneralActivity : MvpAppCompatActivity(), GeneralView {

    @InjectPresenter
    lateinit var generalPresenter: GeneralPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_general.setOnClickListener{
            generalPresenter.login(true)
        }

    }

    override fun startLoading() {
        btn_general.visibility = View.GONE
        cpv_general.visibility = View.VISIBLE
    }

    override fun endLoading() {
        btn_general.visibility = View.VISIBLE
        cpv_general.visibility = View.GONE
    }

    override fun showError(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }
}
