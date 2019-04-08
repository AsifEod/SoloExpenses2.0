package com.expenseondemand.soloexpenses.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.expenseondemand.soloexpenses.presentation.utility.dialog.SoloAlertDialog;

public class AlertDialogModel implements Parcelable {

    private String title;
    private String btnSingleTitle;
    private String btnLeftTitle;
    private String btnRightTitle;
    private String subTitle;
    private SoloAlertDialog.SoloAlertDialogListener listener;

    public AlertDialogModel() {

    }

    protected AlertDialogModel(Parcel in) {
        title = in.readString();
        btnSingleTitle = in.readString();
        btnLeftTitle = in.readString();
        btnRightTitle = in.readString();
        subTitle = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(btnSingleTitle);
        dest.writeString(btnLeftTitle);
        dest.writeString(btnRightTitle);
        dest.writeString(subTitle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AlertDialogModel> CREATOR = new Creator<AlertDialogModel>() {
        @Override
        public AlertDialogModel createFromParcel(Parcel in) {
            return new AlertDialogModel(in);
        }

        @Override
        public AlertDialogModel[] newArray(int size) {
            return new AlertDialogModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBtnSingleTitle() {
        return btnSingleTitle;
    }

    public void setBtnSingleTitle(String btnSingleTitle) {
        this.btnSingleTitle = btnSingleTitle;
    }

    public String getBtnLeftTitle() {
        return btnLeftTitle;
    }

    public void setBtnLeftTitle(String btnLeftTitle) {
        this.btnLeftTitle = btnLeftTitle;
    }

    public String getBtnRightTitle() {
        return btnRightTitle;
    }

    public void setBtnRightTitle(String btnRightTitle) {
        this.btnRightTitle = btnRightTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public SoloAlertDialog.SoloAlertDialogListener getListener() {
        return listener;
    }

    public void setListener(SoloAlertDialog.SoloAlertDialogListener listener) {
        this.listener = listener;
    }
}