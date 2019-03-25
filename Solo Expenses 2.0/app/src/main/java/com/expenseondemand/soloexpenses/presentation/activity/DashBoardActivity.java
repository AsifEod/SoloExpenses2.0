package com.expenseondemand.soloexpenses.presentation.activity;

import android.os.Bundle;
import android.view.View;
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

public class DashBoardActivity extends BaseActivity implements DashBoardMenuAdapter.DashboardMenuAdapterListener {

    @BindView(R.id.rv_claim)
    RecyclerView rv_claim;

    @BindView(R.id.rv_list_action)
    RecyclerView rv_list_action;

    @BindView(R.id.rv_approve)
    RecyclerView rv_approve;

    @BindView(R.id.rv_reimburse)
    RecyclerView rv_reimburse;

    @BindView(R.id.claim_layout)
    View claim_layout;

    @BindView(R.id.list_action_layout)
    View list_action_layout;

    @BindView(R.id.approve_layout)
    View approve_layout;

    @BindView(R.id.reimburse_layout)
    View reimburse_layout;

    private DashBoardManager dashBoardManager = new DashBoardManager();


    // These enums will help in generic recyclerview for dashboard menu options
    public enum Menu {
        CREATE_EXPENSE, RECEIPT, MILEAGE, ADVANCES_REQUEST, ADVANCE_LIST, EXPENSE_LIST, CHARTS, APPROVER_EXPENSE_LIST, REIMBURSE_EXPENSE_LIST
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
                updateMenu(claim_layout, dashBoardManager.getDashboardForClaim(), rv_claim);
            }
        });

        // LIST and Action layout
        rv_list_action.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_list_action.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_list_action.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(list_action_layout, dashBoardManager.getDashboardMenuForListAndAction(), rv_list_action);
            }
        });

        // Approver layout
        rv_approve.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_approve.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_approve.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(approve_layout, dashBoardManager.getDashboardMenuForApprove(), rv_approve);
            }
        });

        // Reimburse layout
        rv_reimburse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_reimburse.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_reimburse.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                updateMenu(reimburse_layout, dashBoardManager.getDashboardMenuForReimburse(), rv_reimburse);
            }
        });


    }

    private void updateMenu(View parentLayout, List<DashBoardMenuModel> menuModelList, RecyclerView recyclerView) {
        if (menuModelList.isEmpty()) {
            parentLayout.setVisibility(View.GONE);
        } else {
            parentLayout.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(new DashBoardMenuAdapter(menuModelList, recyclerView.getWidth(), this));
        }
    }


    @Override
    public void onDashboardItemClick(Menu item) {
        switch (item) {
            case CREATE_EXPENSE:
                handleCreateExpense();
                break;
        }
    }

    private void handleCreateExpense() {

    }

}
