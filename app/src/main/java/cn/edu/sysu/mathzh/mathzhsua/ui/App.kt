package cn.edu.sysu.mathzh.mathzhsua.ui

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by nouzan on 2017/11/23.
 */
class App : Application() {
    companion object {
        private var instance: App by Delegates.notNull()
        //fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}