package com.expenseondemand.soloexpenses.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.model.DashBoardMenuModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DashBoardMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DashBoardMenuModel> list;
    private int recyclerviewWidth = 0;


    public DashBoardMenuAdapter(List<DashBoardMenuModel> list, int recyclerviewWidth) {
        this.list = list;
        this.recyclerviewWidth = recyclerviewWidth;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dashboard_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            DashBoardMenuModel menuModel = list.get(position);

            ((ViewHolder) holder).iv_icon.setImageResource(menuModel.getIconResourceId());
            ((ViewHolder) holder).tv_action_count.setText(menuModel.getActionCount() + "");
            ((ViewHolder) holder).tv_menu_label.setText(menuModel.getMenuName());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_menu_label;
        private TextView tv_action_count;
        private ImageView iv_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_menu_label = itemView.findViewById(R.id.tv_menu_label);
            tv_action_count = itemView.findViewById(R.id.tv_action_count);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(recyclerviewWidth / 4, RelativeLayout.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(params);
        }

    }
}
