package code.kotlin.example.com.sampleapp.controller

import android.content.Context
import code.kotlin.example.com.sampleapp.epoxy_model.MainModelWithHolder_
import code.kotlin.example.com.sampleapp.model.ContactModel
import com.airbnb.epoxy.TypedEpoxyController


class MainController(var context: Context) : TypedEpoxyController<List<ContactModel>>() {

    override fun buildModels(contacts: List<ContactModel>) {
        for (contact in contacts) {
            MainModelWithHolder_()
                .id(contact.id)
                .context(context)
                .title(contact.name)
                .imageUrl(contact.imageUrl)
                .addTo(this)
        }
    }
}