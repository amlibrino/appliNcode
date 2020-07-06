package dal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://dev.amorce.org/apicode/api_Ncode/";

    //@SuppressWarnings("ALL")
    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)//base url du site de l'api
                    .addConverterFactory(GsonConverterFactory.create()) //creer le convertor en gson
                    .build(); //le contruire
        }
        return retrofit;
    }
}
