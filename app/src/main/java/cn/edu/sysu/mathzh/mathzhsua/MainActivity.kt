package cn.edu.sysu.mathzh.mathzhsua

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import cn.edu.sysu.mathzh.mathzhsua.domain.RequestSuaListCommand
import com.ohmerhe.kolley.request.Http

import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.appcompat.v7.coroutines.*
import org.jetbrains.anko.design.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val TOOLBAR = 0x1001
        val SUA_LIST = 0x1002
        coordinatorLayout {
            fitsSystemWindows = true
            themedAppBarLayout(theme = R.style.AppTheme_AppBarOverlay) {
                themedToolbar(theme = R.style.ThemeOverlay_AppCompat_ActionBar) {
                    popupTheme = R.style.AppTheme_PopupOverlay
                    id = TOOLBAR
                    title = "我的公益时记录"
                    //setTitleTextColor(Color.WHITE)
                    setBackgroundColor(R.attr.colorPrimary)

                }.lparams(width = matchParent, height = dip(56)) {
                    scrollFlags = 0
                }
            }.lparams(width = matchParent, height = wrapContent)
            frameLayout {
                recyclerView {
                    id = SUA_LIST
                }.lparams(width = matchParent, height = matchParent)
            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
        }


        val suaList: RecyclerView = find(SUA_LIST)
        val toolbar: Toolbar = find(TOOLBAR)
        setSupportActionBar(toolbar)
        suaList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestSuaListCommand("2").execute()
            println(result)
            uiThread {
                suaList.adapter = SuaListAdapter(result) { toast(it.date) }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_settings) {
            toast("Click!!")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
