package saidul.com.kotlindemo.view.showListActivity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.google.gson.Gson
import saidul.com.kotlindemo.R
import saidul.com.kotlindemo.base.BaseAppCompatActivity
import saidul.com.kotlindemo.model.Datum


class ShowListActivity : BaseAppCompatActivity() {

    companion object {
        var TAG: String = this.javaClass.simpleName;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        setToolbar()

        getAPICall();

    }

    private fun setDialog(show: Boolean) {
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.progress)
        val dialog = builder.create()
        if (show)
            dialog.show()
        else
            dialog.dismiss()
    }

    private fun getAPICall() {

        showprogessdialog();


        AndroidNetworking.get("https://jsonplaceholder.typicode.com/photos")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(object : StringRequestListener {
                    override fun onResponse(response: String?) {
                        Log.d(TAG, response.toString());


                        val gson = Gson()
                        val myTypes = gson.fromJson(response, Array<Datum>::class.java)

                        generateRecycleView(myTypes);

                        hiddenProgressDialog()
                    }

                    override fun onError(error: ANError) {
                        Log.d(TAG, error.toString());
                        hiddenProgressDialog();
                    }
                })


    }

    private fun generateRecycleView(fromJson: Array<Datum>) {

        Log.d(TAG, fromJson.toString());
    }


}
