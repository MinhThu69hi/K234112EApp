package com.lyminhthu.k234112eapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
/*
Declare all variables for interactive views
 **/
    EditText EditUsername;
    EditText EditPassword;
    TextView txtMessage;

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
    }
    public void LoginSystem(View view) {
        String username=EditUsername.getText().toString();
        String password=EditPassword.getText().toString();
        if(username.equalsIgnoreCase("admin") &&
                password.equals("123"))
        {
            txtMessage.setText(getString(R.string.str_login_success));
            android.content.Intent intent = new android.content.Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            txtMessage.setText(getString(R.string.str_login_fail));
        }
    }

    public void ExitSystem (View view) {
        finish();
    }
}