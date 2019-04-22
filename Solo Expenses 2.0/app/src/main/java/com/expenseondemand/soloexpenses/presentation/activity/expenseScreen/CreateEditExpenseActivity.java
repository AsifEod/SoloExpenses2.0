package com.expenseondemand.soloexpenses.presentation.activity.expenseScreen;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.domain.entities.CategoryModel;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseExpenseActivity;

public class CreateEditExpenseActivity extends BaseExpenseActivity {


    public static Intent getCreateEditExpenseIntent(Activity activity, CategoryModel categoryModel) {
        Intent intent = new Intent(activity, CreateEditExpenseActivity.class);
        intent.putExtra(AppConstants.KEY_CATEGORY_MODEL, categoryModel);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inflateView(R.layout.activity_create_edit_expense));
        ButterKnife.bind(this);
        initializeUI();

    }

    private void initializeUI() {
        setupTopBar();
    }

    private void setupTopBar() {
        setTopbarVisibility(View.VISIBLE);
        setTopbarTitle(getString(R.string.label_expense), View.VISIBLE);
        setTopbarActionImage(R.drawable.refresh_icon_vector, View.VISIBLE);
    }
}
