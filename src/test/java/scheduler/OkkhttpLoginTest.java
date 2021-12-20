package scheduler;

import com.google.gson.Gson;
import dto.AuthRequestDto;
import dto.AuthResponseDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class OkkhttpLoginTest {
public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    @Test
    public void loginTest() throws IOException {
        AuthRequestDto requestDto = AuthRequestDto.builder().email("").password("").build();
 Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto),JSON);
        Request request = new Request.Builder()
                .url("https://")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()){
            String responseJson = response.body().string();
            AuthResponseDto responseDto = gson.fromJson(responseJson,AuthResponseDto.class);
            responseDto.getToken();
            System.out.println(responseDto.getToken());
            System.out.println(response.code());
            Assert.assertTrue(response.isSuccessful());
        }
    }
}
