package saidul.com.kotlindemo.appController

import android.app.Application
import com.androidnetworking.AndroidNetworking

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/23/18.
 */
public class AppController: Application(){

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext());

    }

}