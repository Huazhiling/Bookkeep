package com.tuita.bookkeeping.listener

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

interface IDialogInterface {
    fun initMsg(view: TextView)
    fun cancelCallback(dialog: AlertDialog)
    fun sureCallback(view: View,dialog: AlertDialog)
}