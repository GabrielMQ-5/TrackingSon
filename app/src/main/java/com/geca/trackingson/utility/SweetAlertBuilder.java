package com.geca.trackingson.utility;

import android.content.Context;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SweetAlertBuilder {

    public static SweetAlertDialog positiveAlert(Context context, String title, String message  ){
        return new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(message);
    }
    public static SweetAlertDialog warningAlert(Context context, String title, String message  ){
        return new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .setConfirmText("continue");
    }
    public static SweetAlertDialog negativeAlert(Context context, String title, String message  ){
        return new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message);
    }
    public static SweetAlertDialog loadingAlert(Context context, String title, String message  ){
        return new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(title)
                .setContentText(message);
    }

}
