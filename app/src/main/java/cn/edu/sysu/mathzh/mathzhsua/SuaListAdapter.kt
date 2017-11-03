package cn.edu.sysu.mathzh.mathzhsua

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.edu.sysu.mathzh.mathzhsua.domain.Sua
import cn.edu.sysu.mathzh.mathzhsua.domain.SuaList
import org.jetbrains.anko.find

/**
 * Created by nouzan on 17-10-28.
 */
public class SuaListAdapter(val suaList: SuaList, val itemClick: (Sua) -> Unit):
        RecyclerView.Adapter<SuaListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.ctx)
                .inflate(R.layout.item_sua, parent, false)
        return ViewHolder(view, itemClick)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(suaList[position]){
            holder.bindSua(suaList[position])
        }
    }
    override fun getItemCount(): Int = suaList.size()

    class ViewHolder(view: View, val itemClick: (Sua) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val dateView: TextView
        private val titleView: TextView
        private val suahoursView: TextView
        private val teamView: TextView

        init {
            dateView = view.find(R.id.date)
            titleView = view.find(R.id.title)
            suahoursView = view.find(R.id.suahours)
            teamView = view.find(R.id.team)
        }

        fun bindSua(sua: Sua) {
            with(sua) {
                dateView.text = date
                titleView.text = title
                suahoursView.text = "$suahours h"
                teamView.text = team
                itemView.setOnClickListener{ itemClick(sua) }
            }
        }
    }

}