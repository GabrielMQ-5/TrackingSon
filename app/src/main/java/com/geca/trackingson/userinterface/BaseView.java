package com.geca.trackingson.userinterface;

public interface BaseView<T> {
    void setPresenter(T presenter);

    void openView(BaseView view);

    void closeView();

    void showErrorBadRequest();

    void showErrorInternalError();

    void showLoadingDialog();

    void showSuccessDialog();
}
