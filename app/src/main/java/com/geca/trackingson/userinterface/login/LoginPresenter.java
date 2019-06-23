package com.geca.trackingson.userinterface.login;

import android.util.Log;

import com.geca.trackingson.TrackingSonApplication;
import com.geca.trackingson.model.login.LoginRequest;
import com.geca.trackingson.model.login.LoginResponse;
import com.geca.trackingson.network.AuthAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View loginView;
    private static AuthAPI auth = TrackingSonApplication.RETROFIT.create(AuthAPI.class);

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        loginView.setPresenter(this);
    }


    @Override
    public void login(LoginRequest request) {
        if (loginView != null){
            if (isValidLoginRequest(request)){
                try {
                    auth.loginAccountMethod(request).enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if(response.isSuccessful()){
                                int code = response.code();
                                switch (code){
                                    case 201:
                                        LoginResponse result = response.body();
                                        loginView.setSharedPreferences(result);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                        }
                    });

                }
                catch (Exception ex){
                    loginView.showErrorBadRequest();
                    Log.d("ERROR", ex.getMessage());
                }
            }
        }
    }

    private boolean isValidLoginRequest(LoginRequest request) {
        return !(request.getUsername().trim().isEmpty() || request.getPassword().trim().isEmpty());
    }


}
