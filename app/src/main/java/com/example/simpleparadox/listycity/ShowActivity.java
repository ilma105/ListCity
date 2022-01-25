package com.example.simpleparadox.listycity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
public class ShowActivity extends AppCompatActivity {
    TextView textview;
    Button btn;
    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showactivity);
        textview = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();

        textview.setText(bundle.getString("cityname"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowActivity.this.finish();
            }
        });

    }
}
