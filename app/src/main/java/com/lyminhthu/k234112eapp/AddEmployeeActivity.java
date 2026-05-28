package com.lyminhthu.k234112eapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lyminhthu.models.Department;
import com.lyminhthu.models.Employee;

import java.util.ArrayList;

public class AddEmployeeActivity extends AppCompatActivity {
    EditText edtId, edtName, edtPhone;
    ImageView imgSave, imgCancel;
    AutoCompleteTextView actBirthplace;
    ArrayList<String> listBirthPlace;
    ArrayAdapter<String> adapterBirthPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_employee);
        addViews();
        addEvents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        actBirthplace = findViewById(R.id.actBirthplace);
        imgSave = findViewById(R.id.imgSave);
        imgCancel = findViewById(R.id.imgCancel);

        listBirthPlace = new ArrayList<>();
        String [] arrBirthPlace = getResources().getStringArray(R.array.array_birthplace);
        adapterBirthPlace = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrBirthPlace);
        actBirthplace.setAdapter(adapterBirthPlace);

    }
    private void addEvents() {
        imgSave.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                processAddNewEmployee();
            }
        });
    }

    private void processAddNewEmployee() {
        String id = edtId.getText().toString();
        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        String birthplace = actBirthplace.getText().toString();

        Employee employee = new Employee(id, name, phone, birthplace);
        //Step1: get intent
        Intent intent = getIntent();
        //Step2: set data
        intent.putExtra("NEW_EMPLOYEE", employee);
        //Step3: set result
        setResult(888, intent);
        //Step4: finish
        finish();
    }

        }