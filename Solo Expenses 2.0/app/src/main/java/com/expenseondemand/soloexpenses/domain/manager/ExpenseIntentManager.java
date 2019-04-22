package com.expenseondemand.soloexpenses.domain.manager;

import android.app.Activity;
import android.content.Intent;

import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.domain.entities.CategoryModel;
import com.expenseondemand.soloexpenses.presentation.activity.expenseScreen.CreateEditExpenseActivity;

public class ExpenseIntentManager {

    public static Intent getCreateExpenseIntent(Activity activity, CategoryModel categoryModel){

        Intent intent = null;

        switch (categoryModel.getBaseCategory()){
            case AppConstants.KEY_NORMAL_EXPENSE_CATEGORY_ID:
                intent = getIntentForNormalExpense(activity, categoryModel);
                break;

        }

        return intent;
    }

    private static Intent getIntentForNormalExpense(Activity activity, CategoryModel categoryModel) {
        Intent intent = CreateEditExpenseActivity.getCreateEditExpenseIntent(activity, categoryModel);
        return intent;
    }

}
