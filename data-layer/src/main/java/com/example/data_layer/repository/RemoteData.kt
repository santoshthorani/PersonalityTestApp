package com.example.data_layer.repository

import android.content.Context
import android.util.Log
import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val gson: Gson,
    private val context: Context
) : RemoteDataSource {
    override suspend fun getTestQuestions(): Resource<List<Question>> {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("questions.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            Log.d("RemoteData", "IOException: $ioException")
            return Resource.DataError(ioException)
        }
        val listQuestionType = object : TypeToken<List<Question>>() {}.type
        return Resource.Success(gson.fromJson(jsonString, listQuestionType))
    }

}