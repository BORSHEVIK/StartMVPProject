package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.view

import android.view.View
import android.widget.TextView
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.ViewHolder

class MessageDialogViewHolder : ViewHolder {

    val messageTextView: TextView;
    val okButton: TextView;

    constructor(view: View) : super(view) {
        messageTextView = view.findViewById(R.id.message);
        okButton = view.findViewById(R.id.button);
    }

}