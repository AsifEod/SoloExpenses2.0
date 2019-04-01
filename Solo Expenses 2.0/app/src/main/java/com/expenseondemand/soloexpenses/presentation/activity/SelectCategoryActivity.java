package com.expenseondemand.soloexpenses.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseActivity;

import butterknife.ButterKnife;

public class SelectCategoryActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inflateView(R.layout.activity_select_category));
        ButterKnife.bind(this);
        initializeUI();

    }

    private void initializeUI() {
        setTopbarVisibility(View.VISIBLE);
        setTopbarTitle("Select Category", View.VISIBLE);
//        setTopbarActionText("Submit", View.VISIBLE);
        setTopbarActionImage(R.drawable.refresh_icon_vector, View.VISIBLE);
    }

    public static Intent getSelectCategoryActivityIntent(Context context) {
        return new Intent(context, SelectCategoryActivity.class);
    }

}
