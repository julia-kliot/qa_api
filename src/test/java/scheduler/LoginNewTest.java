package scheduler;

import com.google.gson.Gson;
import dto.AuthRequestDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginNewTest {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    @Test
    public void logintest1() throws IOException {
        AuthRequestDto requestDto = RegRequestDto.builder().email("juliakliot.jk@gmail.com").password("Misha2406*").build();
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            String responseJson = response.body().string();
            RegResponseDto responseDto = gson.fromJson(responseJson, RegResponseDto.class);
            responseDto.getToken();
            responseDto.getStatus();
            responseDto.getRegistration();
            System.out.println(responseDto.getToken());
            System.out.println(responseDto.getRegistration());
            System.out.println(responseDto.getStatus());
            Assert.assertTrue(response.isSuccessful());
        } else {
            System.out.println("Wrong email or password-- " + response.code());
            Error error = gson.fromJson(response.body().toString(), Error.class);
            System.out.println(error.getMessage());
            //  System.out.println(error.getDetails());
            //
            //System.out.println(   +"****"+error.getMessage()+"****" + error.getDetails());
        }
    }
    @Test
    public void logintest2() throws IOException {
        RegRequestDto requestDto = RegRequestDto.builder().email("juliakliot.jk@gmail.com").password("Misha2406*").build();
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();

        String responseJson = response.body().string();
        RegResponseDto responseDto = gson.fromJson(responseJson, RegResponseDto.class);
        responseDto.getToken();
        responseDto.getStatus();
        responseDto.getRegistration();
        //System.out.println(responseDto.getToken());
        //System.out.println(responseDto.getRegistration());
        //System.out.println(responseDto.getStatus());
        Assert.assertEquals(responseDto.getStatus(),"Registration succes");
    }
    @Test
    public void logintestNeg() throws IOException {
        RegRequestDto requestDto = RegRequestDto.builder().email("juliakliot.jk@gmail.com").password("Misha2406*").build();
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();

        System.out.println("Wrong email or password-- " + response.code());
        Error error = gson.fromJson(response.body().toString(), Error.class);
        // (error.getMessage());
//   error.getCode();
//   error.getDetails();
        Assert.assertEquals(error.getMessage(),"//Wrong email or password--");


    }
}
}
