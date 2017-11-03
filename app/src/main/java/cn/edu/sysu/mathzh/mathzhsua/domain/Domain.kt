package cn.edu.sysu.mathzh.mathzhsua.domain

import cn.edu.sysu.mathzh.mathzhsua.SuaListResult
import cn.edu.sysu.mathzh.mathzhsua.SuaModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by nouzan on 17-10-28.
 */
public interface Command<T> {
    fun execute(): T?
}

public class SuaListDataMapper {
    fun convertFromDataModel(suaListResult: SuaListResult): SuaList {
        val suaList = convertSuaListToDomain(suaListResult.msg.sua_list)
        return if (suaList.isNotEmpty())
                    SuaList(suaListResult.msg.sua_list[0].fields.student,
                            suaList)
        else
            SuaList(null, suaList)
    }
    private fun convertSuaListToDomain(list: List<SuaModel>): List<Sua> {
        return list.map { convertSuaItemToDomain(it) }
    }
    private fun convertSuaItemToDomain(sua: SuaModel): Sua {
        return Sua(sua.pk, sua.fields.group, sua.fields.title, sua.fields.team,
                convertDate(sua.fields.date), sua.fields.suahours)
    }
    private fun convertDate(date: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val really_date = sdf.parse(date)
        val df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault())
        return df.format(really_date)
    }
}