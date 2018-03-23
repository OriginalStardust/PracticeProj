package com.sunchang.tabtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        username = (EditText) this.findViewById(R.id.username_edit_text);
        password = (EditText) this.findViewById(R.id.password_edit_text);

        Drawable ic_account = ContextCompat.getDrawable(this, R.drawable.ic_account);
        Drawable ic_password = ContextCompat.getDrawable(this, R.drawable.ic_password);
        ic_account.setBounds(0, 0, 80, 80);
        username.setCompoundDrawables(ic_account, null, null, null);
        ic_password.setBounds(0, 0, 80, 80);
        password.setCompoundDrawables(ic_password, null, null, null);
    }

    public void onLoginClick(View view) {

        if (password.getText().toString().equals("123")) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(this.getResources().getString(R.string.error_dialog_title));
            dialog.setMessage(this.getResources().getString(R.string.error_dialog_message));
            dialog.setCancelable(true);
            dialog.setPositiveButton(this.getResources().getString(R.string.error_dialog_positive),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            dialog.show();
        }
    }
}
