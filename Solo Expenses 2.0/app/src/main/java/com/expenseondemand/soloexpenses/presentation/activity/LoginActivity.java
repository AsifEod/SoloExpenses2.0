package com.expenseondemand.soloexpenses.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.expenseondemand.soloexpenses.R;
import com.expenseondemand.soloexpenses.presentation.baseActivity.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_email)
    TextInputEditText et_email;

    @BindView(R.id.til_email)
    TextInputLayout til_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
}
