package com.expenseondemand.soloexpenses.presentation.viewModel.base;

import android.annotation.SuppressLint;
import android.app.Application;

import com.expenseondemand.soloexpenses.presentation.viewModel.DashBoardViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {


    // TODO: 18-03-2019 Add repository/ usecases factory class here

    @SuppressLint("StaticFieldLeak")
    private static volatile ViewModelFactory INSTANCE;


    public static ViewModelFactory getInstance( ) {

        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory();
                }
            }
        }
        return INSTANCE;
    }

    private ViewModelFactory() {
        // Generic constructor, can be customized
    }


    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(DashBoardViewModel.class)) {
            return (T) new DashBoardViewModel();
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }


}
