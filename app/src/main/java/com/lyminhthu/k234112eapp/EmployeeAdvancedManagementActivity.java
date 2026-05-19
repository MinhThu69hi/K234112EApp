package com.lyminhthu.k234112eapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lyminhthu.adapters.EmployeeAdapter;
import com.lyminhthu.models.Employee;

import java.util.ArrayList;

public class EmployeeAdvancedManagementActivity extends AppCompatActivity {

    ListView lvEmployee;
    ArrayList<Employee> listEmployee;
    EmployeeAdapter adapterEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_advanced_management);
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
        adapterEmployee = new EmployeeAdapter(this, R.layout.item_custom_employee);
        lvEmployee.setAdapter(adapterEmployee);
        listEmployee.add(new Employee("e1", "tèo", "0125642132"));
        listEmployee.add(new Employee("e2", "tý", "0125645632"));
        listEmployee.add(new Employee("e3", "cám", "012345461"));
        adapterEmployee.addAll(listEmployee);
        lvEmployee.setAdapter(adapterEmployee);
        adapterEmployee.notifyDataSetChanged();
    }

    }