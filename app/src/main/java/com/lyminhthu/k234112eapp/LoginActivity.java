package com.lyminhthu.k234112eapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lyminhthu.models.ListUserAccount;
import com.lyminhthu.models.UserAccount;

public class LoginActivity extends AppCompatActivity {
/*
Declare all variables for interactive views
 **/
    EditText EditUsername;
    EditText EditPassword;
    TextView txtMessage;
    CheckBox chkSaveLogin;
    String name_share_pref = "LoginInfo";
    RadioButton radAdmin, radEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        EditUsername=findViewById(R.id.editUsername);
        EditPassword=findViewById(R.id.editPassword);
        txtMessage=findViewById(R.id.txtMessage);
        chkSaveLogin=findViewById(R.id.chkSaveLogin);
        radAdmin=findViewById(R.id.radAdmin);
        radEmployee=findViewById(R.id.radEmployee);
    }
    public void LoginSystem(View view) {
        String username=EditUsername.getText().toString();
        String password=EditPassword.getText().toString();
        UserAccount uc = ListUserAccount.login(username, password);
        if(uc!=null)
        {
            boolean saved = chkSaveLogin.isChecked();
            SharedPreferences sharedPreferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Username", username);
            editor.putString("Password", password);
            editor.putBoolean("Saved", saved);
            editor.commit();

            txtMessage.setText(getString(R.string.str_login_success));

            if(radAdmin.isChecked()) {//dĩ nheeen phải kiểm tra account có quyền admin ko
                //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Intent intent = new Intent(LoginActivity.this, OrderManagementActivity.class);
                intent.putExtra("USER_LOGIN", uc);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(LoginActivity.this, EmployeeAdvancedManagementActivity.class);
                startActivity(intent);
            }
        }
        else
        {
            txtMessage.setText(getString(R.string.str_login_fail));
        }
    }
    public void LoginSystemOld(View view) {
        String username=EditUsername.getText().toString();
        String password=EditPassword.getText().toString();
        if(username.equalsIgnoreCase("admin") &&
                password.equals("123"))
        {
            boolean saved = chkSaveLogin.isChecked();
            SharedPreferences sharedPreferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Username", username);
            editor.putString("Password", password);
            editor.putBoolean("Saved", saved);
            editor.commit();

            txtMessage.setText(getString(R.string.str_login_success));

            if(radAdmin.isChecked()) {//dĩ nheeen phải kiểm tra account có quyền admin ko
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(LoginActivity.this, EmployeeAdvancedManagementActivity.class);
                startActivity(intent);
            }
            }
        else
        {
            txtMessage.setText(getString(R.string.str_login_fail));
        }
    }

    public void ExitSystem (View view) {
        //finish();
        AlertDialog.Builder builder =new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Confirm exit");
        builder.setMessage("Muốn thoát hả?");
        builder.setIcon(android.R.drawable.ic_dialog_dialer);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
        String username = sharedPreferences.getString("Username", "");
        String password = sharedPreferences.getString("Password", "");
        boolean saved = sharedPreferences.getBoolean("Saved", false);
        if (saved) {
            EditUsername.setText(username);
            EditPassword.setText(password);
        }
        chkSaveLogin.setChecked(saved);
    }
}