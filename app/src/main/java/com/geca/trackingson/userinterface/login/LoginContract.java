package com.geca.trackingson.userinterface.login;

import com.geca.trackingson.model.login.LoginRequest;
import com.geca.trackingson.model.login.LoginResponse;
import com.geca.trackingson.userinterface.BasePresenter;
import com.geca.trackingson.userinterface.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {

        void setSharedPreferences(LoginResponse response);

    }

    interface Presenter extends BasePresenter {
        void login(LoginRequest request);
    }

}
