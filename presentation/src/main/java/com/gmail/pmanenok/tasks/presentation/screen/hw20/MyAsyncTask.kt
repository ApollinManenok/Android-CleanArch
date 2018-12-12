package com.gmail.pmanenok.tasks.presentation.screen.hw20

import android.os.AsyncTask

class MyAsyncTask : AsyncTask<String, Int, Boolean>() {
    override fun onPreExecute() {
        super.onPreExecute()
        //выполняется в UI потоке
    }

    override fun doInBackground(vararg params: String?): Boolean {
        //выполняется в отдельном потоке
        val url = params[0]
        Thread.sleep(5000)
        return true
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        //выполняется в UI потоке
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
        //выполняется в UI потоке
    }

}