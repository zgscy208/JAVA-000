package demo.nio;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OkHttpClient {
    public static void main(String[] args) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8808/test").build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.body());
            }
        });
    }
}