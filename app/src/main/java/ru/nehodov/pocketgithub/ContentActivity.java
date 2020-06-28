package ru.nehodov.pocketgithub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContentActivity extends AppCompatActivity {

    private static final String EXTRA_CONTENT = "extra_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        TextView gitContentTextView = findViewById(R.id.gitContentTextView);
        String content = getIntent().getStringExtra(EXTRA_CONTENT);
        gitContentTextView.setText(content);
    }
}