package br.com.urbainski.android.compose.example.util

import com.google.gson.Gson

object JsonUtils {

    private var gson: Gson = Gson();

    fun toJson(param: Any): String {
        return gson.toJson(param)
    }

    fun <T> fromJson(json: String, classOfT: Class<T>): T {
        return gson.fromJson(json, classOfT)
    }

}
