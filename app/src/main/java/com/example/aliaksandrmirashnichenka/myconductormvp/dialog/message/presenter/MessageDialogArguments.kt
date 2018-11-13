package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.presenter.DialogArguments
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import java.io.Serializable

class MessageDialogArguments(parrentTag: String) : DialogArguments(parrentTag), Serializable {

    var value: String = "";

}