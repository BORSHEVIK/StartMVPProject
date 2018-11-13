package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.ViewHolder


class MainControllerViewHolder : ViewHolder {

    val messageTextView: TextView;
    val updateButton: Button;
    val nextButton: Button;
    val showDialog: Button;

    constructor(view: View) : super(view) {
        messageTextView = view.findViewById(R.id.message);
        updateButton = view.findViewById(R.id.button);
        nextButton = view.findViewById(R.id.next);
        showDialog = view.findViewById(R.id.showDialog);
    }


}