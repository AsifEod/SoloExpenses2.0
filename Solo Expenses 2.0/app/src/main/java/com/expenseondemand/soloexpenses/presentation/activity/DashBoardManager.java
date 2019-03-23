package com.expenseondemand.soloexpenses.presentation.activity;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.model.DashBoardMenuModel;

import java.util.ArrayList;
import java.util.List;

public class DashBoardManager {

    public List<DashBoardMenuModel> getDashboardForClaim(){

        List<DashBoardMenuModel> list = new ArrayList<>();

        list.add(new DashBoardMenuModel(R.drawable.create_expense_vector, "Expense", DashBoardActivity.Menu.CREATE_EXPENSE,0));
        list.add(new DashBoardMenuModel(R.drawable.create_expense_vector, "Expense", DashBoardActivity.Menu.CREATE_EXPENSE,0));
        list.add(new DashBoardMenuModel(R.drawable.create_expense_vector, "Expense", DashBoardActivity.Menu.CREATE_EXPENSE,1));
        list.add(new DashBoardMenuModel(R.drawable.create_expense_vector, "Expense", DashBoardActivity.Menu.CREATE_EXPENSE,12));
        return list;
    }

}
