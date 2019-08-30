package com.example.myapplication;


import android.widget.SeekBar;

public class DrawPageContract {

    public interface View{
        void setDrawColor(int color);
        void setDrawStrokeWidth(int width);
    }

    public interface Presenter{
        void onColorClickListener(android.view.View view);
        void onStrokeWidthChanged(SeekBar seekBar, int progress, boolean fromUser);
    }
}
