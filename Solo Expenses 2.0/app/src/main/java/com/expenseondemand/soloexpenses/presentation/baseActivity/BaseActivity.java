package com.expenseondemand.soloexpenses.presentation.baseActivity;

import android.os.Bundle;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.presentation.viewModel.DashBoardViewModel;
import com.expenseondemand.soloexpenses.presentation.viewModel.base.ViewModelFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAppTheme();
    }

    private void setAppTheme() {
        switch (AppConstants.APP_THEME) {
            case Default:
                setTheme(R.style.SoloDefaultTheme);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    protected <T extends ViewModel> T getViewModel(Class<T> modelClass) {
        ViewModelFactory factory = ViewModelFactory.getInstance();

       return (T) ViewModelProviders.of(this,factory).get(DashBoardViewModel.class);
    }
}
