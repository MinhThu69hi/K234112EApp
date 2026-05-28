package com.lyminhthu.k234112eapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lyminhthu.models.DataWareHouse;
import com.lyminhthu.models.Order;

import java.util.ArrayList;

public class OrderManagementActivity extends AppCompatActivity {
    TextView txtFromDate, txtToDate;
    ImageView imgFromDate, imgToDate;
    ImageView imgCleanFilter, imgFilter;
    ListView lvOrder;
    ArrayList<Order> orders;
    ArrayAdapter<Order> orderAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        addViews();
        setContentView(R.layout.activity_order_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        txtFromDate = findViewById(R.id.txtFromDate);
        txtToDate = findViewById(R.id.txtToDate);
        imgFromDate = findViewById(R.id.imgFromDate);
        imgToDate = findViewById(R.id.imgToDate);
        imgCleanFilter = findViewById(R.id.imgCleanFilter);
        imgFilter = findViewById(R.id.imgFilter);

        lvOrder = findViewById(R.id.lvOrder);
        orders = DataWareHouse.getOrders();
        orderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orders);
        lvOrder.setAdapter(orderAdapter);
    }
}