package cn.edu.sysu.mathzh.mathzhsua.domain

/**
 * Created by nouzan on 17-10-28.
 */
data class SuaList(val student: Int?, val suaList: List<Sua>) {
    operator fun get(position: Int): Sua = suaList[position]
    fun size(): Int = suaList.size
}
data class Sua(val pk: Int, val group: Int, val title: String, val team: String, val date: String,
               val suahours: Float)