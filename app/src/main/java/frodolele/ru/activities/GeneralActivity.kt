package frodolele.ru.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.utils.VKUtils
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
            VK.login(this@GeneralActivity, arrayListOf(VKScope.FRIENDS))
        }



//        val fingerprints: Array<String?>? = VKUtils.getCertificateFingerprint(this, this.packageName)
//        Log.e("TAG", "fingerprints ${fingerprints?.get(0)}")


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!generalPresenter.loginVK(requestCode = requestCode, resultCode = resultCode, data = data)) {
            super.onActivityResult(requestCode, resultCode, data)
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

    override fun showError(textResource: Int) {
        Toast.makeText(applicationContext, getString(textResource), Toast.LENGTH_SHORT).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }
}
