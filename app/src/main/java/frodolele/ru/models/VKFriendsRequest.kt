package frodolele.ru.models

import com.vk.api.sdk.VK
import com.vk.api.sdk.requests.VKRequest
import com.vk.api.sdk.utils.VKUtils
import org.json.JSONObject

class VKFriendsRequest(uid: Int = 0) : VKRequest<List<VKUser>>("friends.get") {

    init{
        if (uid != 0) {
            addParam("user_id", uid)
        }
        addParam("lang", 0)
        addParam("fields", "photo_100")
    }

    override fun parse(r: JSONObject): List<VKUser> {
        val users = r.getJSONObject("response").getJSONArray("items")
        val result = ArrayList<VKUser>()
        for (i in 0 until users.length()) {
            result.add(VKUser.parse(users.getJSONObject(i)))
        }

        return result
    }
}