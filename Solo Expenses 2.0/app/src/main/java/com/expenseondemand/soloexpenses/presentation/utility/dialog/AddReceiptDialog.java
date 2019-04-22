package com.expenseondemand.soloexpenses.presentation.utility.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.expenseondemand.soloexpenses.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AddReceiptDialog extends DialogFragment implements View.OnClickListener {

    public enum ButtonType {Camera, Gallery}

    public interface AddReceiptListener {
        void onAddReceiptClick(ButtonType buttonType);
    }

    @BindView(R.id.layout_camera)
    View layout_camera;
    @BindView(R.id.layout_gallery)
    View layout_gallery;
    @BindView(R.id.iv_close)
    ImageView iv_close;

    private AddReceiptListener listener;

    public static AddReceiptDialog newInstance() {

        Bundle args = new Bundle();

        AddReceiptDialog fragment = new AddReceiptDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.SoloDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_receipt_dialog, container);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        layout_gallery.setOnClickListener(this);
        layout_camera.setOnClickListener(this);
        iv_close.setOnClickListener(this);
    }

    private void handleClickEvent(ButtonType buttonType) {
        if (listener != null) {
            listener.onAddReceiptClick(buttonType);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_camera:
                handleClickEvent(ButtonType.Camera);
                break;

            case R.id.layout_gallery:
                handleClickEvent(ButtonType.Gallery);
                break;

            case R.id.iv_close:
                dismissAllowingStateLoss();
                break;
        }
    }

    public void setListener(AddReceiptListener listener) {
        this.listener = listener;
    }
}
