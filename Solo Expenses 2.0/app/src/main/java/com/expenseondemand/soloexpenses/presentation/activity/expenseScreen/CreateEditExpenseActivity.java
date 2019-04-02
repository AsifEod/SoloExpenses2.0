package com.expenseondemand.soloexpenses.presentation.activity.expenseScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.domain.entities.CategoryModel;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseExpenseActivity;

public class CreateEditExpenseActivity extends BaseExpenseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_expense);


    }

}
