package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDrawPageBinding;

public class DrawPageActivity extends AppCompatActivity implements DrawPageContract.View{

    private ActivityDrawPageBinding binding;
    private PbrushView pbrushView;
    private DrawPageContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_draw_page);

        presenter = new DrawPagePresenter(this);
        binding.setPresenter(presenter);

        pbrushView =  new PbrushView(this);
        binding.DrawingFrame.addView(pbrushView);
    }

    @Override
    public void setDrawColor(int color) {
        pbrushView.changeColor(color);
    }

    @Override
    public void setDrawStrokeWidth(int width) {
        pbrushView.changeStrokeWidth(width);
    }
}