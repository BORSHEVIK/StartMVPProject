package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.ViewHolder


class MyControlleViewHolder : ViewHolder {

    val messageTextView: TextView;
    val updateButton: Button;

    constructor(view: View) : super(view) {
        messageTextView = view.findViewById(R.id.message);
        updateButton = view.findViewById(R.id.button);
    }


}