package com.lyminhthu.k234112eapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class EmployeeManagementActivity extends AppCompatActivity {
    ListView lvEmployee;
    ArrayList<String>listEmployee;
    ArrayAdapter<String> adapterEmployee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_management);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        lvEmployee = findViewById(R.id.lvEmployee);
        listEmployee = new ArrayList<>();
        listEmployee.add("e1-tèo-0125642132");
        listEmployee.add("e2-tý-0125645632");
        listEmployee.add("e3-cám-012345461");
        adapterEmployee = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listEmployee);
        lvEmployee.setAdapter(adapterEmployee);


    }

    public void closeEmployeeActivity(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custorm_dialog);
        dialog.setCanceledOnTouchOutside(false);
        // thử lấy img ra
        ImageView imgSave = dialog.findViewById(R.id.imgYes);
        ImageView imgCancel = dialog.findViewById(R.id.imgCancel);
        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}