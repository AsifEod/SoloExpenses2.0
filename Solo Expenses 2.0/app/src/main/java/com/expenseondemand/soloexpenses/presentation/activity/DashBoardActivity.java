package com.expenseondemand.soloexpenses.presentation.activity;

import android.os.Bundle;
import android.view.ViewTreeObserver;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.adapters.DashBoardMenuAdapter;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseActivity;
import com.expenseondemand.soloexpenses.presentation.model.DashBoardMenuModel;
import com.expenseondemand.soloexpenses.presentation.viewModel.DashBoardViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoardActivity extends BaseActivity {

    @BindView(R.id.rv_claim)
    RecyclerView rv_claim;

    @BindView(R.id.rv_list_action)
    RecyclerView rv_list_action;

    @BindView(R.id.rv_approve)
    RecyclerView rv_approve;

    @BindView(R.id.rv_reimburse)
    RecyclerView rv_reimburse;

    private DashBoardManager dashBoardManager = new DashBoardManager();

    // These enums will help in generic recyclerview for dashboard menu options
    public enum Menu {
        CREATE_EXPENSE, RECEIPT, MILEAGE, EXPENSE_LIST, CHARTS, APPROVER_EXPENSE_LIST, REIMBURSE_EXPENSE_LIST
    }

    private DashBoardViewModel dashBoardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        initializeUI();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    private void initializeUI() {
        // Claim layout
        rv_claim.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_claim.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_claim.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(dashBoardManager.getDashboardForClaim(), rv_claim);
            }
        });

        // LIST and Action layout
        rv_list_action.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_list_action.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_list_action.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(dashBoardManager.getDashboardForClaim(), rv_list_action);
            }
        });

        // Approver layout
        rv_approve.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_approve.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_approve.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(dashBoardManager.getDashboardForClaim(), rv_approve);
            }
        });

        // Reimburse layout
        rv_reimburse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_reimburse.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_reimburse.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(dashBoardManager.getDashboardForClaim(), rv_reimburse);
            }
        });


    }

    private void updateMenu(List<DashBoardMenuModel> claimAndPayMenuList, RecyclerView recyclerView) {
        recyclerView.setAdapter(new DashBoardMenuAdapter(claimAndPayMenuList, recyclerView.getWidth()));
    }

}
