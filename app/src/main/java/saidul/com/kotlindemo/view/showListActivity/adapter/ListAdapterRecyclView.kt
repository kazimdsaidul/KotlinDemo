package saidul.com.kotlindemo.view.showListActivity.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.animal_list_item.view.*
import saidul.com.kotlindemo.R
import saidul.com.kotlindemo.model.Datum



/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/23/18.
 */
 class ListAdapterRecyclView(val data: Array<Datum>, val context: Context):RecyclerView.Adapter<ListAdapterRecyclView.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item,parent,false))
    }


    override fun getItemCount(): Int {
       return  data.size
    }

    override fun onBindViewHolder(holderMy: ListAdapterRecyclView.MyViewHolder, position: Int) {
        holderMy?.tvAnimalType?.text = data.get(position).id.toString()

        val uri = Uri.parse(data.get(position).thumbnailUrl);
        holderMy?.image.setImageURI(uri)




    }

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val tvAnimalType = view.tv_animal_type
        val image = view.my_image_view
    }

}