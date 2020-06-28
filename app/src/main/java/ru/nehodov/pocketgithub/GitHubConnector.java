package ru.nehodov.pocketgithub;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GitHubConnector {

    private static final String PROTOCOL = "https://";
    private static final String HOST = "api.github.com";

    private OkHttpClient client;
    private String content;

    public GitHubConnector() {
        this.client = new OkHttpClient();
    }

    public String signIn(String login, String password) {
        Request request = new Request.Builder()
                .url(String.format("%s%s:%s@%s", PROTOCOL, login, password, HOST))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    GitHubConnector.this.content = response.body().string();
                }
            }
        });
        return this.content;
    }
}
