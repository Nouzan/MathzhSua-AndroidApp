package cn.edu.sysu.mathzh.mathzhsua.ui

import android.app.Application

/**
 * Created by nouzan on 2017/11/23.
 */
class App : Application() {
    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}