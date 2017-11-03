package cn.edu.sysu.mathzh.mathzhsua

/**
 * Created by nouzan on 17-10-28.
 */
data class SuaListResult(val res: String, val msg: SuaListMsg)
data class SuaListMsg(val sua_list: List<SuaModel>)
data class SuaModel(val model: String, val pk: Int, val fields: SuaFields)
data class SuaFields(val student: Int, val group: Int, val title: String,
                     val team: String, val date: String, val suahours: Float,
                     val last_time_suahours: Float, val is_valid: Boolean)