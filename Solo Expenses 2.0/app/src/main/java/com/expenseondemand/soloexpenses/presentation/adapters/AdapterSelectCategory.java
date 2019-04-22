package com.expenseondemand.soloexpenses.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.domain.entities.CategoryModel;
import com.expenseondemand.soloexpenses.presentation.utility.AppUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterSelectCategory extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryModel> categoryModelList;
    private Listener listener;
    private Context context;

    public interface Listener {
        void onCategorySelected(CategoryModel categoryModel);
    }

    public AdapterSelectCategory(List<CategoryModel> categoryModelList, Listener listener) {
        this.categoryModelList = categoryModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_select_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {

            CategoryModel model = categoryModelList.get(position);
            int favIconVisibility = model.isFav() ? View.VISIBLE : View.INVISIBLE;

            ((ViewHolder) holder).iv_category_icon.setImageResource(model.getResId());
            ((ViewHolder) holder).iv_fav_icon.setVisibility(favIconVisibility);
            ((ViewHolder) holder).tv_category_name.setText(model.getCategoryName()+"");
        }
    }

    @Override
    public int getItemCount() {
        return categoryModelList == null ? 0 : categoryModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv_category_icon;
        public TextView tv_category_name;
        public ImageView iv_fav_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_category_icon = itemView.findViewById(R.id.iv_category_icon);
            tv_category_name = itemView.findViewById(R.id.tv_category_name);
            iv_fav_icon = itemView.findViewById(R.id.iv_fav_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onCategorySelected(categoryModelList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
