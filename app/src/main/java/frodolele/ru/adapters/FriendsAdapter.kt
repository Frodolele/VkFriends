package frodolele.ru.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import frodolele.ru.R
import frodolele.ru.models.VKUser
import kotlinx.android.synthetic.main.cell_friend.view.*


class FriendsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mSourceList: ArrayList<VKUser> = ArrayList()
    private var mFriendsList: ArrayList<VKUser> = ArrayList()

    fun setupFriends(friendsList: List<VKUser>) {
        mSourceList.clear()
        mSourceList.addAll(friendsList)
        filter(query = "")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false)

        return ViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendsList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(friend = mFriendsList[position])
        }
    }

    fun filter(query: String){
        mFriendsList.clear()
        mSourceList.forEach{
            if (it.firstName.contains(query) || it.lastName.contains(query)) {
                mFriendsList.add(it)
            } else {
//                it.city?.let {city ->
//                    if (city.contains(query, ignoreCase = true)) {
//                        mFriendsList.add(it)
//                    }
//                }
            }
        }
        notifyDataSetChanged()
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(friend: VKUser){
            itemView.apply{
                // Load avatar
                friend.photo?.let {url -> Picasso.get().load(url).into(friend_civ)}

                // Load name (firstName + lastName)
                friend_txt_username.text = "${friend.firstName} ${friend.lastName} "
                // Load defaultCity (may be make in future)
                friend_txt_city.text = "Default"

                // Load online status
                if (friend.isOnline == 1) {
                    friend_txt_online.visibility = View.VISIBLE
                } else {
                    friend_txt_online.visibility = View.GONE
                }
            }
        }
    }
}