package com.geca.trackingson.utility;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.geca.trackingson.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SweeAlert {
    private SweetAlertDialog sweetAlertDialog;
    private Context context;

    public SweeAlert(SweetAlertDialog sweetAlertDialog,Context context){
        this.context = context;
        this.sweetAlertDialog = sweetAlertDialog;
    }

    public SweetAlertDialog getSweetAlertDialog() {
        return sweetAlertDialog;
    }

    public SweeAlert setSweetAlertDialog(SweetAlertDialog sweetAlertDialog) {
        this.sweetAlertDialog = sweetAlertDialog;
        return this;
    }

    public void loadingAlertDialog(){
        sweetAlertDialog = SweetAlertBuilder.loadingAlert(context, context.getString(R.string.title_alert_loading), context.getString(R.string.text_alert_loading));
        sweetAlertDialog.getProgressHelper().setBarColor(ContextCompat.getColor(context,R.color.colorAccent));
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.show();
    }

    public void warningAlertDialog(String message){
        sweetAlertDialog = SweetAlertBuilder.warningAlert(context, context.getString(R.string.title_alert_warning), message);
        sweetAlertDialog.show();
    }

    public void negativeAlertDialog(String message){
        sweetAlertDialog = SweetAlertBuilder.negativeAlert(context, context.getString(R.string.title_alert_error), message);
        sweetAlertDialog.show();
    }

    public void errorInternalServerDialog(){
        negativeAlertDialog(context.getString(R.string.text_alert_server_error));
    }


    public void errorBadRequestDialog(){
        negativeAlertDialog(context.getString(R.string.text_alert_bad_request));
    }


    public void dismissWithAnimation(){
        sweetAlertDialog.dismissWithAnimation();
    }

}
