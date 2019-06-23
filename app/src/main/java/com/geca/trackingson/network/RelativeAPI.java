package com.geca.trackingson.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RelativeAPI {

    @POST("relative/{relativeId}/logout")
    Call<ResponseBody> logoutAccountMethod(@Path("relativeId") int relativeId, @Header("Authorization") String token);

}
