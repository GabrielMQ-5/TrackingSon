package com.geca.trackingson.userinterface.main;

import android.util.Log;

import com.geca.trackingson.TrackingSonApplication;
import com.geca.trackingson.network.RelativeAPI;
import com.geca.trackingson.userinterface.login.LoginActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mainView;
    private static RelativeAPI relative = TrackingSonApplication.RETROFIT.create(RelativeAPI.class);

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
        mainView.setPresenter(this);
    }

    @Override
    public void logout(String relativeId, String token) {
        if(mainView!=null){
            try {
                relative.logoutAccountMethod(Integer.parseInt(relativeId), "Bearer " + token).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            int code = response.code();
                            switch (code){
                                case 201:
                                    mainView.openView(new LoginActivity());
                                    mainView.closeView();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }catch (Exception ex){
                Log.d("ERROR", ex.getMessage());
            }
        }
    }
}
