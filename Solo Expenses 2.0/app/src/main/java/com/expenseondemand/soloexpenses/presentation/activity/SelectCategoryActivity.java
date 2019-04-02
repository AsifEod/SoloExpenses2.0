package com.expenseondemand.soloexpenses.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.base.AppConstants;
import com.expenseondemand.soloexpenses.domain.entities.CategoryModel;
import com.expenseondemand.soloexpenses.presentation.adapters.AdapterSelectCategory;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCategoryActivity extends BaseActivity implements AdapterSelectCategory.Listener {

    @BindView(R.id.rv_category_list)
    RecyclerView rv_category_list;

    public static Intent getSelectCategoryActivityIntent(Context context) {
        return new Intent(context, SelectCategoryActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inflateView(R.layout.activity_select_category));
        ButterKnife.bind(this);
        initializeUI();
        updateCategoryListAdapter(generateCateogries());
    }

    private void updateCategoryListAdapter(List<CategoryModel> categoryModelList) {

        rv_category_list.setAdapter(new AdapterSelectCategory(categoryModelList, this));

    }

    private void initializeUI() {
        setupTopBar();
        rv_category_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_category_list.setHasFixedSize(true);

    }

    private void setupTopBar() {
        setTopbarVisibility(View.VISIBLE);
        setTopbarTitle("Select Category", View.VISIBLE);
        setTopbarActionImage(R.drawable.refresh_icon_vector, View.VISIBLE);
    }

    //    Delete this method when DB and API are setup
    private List<CategoryModel> generateCateogries() {
        List<CategoryModel> list = new ArrayList<>();

        list.add(new CategoryModel(1, R.drawable.charts_icon_vector, "Air Travel", false, AppConstants.KEY_NORMAL_EXPENSE_CATEGORY_ID));
        list.add(new CategoryModel(2, R.drawable.refresh_icon_vector, "Hotel", false, AppConstants.KEY_NORMAL_EXPENSE_CATEGORY_ID));
        list.add(new CategoryModel(3, R.drawable.advances_icon_vector, "Mileage Google", false, AppConstants.KEY_NORMAL_EXPENSE_CATEGORY_ID));

        return list;
    }


    @Override
    public void onCategorySelected(CategoryModel categoryModel) {
        switch (categoryModel.getBaseCategory()){

            case AppConstants.KEY_NORMAL_EXPENSE_CATEGORY_ID:
                handleNormalExpense(categoryModel);
                break;

        }
    }

    private void handleNormalExpense(CategoryModel categoryModel) {
        
    }
}
