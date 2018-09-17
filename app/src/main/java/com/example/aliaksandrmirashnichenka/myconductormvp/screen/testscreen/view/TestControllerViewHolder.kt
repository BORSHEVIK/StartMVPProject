package com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.ViewHolder

class TestControllerViewHolder : ViewHolder {

    val messageTextView: TextView;

    constructor(view: View) : super(view) {
        messageTextView = view.findViewById(R.id.message);
    }

}