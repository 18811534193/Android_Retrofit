# Android_Retrofit
Retrofit是基于Okhttp的一个网络框架，把http请求部分交给okhttp，然后多出了一个动态代理，很好用，喜欢的可以学习一下，很简单

主要代码

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
    
    
    需要添加依赖  我用的带gson的依赖包
    
    com.squareup.retrofit2:converter-gson:2.3.0
    
