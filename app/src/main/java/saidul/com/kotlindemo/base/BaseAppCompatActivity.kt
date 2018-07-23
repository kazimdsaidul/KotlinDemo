package saidul.com.kotlindemo.base

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/23/18.
 */

open class BaseAppCompatActivity: AppCompatActivity(){

    companion object {
        private var progDailog: ProgressDialog? = null
        public var TAG : String = this.javaClass.simpleName;
    }

    public fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }


    fun showprogessdialog() {

        progDailog = ProgressDialog(this)

        if (progDailog != null) {
            progDailog?.setMessage("Please wait...")
            progDailog?.setCancelable(false)
            progDailog?.show()

        }
    }

    fun hiddenProgressDialog() {
        if (progDailog != null) {
            progDailog?.dismiss()
        }
    }



}