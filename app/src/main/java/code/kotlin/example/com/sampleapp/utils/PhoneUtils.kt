package code.kotlin.example.com.sampleapp.utils

import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import code.kotlin.example.com.sampleapp.model.ContactModel


class PhoneUtils {

    companion object {
        fun contactList(context: Context): List<ContactModel> {
            var contactList = arrayListOf<ContactModel>()

            val cr = context.getContentResolver()
            val cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null,
                null)

            if ((if (cur != null) cur!!.getCount() else 0) > 0) {
                while (cur != null && cur!!.moveToNext()) {
                    val id = cur!!.getString(
                        cur!!.getColumnIndex(ContactsContract.Contacts._ID)
                    )
                    val name = cur!!.getString(
                        cur!!.getColumnIndex(
                            ContactsContract.Contacts.DISPLAY_NAME
                        )
                    )

                    if (cur!!.getInt(
                            cur!!.getColumnIndex(
                                ContactsContract.Contacts.HAS_PHONE_NUMBER
                            )
                        ) > 0
                    ) {
                        val pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf<String>(id), null
                        )
                        var index = 0
                        while (pCur!!.moveToNext()) {
                            val phoneNo = pCur!!.getString(
                                pCur!!.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER
                                )
                            )
                            index++

                            contactList.add(
                                ContactModel(
                                    index,
                                    name,
                                    phoneNo,
                                    "http://icons-for-free.com/free-icons/png/512/2639075.png"
                                )
                            )
                            Log.i("jessie", "Name: $name")
                            Log.i("jessie", "Phone Number: $phoneNo")


                        }
                        pCur!!.close()
                    }
                }
            }
            if (cur != null) {
                cur!!.close()
            }

            return contactList
        }
    }
}