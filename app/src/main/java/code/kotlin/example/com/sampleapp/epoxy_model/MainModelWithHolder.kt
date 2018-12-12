package code.kotlin.example.com.sampleapp.epoxy_model

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import code.kotlin.example.com.sampleapp.R
import code.kotlin.example.com.sampleapp.module.GlideApp
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_main_details.view.*

@EpoxyModelClass(layout = R.layout.item_main_details)
abstract class MainModelWithHolder : EpoxyModelWithHolder<MainModelWithHolder.Holder>() {

    @EpoxyAttribute
    lateinit var phoneNumber: String

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var imageUrl: String

    @EpoxyAttribute
    lateinit var context: Context

    override fun bind(holder: Holder) {
        holder.titleView.text = title
        holder.phoneNumber.text = phoneNumber
        GlideApp.with(context)
            .load(imageUrl)
            .into(holder.imageView)
    }


    class Holder : EpoxyHolder() {
        lateinit var imageView: ImageView
        lateinit var titleView: TextView
        lateinit var phoneNumber: TextView

        override fun bindView(itemView: View) {
            itemView?.let {
                imageView = it.image
                titleView = it.title
                phoneNumber = it.phone_number
            }
        }
    }
}