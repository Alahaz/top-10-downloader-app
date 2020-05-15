package com.ziesapp.top10downloader

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

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

            override fun doInBackground(vararg params: String?): String {
                Log.d(TAG, "DoInBackgroun Executed: starts with ${params[0]}")
            return "doInBackground completed"}
        }
    }
}
