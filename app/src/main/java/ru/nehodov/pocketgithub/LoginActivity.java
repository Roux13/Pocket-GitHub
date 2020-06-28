package ru.nehodov.pocketgithub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getName();

    private static final String EXTRA_CONTENT = "extra_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText loginEditText = findViewById(R.id.editTextLogin);
        EditText passwordEditText = findViewById(R.id.editTextPassword);

        Button signInBtn = findViewById(R.id.signInBtn);
        signInBtn.setOnClickListener(v -> {
                Intent intent = new Intent(LoginActivity.this, ContentActivity.class);
                intent.putExtra(
                        EXTRA_CONTENT,
                        new GitHubConnector().signIn(loginEditText.getText().toString(),
                                passwordEditText.getText().toString()));
                startActivity(intent);
        });
    }
}