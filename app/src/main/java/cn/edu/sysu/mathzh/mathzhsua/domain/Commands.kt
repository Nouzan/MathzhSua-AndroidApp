package cn.edu.sysu.mathzh.mathzhsua.domain

import cn.edu.sysu.mathzh.mathzhsua.SuaListRequest

/**
 * Created by nouzan on 17-10-28.
 */
class RequestSuaListCommand(val studentID: String) : Command<SuaList> {
    override fun execute(): SuaList {
        val suaListRequest = SuaListRequest(studentID)
        return SuaListDataMapper().convertFromDataModel(suaListRequest.execute())
    }
}