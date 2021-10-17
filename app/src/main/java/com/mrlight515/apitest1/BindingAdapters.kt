package com.mrlight515.apitest1

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mrlight515.apitest.ui.UserApiStatus
import com.mrlight515.apitest1.network.UserCard
import com.mrlight515.apitest1.ui.UserAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView,imgUrl:String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imgUri){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

/*@BindingAdapter("userName")
fun bindUserName(textView: TextView,textName:String?){
    textView.text = users
}*/

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<UserCard>?
) {
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(
    statusImageView: ImageView,
    status: UserApiStatus?
) {
    when (status) {
        UserApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        UserApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        UserApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}