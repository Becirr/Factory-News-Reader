package com.factorynewsreader.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.factorynewsreader.R
import com.google.gson.Gson

/**
 * Helper function to parse model to string & string to Model
 */
inline fun <reified T : Any> T.json(): String = Gson().toJson(this, T::class.java)
inline fun <reified T : Any> String.fromJson(): T = Gson().fromJson(this, T::class.java)

fun showErrorDialog(context: Context, onDismiss: () -> Unit) {
    val dialog: AlertDialog = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        .setTitle(context.getString(R.string.error))
        .setMessage(context.getString(R.string.ups_error))
        .setPositiveButton(context.getString(R.string.ok)) { dialogInterface, i ->
            when (i) {
                DialogInterface.BUTTON_POSITIVE -> {
                    dialogInterface.dismiss()
                }
            }
        }
        .setOnDismissListener { onDismiss() }
        .create()
    dialog.setCanceledOnTouchOutside(true)
    dialog.setOnShowListener {
        dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            .setTextColor(context.getColor(R.color.accent_color))
    }
    dialog.show()
}