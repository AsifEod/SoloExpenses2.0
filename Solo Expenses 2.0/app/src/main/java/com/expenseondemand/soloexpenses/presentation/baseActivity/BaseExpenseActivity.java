package com.expenseondemand.soloexpenses.presentation.baseActivity;

import android.content.Intent;
import android.os.Bundle;

import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.domain.entities.CategoryModel;

import androidx.annotation.Nullable;

public abstract class BaseExpenseActivity extends BaseActivity {

    protected CategoryModel categoryModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getCommonDataFromIntent(getIntent());

    }

    private void getCommonDataFromIntent(Intent intent) {
        categoryModel = intent.getParcelableExtra(AppConstants.KEY_CATEGORY_MODEL);
    }
}
