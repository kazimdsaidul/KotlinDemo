package saidul.com.kotlindemo.view.showListActivity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.google.gson.Gson
import kotlinx.android.synthetic.main.content_show_list.*
import saidul.com.kotlindemo.R
import saidul.com.kotlindemo.base.BaseAppCompatActivity
import saidul.com.kotlindemo.model.Datum
import saidul.com.kotlindemo.view.showListActivity.adapter.ListAdapterRecyclView


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
        // Creates a vertical Layout Manager
        rv.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)
        // Access the RecyclerView Adapter and load the data into it
        rv.adapter = ListAdapterRecyclView(data = fromJson, context = applicationContext);

    }


}
