package com.expenseondemand.soloexpenses.presentation.baseActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.presentation.model.AlertDialogModel;
import com.expenseondemand.soloexpenses.presentation.utility.dialog.SoloAlertDialog;
import com.expenseondemand.soloexpenses.presentation.viewModel.DashBoardViewModel;
import com.expenseondemand.soloexpenses.presentation.viewModel.base.ViewModelFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private View topbar_layout;
    protected TextView tv_title;
    private ImageView iv_back;
    private TextView tv_action;
    private ImageView iv_action;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppTheme();
    }

    protected View inflateView(int res) {
        View view = LayoutInflater.from(this).inflate(res, null);
        initializeTopbarUI(view);
        return view;
    }

    protected void initializeTopbarUI(View view) {

        topbar_layout = view.findViewById(R.id.topbar_layout);
        iv_back = view.findViewById(R.id.iv_back);
        tv_action = view.findViewById(R.id.tv_action);
        iv_action = view.findViewById(R.id.iv_action);
        tv_title = view.findViewById(R.id.tv_title);

        if (topbar_layout != null) {
            topbar_layout.setVisibility(View.GONE);
        }

        if (iv_back != null) {
            iv_back.setOnClickListener(this);
        }

        if(iv_action != null){
            iv_action.setOnClickListener(this);
        }
    }


    protected void setTopbarVisibility(int visibility) {
        if (topbar_layout != null) {
            topbar_layout.setVisibility(visibility);
        }
    }

    protected void setTopbarTitle(String title, int visibility) {
        if (tv_title != null) {
            tv_title.setVisibility(visibility);
            tv_title.setText(title);
        }
    }

    protected void setTopbarActionText(String actionText, int visibility) {
        if (tv_action != null) {
            tv_action.setText(actionText);
            tv_action.setVisibility(visibility);
        }
    }

    protected void setTopbarActionImage(int resId, int visibility) {
        if (iv_action != null) {
            iv_action.setImageResource(resId);
            iv_action.setVisibility(visibility);
        }
    }


    private void setAppTheme() {
        switch (AppConstants.APP_THEME) {
            case Default:
                setTheme(R.style.SoloDefaultTheme);
                break;
            case RED:
                setTheme(R.style.SoloRedTheme);
                break;
        }
    }


    @SuppressWarnings("unchecked")
    protected <T extends ViewModel> T getViewModel(Class<T> modelClass) {
        ViewModelFactory factory = ViewModelFactory.getInstance();

        return (T) ViewModelProviders.of(this, factory).get(DashBoardViewModel.class);
    }


    protected void onBackPress() {
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPress();
                break;

            case R.id.iv_action:
                onIvActionClick();
                break;
        }
    }

    protected void onIvActionClick() {
        // No need to do anything in the base class
    }


    protected DialogFragment showAlertDialog(String tag, AlertDialogModel data){
        SoloAlertDialog dialogFragment = SoloAlertDialog.newInstance(data);

        // remove if there is another instance of alertdialog
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment prev = fm.findFragmentByTag(tag);
        if (prev != null) {
            ft.remove(prev);
        }

        dialogFragment.show(fm, tag);
        return dialogFragment;
    }
}
