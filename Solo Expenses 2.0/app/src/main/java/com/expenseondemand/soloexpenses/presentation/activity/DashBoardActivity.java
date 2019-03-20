package com.expenseondemand.soloexpenses.presentation.activity;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.adapters.DashBoardMenuAdapter;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseActivity;
import com.expenseondemand.soloexpenses.presentation.viewModel.DashBoardViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoardActivity extends BaseActivity {

    @BindView(R.id.rv_claim)
    RecyclerView rv_claim;

    private DashBoardManager dashBoardManager = new DashBoardManager();

    // These enums will help in generic recyclerview for dashboard menu options
    public enum Menu{
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

    private void initializeUI() {
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.HORIZONTAL,false);
//        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        layoutmanager.setReverseLayout(false);
        rv_claim.setLayoutManager(layoutmanager);

        rv_claim.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rv_claim.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                rv_claim.setAdapter(new DashBoardMenuAdapter(dashBoardManager.getDashboardForClaim(),rv_claim.getWidth()));
            }
        });
        rv_claim.setHasFixedSize(true);
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
