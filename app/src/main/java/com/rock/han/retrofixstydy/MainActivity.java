package com.rock.han.retrofixstydy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRequestWeatherInfo();
    }

    /** 去请求天气信息*/
    private void toRequestWeatherInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                //RequestHttp.WeatherBaseUrl = "http://www.weather.com.cn/"
                .baseUrl("http://www.weather.com.cn/")
                //记得添加相关依赖
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IService weather = retrofit.create(IService.class);
        Call<WeatherBean> weatherBeanCall = weather.weatherInfo("101010100.html");
        //这里只是写了异步请求，你也可以进行同步请求
        weatherBeanCall.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                String str=response.body().toString();
                Log.i("Tag123",response.body().getWeatherinfo().getCity()+"-"+response.body().getWeatherinfo().getWD());
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                Log.i("Tag123","onFailure");
            }
        });
    }

}
