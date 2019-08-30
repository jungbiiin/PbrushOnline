package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.SeekBar

class DrawPagePresenter(var view : DrawPageContract.View) : DrawPageContract.Presenter {

    override fun onStrokeWidthChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        this.view.setDrawStrokeWidth(progress)
    }

    override fun onColorClickListener(view: View) {
        (view.background as? ColorDrawable)?.let{
            this.view.setDrawColor(it.color)
        }
    }
}