package com.rock.han.retrofixstydy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019/10/11.
 */

public interface IService
{
    //天气网址：http://www.weather.com.cn/data/sk/101010100.html
    @GET("data/sk/{location}")
    Call<WeatherBean> weatherInfo(@Path("location") String locationCode);

    /*@GET("data/sk/101010100.html")
    Call<WeatherBean> weatherBJInfo();*/


}
