package com.example.logonrm.metroapp.api;

import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Retrofit;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by logonrm on 26/06/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://10.3.1.17:3000";
    private static URL URL_BASE;


    public static IMetroAPI getMetroAPI() {
        return RetrofitClint.getClient(BASE_URL)
                .create(IMetroAPI.class);
    }

    public static String getResourceFullUrl(String resource){
        try {
            if (URL_BASE == null) {
                URL_BASE = new URL(BASE_URL);
            }

            URL merged = new URL(URL_BASE, resource);

            return merged.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
