package com.geca.trackingson.userinterface.main;

import com.geca.trackingson.userinterface.BasePresenter;
import com.geca.trackingson.userinterface.BaseView;


public interface MainContract {

    interface View extends BaseView<MainContract.Presenter> {


    }

    interface Presenter extends BasePresenter {
        void logout(String relativeId, String token);
    }

}
