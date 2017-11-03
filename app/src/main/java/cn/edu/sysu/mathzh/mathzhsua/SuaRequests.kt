package cn.edu.sysu.mathzh.mathzhsua

import com.google.gson.Gson
import java.lang.Math.random
import java.net.URL
import java.security.MessageDigest

/**
 * Created by nouzan on 17-10-28.
 */
public class SuaListRequest(val studentID: String) {
    companion object {
        private val TOKEN = "HDJIIhyuujh?=jsjhxu[gd8782uhjxh?uxidi8uggui"
        private val MAIN_URL = "http://172.16.19.130:8000/student/"
        private val ARG_URL = "/sualist?"
    }

    fun execute(): SuaListResult {
        val suaListJsonStr = URL(getURL()).readText()
        return Gson().fromJson(suaListJsonStr, SuaListResult::class.java)
    }

    private fun getURL(): String {
        val nonce: String = (random() * Int.MAX_VALUE).toInt().toString()
        val timestamp: String = System.currentTimeMillis().toString()
        val finalStr = nonce + timestamp + TOKEN
        val signature = strSHA1(nonce + timestamp + TOKEN)
        return MAIN_URL + studentID + ARG_URL + "nonce=$nonce&timestamp=$timestamp&signature=$signature"
    }

    private fun strSHA1(str: String): String {
        val m: MessageDigest = MessageDigest.getInstance("SHA1")
        val digest: ByteArray = m.digest(str.toByteArray())
        var sb: StringBuffer = StringBuffer()
        for (b in digest) {
            var i: Int = b.toInt() and 0xff
            var hexString = Integer.toHexString(i)
            if (hexString.length < 2) {
                hexString = "0" + hexString
            }
            sb.append(hexString)
        }
        return sb.toString()
    }
}