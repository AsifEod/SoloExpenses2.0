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
    private int recyclerViewWidth;


    public DashBoardMenuAdapter(List<DashBoardMenuModel> list, int recyclerViewWidth) {
        this.list = list;
        this.recyclerViewWidth = recyclerViewWidth;
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
            int count = menuModel.getActionCount();
            int visibility = (count < 1) ? View.INVISIBLE : View.VISIBLE;

            ((ViewHolder) holder).iv_icon.setImageResource(menuModel.getIconResourceId());
            ((ViewHolder) holder).tv_action_count.setVisibility(visibility);
            if(!(count < 1))
            ((ViewHolder) holder).tv_action_count.setText(count + "");
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
            // to have 4 items only at a time
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(recyclerViewWidth / 4, RelativeLayout.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(params);
        }

    }
}
