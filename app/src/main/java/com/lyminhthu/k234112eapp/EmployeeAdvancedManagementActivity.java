package com.lyminhthu.k234112eapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lyminhthu.adapters.EmployeeAdapter;
import com.lyminhthu.models.Department;
import com.lyminhthu.models.Employee;

import java.util.ArrayList;

public class EmployeeAdvancedManagementActivity extends AppCompatActivity {

    ListView lvEmployee;
    ArrayList<Employee> listEmployee;
    EmployeeAdapter adapterEmployee;

    Spinner spDepartment;
    ArrayList<Department> listDepartment;
    ArrayAdapter<Department> adapterDepartment;
    ImageView imgAddEmployee, imgEditEmployee, imgDeleteEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_advanced_management);
        addViews();
        sampleData();
        addEvents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        spDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int i, long l) {
                adapterEmployee.clear();
                if (i == 0) {
                    for (int j = 1; j < listDepartment.size(); j++) {
                        adapterEmployee.addAll(listDepartment.get(j).getListEmployee());
                    }
                } else {
                    Department selectedDepartment = listDepartment.get(i);
                    adapterEmployee.addAll(selectedDepartment.getListEmployee());
                }
                adapterEmployee.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imgAddEmployee.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(EmployeeAdvancedManagementActivity.this, AddEmployeeActivity.class);

                //startActivity(intent);
                startActivityForResult(intent, 999);
                
            }
        });
    }

    private void sampleData() {
        Department d0 = new Department("0", "-----All-----");
        Department d1 = new Department("1", "Phòng hành chính");
        Department d2 = new Department("2", "Phòng nhân sự");
        Department d3 = new Department("3", "Phòng tài chính");
        Department d4 = new Department("4", "Phòng kĩ thuật");

        listDepartment.add(d0);

        listDepartment.add(d1);
        listDepartment.add(d2);
        listDepartment.add(d3);
        listDepartment.add(d4);
        adapterDepartment.notifyDataSetChanged();

        d1.addEmployee(new Employee("e1", "tèo", "0125642132"));
        d1.addEmployee(new Employee("e2", "tý", "0125645632"));
        d1.addEmployee(new Employee("e3", "cám", "012345461"));
        d2.addEmployee(new Employee("e4", "tèo", "0125642132"));
        d2.addEmployee(new Employee("e5", "tý", "0125645632"));
        d2.addEmployee(new Employee("e6", "cám", "012345461"));

        ArrayList<Employee> listofEmp4 = new ArrayList<>();
        listofEmp4.add(new Employee("e7", "tèo", "0125642132"));
        listofEmp4.add(new Employee("e8", "tý", "0125645632"));
        listofEmp4.add(new Employee("e9", "cám", "012345461"));
        listofEmp4.add(new Employee("e10", "tèo", "0125642132"));
        d4.addListEmployee(listofEmp4);


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
        spDepartment = findViewById(R.id.spDepartment);
        listDepartment = new ArrayList<>();
        adapterDepartment = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listDepartment);
        adapterDepartment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDepartment.setAdapter(adapterDepartment);

        imgAddEmployee = findViewById(R.id.imgAddEmployee);
        imgEditEmployee = findViewById(R.id.imgEditEmployee);
        imgDeleteEmployee = findViewById(R.id.imgDeleteEmployee);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == 888) {
            Employee employee = (Employee) data.getSerializableExtra("NEW_EMPLOYEE");
            Department pHuman = listDepartment.get(2);
            pHuman.addEmployee(employee);
            adapterEmployee.clear();
            adapterEmployee.addAll(pHuman.getListEmployee());
            adapterEmployee.notifyDataSetChanged();
        }

    }
}