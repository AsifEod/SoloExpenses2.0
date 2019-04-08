package com.expenseondemand.soloexpenses.presentation.utility.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.model.AlertDialogModel;
import com.expenseondemand.soloexpenses.presentation.utility.AppUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SoloAlertDialog extends DialogFragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_single:
                clickHandler(ButtonType.SINGLE);
                break;
            case R.id.tv_left:
                clickHandler(ButtonType.LEFT);
                break;
            case R.id.tv_right:
                clickHandler(ButtonType.RIGHT);
                break;
        }
    }

    public interface SoloAlertDialogListener {
        void onAction(ButtonType buttonType);
    }

    public enum ButtonType {SINGLE, LEFT, RIGHT}

    private static final String KEY_ALERT_DIALOG_DATA = "KEY_ALERT_DIALOG_DATA";
    private SoloAlertDialogListener listener;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_sub_title)
    TextView tv_sub_title;
    @BindView(R.id.tv_single)
    TextView tv_single;
    @BindView(R.id.two_btn_layout)
    View two_btn_layout;
    @BindView(R.id.tv_left)
    TextView tv_left;
    @BindView(R.id.tv_right)
    TextView tv_right;

    private AlertDialogModel alertData;

    public SoloAlertDialog() {
        // generic constructor is required
    }

    public static SoloAlertDialog newInstance(AlertDialogModel data) {

        Bundle args = new Bundle();
        args.putParcelable(KEY_ALERT_DIALOG_DATA, data);
        SoloAlertDialog fragment = new SoloAlertDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.SoloDialogTheme);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(KEY_ALERT_DIALOG_DATA)) {
            alertData = bundle.getParcelable(KEY_ALERT_DIALOG_DATA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.solo_alert_dialog_layout, container);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (alertData != null) {

            String leftText = alertData.getBtnLeftTitle();
            String rightText = alertData.getBtnRightTitle();
            String singleText = alertData.getBtnSingleTitle();
            String title = alertData.getTitle();
            String subTitle = alertData.getSubTitle();

            tv_single.setOnClickListener(this);
            tv_left.setOnClickListener(this);
            tv_right.setOnClickListener(this);

            if (AppUtils.isStringEmpty(leftText) || AppUtils.isStringEmpty(rightText)) {
                // This means it is a single button dialog
                two_btn_layout.setVisibility(View.GONE);
                tv_single.setText(singleText);
                tv_single.setVisibility(View.VISIBLE);
            } else {
                two_btn_layout.setVisibility(View.VISIBLE);
                tv_single.setVisibility(View.GONE);
                tv_left.setText(leftText);
                tv_right.setText(rightText);
            }

            if (!AppUtils.isStringEmpty(title)) {
                tv_title.setText(title);
                tv_title.setVisibility(View.VISIBLE);
            } else {
                tv_title.setVisibility(View.GONE);
            }

            if (!AppUtils.isStringEmpty(subTitle)) {
                tv_sub_title.setText(subTitle);
                tv_sub_title.setVisibility(View.VISIBLE);
            } else {
                tv_sub_title.setVisibility(View.GONE);
            }

            // set listener
            listener = alertData.getListener();
        }
    }

    private void clickHandler(ButtonType type) {
        if (listener != null) {
            listener.onAction(type);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
