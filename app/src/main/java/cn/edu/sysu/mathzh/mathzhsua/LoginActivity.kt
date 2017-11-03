package cn.edu.sysu.mathzh.mathzhsua

/**
 * Created by nouzan on 17-10-29.
 */

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(30)
            editText {
                hint = "用户名"
                textSize = 24f
            }
            editText {
                hint = "密码"
                textSize = 24f
            }
            button("登录") {
                textSize = 26f
                onClick { ctx.toast("Hello, Loginer") }
            }
        }
    }
}