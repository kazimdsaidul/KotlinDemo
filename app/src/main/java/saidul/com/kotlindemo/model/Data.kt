package saidul.com.kotlindemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/23/18.
 */
class Datum {

    @SerializedName("albumId")
    @Expose
    var albumId: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("thumbnailUrl")
    @Expose
    var thumbnailUrl: String? = null



    @Expose
    var inputText: String? = null


}

class Data{
    var data = listOf<Datum>()
}
