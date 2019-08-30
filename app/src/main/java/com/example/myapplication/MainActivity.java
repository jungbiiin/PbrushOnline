package com.example.myapplication;

        import android.content.Intent;
        import android.databinding.DataBindingUtil;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Intent intent = new Intent(this, DrawPageActivity.class);
        startActivity(intent);
    }
}
