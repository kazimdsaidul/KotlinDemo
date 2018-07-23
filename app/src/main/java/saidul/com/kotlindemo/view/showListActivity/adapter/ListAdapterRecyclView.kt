package saidul.com.kotlindemo.view.showListActivity.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.animal_list_item.*
import saidul.com.kotlindemo.R
import saidul.com.kotlindemo.model.Datum


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/23/18.
 */
class ListAdapterRecyclView(val data: Array<Datum>, val context: Context) : RecyclerView.Adapter<ListAdapterRecyclView.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myViewHolder = MyViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item, parent, false));
        return myViewHolder
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holderMy: ListAdapterRecyclView.MyViewHolder, position: Int) {
        holderMy.tv_animal_type?.text = data.get(position).id.toString()

        val uri = Uri.parse(data.get(position).thumbnailUrl);
        holderMy.my_image_view.setImageURI(uri)


        holderMy.editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                val tempObject = data.get(position);
                data.set(position, tempObject);
            }

            override fun afterTextChanged(s: Editable?) {
                val data = data.get(position);

            }
        })


    }

    inner class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer


}


