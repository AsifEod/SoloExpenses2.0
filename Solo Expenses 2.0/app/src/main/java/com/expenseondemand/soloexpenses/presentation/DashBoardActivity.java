package com.expenseondemand.soloexpenses.presentation;

import android.os.Bundle;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseActivity;
import com.expenseondemand.soloexpenses.presentation.viewModel.DashBoardViewModel;

import androidx.annotation.NonNull;

public class DashBoardActivity extends BaseActivity {

    private DashBoardViewModel dashBoardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
