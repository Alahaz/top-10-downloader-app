package com.ziesapp.top10downloader

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.MalformedURLException

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate Called")
        val downloadData = DownloadData()
        downloadData.execute("URL Goes here")
        Log.d(TAG,"OnCreate : Done")
    }

    companion object {
        private class DownloadData : AsyncTask<String, Void, String>() {
            private val TAG = "DownloadData"

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                Log.d(TAG, "OnPost Executed:Parameter is $result")
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "DoInBackgroun Executed: starts with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if (rssFeed.isEmpty()){
                    Log.e(TAG,"doInBackground : Error Dwonloading")
                }
            return rssFeed}
        }
    }
    private fun downloadXML(urlPath:String?):String{
        val xmlResult = StringBuilder()

        try{
            val url = URL(urlPath)
            val connection:HttpURLConnection = url.openConection() as HttpURLConnection
            val response = connection.responseCode
            Log.d(TAG, "Download XML : the response code was $response")

            val inputStream = connection.inputStream
            val inputStreamReader = InputStreamReader(inputStream)
            val reader = BufferedReader(inputStreamReader)
        } catch (e:MalformedURLException){
            Log.e(TAG,"download XML : Invalid Url ${e.message}")
        } catch (e : IOException){
            Log.e(TAG, "download XML : IOEXception reading data : ${e.message}")
        } catch (e:Exception){
            Log.e(TAG,"Unknown Error : ${e.message}")
        }
    }
}
