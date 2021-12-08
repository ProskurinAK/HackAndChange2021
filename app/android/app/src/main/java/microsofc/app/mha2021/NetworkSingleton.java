package microsofc.app.mha2021;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkSingleton {
    private static NetworkSingleton mNet;
    private static final String BASE_URL = "https://stormy-badlands-67861.herokuapp.com";
    private Retrofit mRetrofit;

    private NetworkSingleton() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkSingleton getInstance(){
        if (mNet == null){
            mNet = new NetworkSingleton();
        }
        return mNet;
    }

    public ServerAPI getServerAPI() {
        return mRetrofit.create(ServerAPI.class);
    }
}
