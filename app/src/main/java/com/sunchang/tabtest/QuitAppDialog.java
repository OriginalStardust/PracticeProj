package com.sunchang.tabtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/23.
 */

public class QuitAppDialog extends Dialog {

    private TextView titleText;
    private Button positiveButton;
    private Button negativeButton;
    private RadioButton radioButton;

    private Context context;

    private boolean isRadioButtonChecked = true;

    public QuitAppDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCustomDialog();
    }

    private void setCustomDialog() {
        View view = LayoutInflater.from(context).inflate(R.layout.quit_dialog, null);
        titleText = (TextView) view.findViewById(R.id.quit_dialog_title);
        positiveButton = (Button) view.findViewById(R.id.quit_dialog_exit);
        negativeButton = (Button) view.findViewById(R.id.quit_dialog_cancel);
        radioButton = (RadioButton) view.findViewById(R.id.radio_button);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRadioButtonChecked) {
                    radioButton.setChecked(false);
                    isRadioButtonChecked = false;
                } else {
                    radioButton.setChecked(true);
                    isRadioButtonChecked = true;
                }
            }
        });

        this.setContentView(view);

        Window window = this.getWindow();
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindow().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = (int) (metrics.widthPixels * 0.9);
        window.setAttributes(params);
    }

    public void setOnPositiveListener(View.OnClickListener listener) {
        positiveButton.setOnClickListener(listener);
    }

    public void setOnNegativeListener(View.OnClickListener listener) {
        negativeButton.setOnClickListener(listener);
    }

    public void setTitle(String title) {
        this.titleText.setText(title);
    }
}
