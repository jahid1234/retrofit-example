package com.example.getdatafromservertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/WebApplication1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

      //  getPersonDataWithJsonObject();
        getPersonDataWithJsonArray();
    }

    private void getPersonDataWithJsonObject(){
                Call<GetData> call = jsonPlaceHolderApi
                .getPersonDataWithFullUrlOne("http://10.0.2.2:8080/WebApplication1/people/Ada");

//        Call<List<GetData>> call = jsonPlaceHolderApi
//                .getPersonData("Ada");
        call.enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                System.out.println("onResponse");
                System.out.println(response.body().toString());
                GetData serverData = response.body();
                textViewResult.append(serverData.getName());
                textViewResult.append(serverData.getAbout());
                textViewResult.append(serverData.getBirthYear().toString());
//                List<GetData> comments = response.body();
//                for (GetData comment : comments) {
//                    String content = "";
//                    content += "Name: " + comment.getName() + "\n";
//                    content += "About: " + comment.getAbout() + "\n";
//                    content += "BirthYear: " + String.valueOf(comment.getBirthYear()) + "\n";
//
//                    textViewResult.append(content);
//                }
            }
            @Override
            public void onFailure(Call<GetData> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getPersonDataWithJsonArray(){

        Call<List<GetData>> call = jsonPlaceHolderApi
                .getPersonDataWithFullUrl("http://10.0.2.2:8080/WebApplication1/people/Ada");
//               Call<List<GetData>> call = jsonPlaceHolderApi
//               .getPersonDataWithJsonArray();

        call.enqueue(new Callback<List<GetData>>() {
            @Override
            public void onResponse(Call<List<GetData>> call, Response<List<GetData>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<GetData> posts = response.body();
                for (GetData post : posts) {
                    String content = "";
                    content += "Name: " + post.getName() + "\n";
                    content += "About: " + post.getAbout() + "\n";
                    content += "BirthYear: " + post.getBirthYear() + "\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<GetData>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
