package com.expenseondemand.soloexpenses.domain.manager;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.activity.DashBoardActivity;
import com.expenseondemand.soloexpenses.presentation.model.DashBoardMenuModel;

import java.util.ArrayList;
import java.util.List;

public class DashBoardManager {

    public List<DashBoardMenuModel> getDashboardForClaim(){

        List<DashBoardMenuModel> list = new ArrayList<>();

        list.add(new DashBoardMenuModel(R.drawable.create_expense_vector, "Expenses", DashBoardActivity.Menu.CREATE_EXPENSE,0));
        list.add(new DashBoardMenuModel(R.drawable.receipt_icon_vector, "Receipt", DashBoardActivity.Menu.RECEIPT,0));
        list.add(new DashBoardMenuModel(R.drawable.mileage_icon_vector, "Mileage", DashBoardActivity.Menu.MILEAGE,0));
        list.add(new DashBoardMenuModel(R.drawable.advance_request_icon_vector, "Advances", DashBoardActivity.Menu.ADVANCES_REQUEST,0));
        return list;
    }

    public List<DashBoardMenuModel> getDashboardMenuForListAndAction(){
        List<DashBoardMenuModel> list = new ArrayList<>();

        list.add(new DashBoardMenuModel(R.drawable.expenses_icon_vector, "Expenses", DashBoardActivity.Menu.EXPENSE_LIST,12));
        list.add(new DashBoardMenuModel(R.drawable.advances_icon_vector, "Advances", DashBoardActivity.Menu.ADVANCE_LIST,0));
        list.add(new DashBoardMenuModel(R.drawable.charts_icon_vector, "Charts", DashBoardActivity.Menu.CHARTS,0));
        return list;
    }

    public List<DashBoardMenuModel> getDashboardMenuForApprove(){
        List<DashBoardMenuModel> list = new ArrayList<>();

        return list;
    }

    public List<DashBoardMenuModel> getDashboardMenuForReimburse(){
        List<DashBoardMenuModel> list = new ArrayList<>();

        return list;
    }
}
