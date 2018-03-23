package com.sunchang.tabtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/23.
 */

public class QuitAppDialog extends Dialog {

    private TextView titleText;
    private Button positiveButton;
    private Button negativeButton;

    private Context context;

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
        
    }
}
