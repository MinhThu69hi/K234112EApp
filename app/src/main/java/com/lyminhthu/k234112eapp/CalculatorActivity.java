package com.lyminhthu.k234112eapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {
    EditText editFormula;
    Button btnDel, btnbalance, btnprecent, btnsq, btnsqrt, btn1x, btnC, btnCe, btnPlusMinus, btnDot;
    TextView txtMc, txtMr, txtMPlus, txrMMinus, txtMs, txtM;
    TextView txtHistory; // Nơi hiển thị danh sách lịch sử

    double memoryValue = 0;
    String name_history_pref = "CalcHistory"; // Tên file lưu lịch sử

    // Khai báo thêm các listener để dùng chung
    View.OnClickListener m_onclick;
    View.OnClickListener math_onclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        addViews();
        addEvents();

        // Hiển thị lại lịch sử cũ khi vừa mở app
        loadHistory();

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }

    private void addViews() {
        editFormula = findViewById(R.id.editFormula);
        btnDel = findViewById(R.id.btnDel);
        btnbalance = findViewById(R.id.btnbalance);
        btnsq = findViewById(R.id.btnsq);
        btnsqrt = findViewById(R.id.btnsqrt);
        btn1x = findViewById(R.id.btn1x);
        btnprecent = findViewById(R.id.btnprecent);
        btnC = findViewById(R.id.btnC);
        btnCe = findViewById(R.id.btnCe);
        btnPlusMinus = findViewById(R.id.btnplusminu);
        btnDot = findViewById(R.id.btnDot);

        txtMc = findViewById(R.id.txtMc);
        txtMr = findViewById(R.id.txtMr);
        txtMPlus = findViewById(R.id.txtMPlus);
        txrMMinus = findViewById(R.id.txrMMinus);
        txtMs = findViewById(R.id.txtMs);
        txtM = findViewById(R.id.txtM);

        txtHistory = findViewById(R.id.txtHistory);

        if (txtM != null) txtM.setText("");
    }

    private void addEvents() {
        // Nút xóa lùi (Del)
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = editFormula.getText().toString();
                if (current.length() > 0) {
                    editFormula.setText(current.substring(0, current.length() - 1));
                }
            }
        });

        // Nút C: Chỉ xóa màn hình nhập
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFormula.setText("");
            }
        });

        // NÚT CE: XÓA MÀN HÌNH + XÓA LỊCH SỬ TRONG SHAREPREFERENCES
        btnCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFormula.setText("");
                SharedPreferences sharedPreferences = getSharedPreferences(name_history_pref, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                txtHistory.setText("Lịch sử đã trống");
            }
        });

        // Nút Bằng (=): Tính toán và lưu vào SharedPreferences
        btnbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String formula = editFormula.getText().toString();
                    int viTriPhepTinh = -1;
                    String phepToan = "";

                    // Tìm phép tính (+ - * :)
                    for (int i = 0; i < formula.length(); i++) {
                        String kyTu = formula.substring(i, i + 1);
                        if (kyTu.equals("+") || kyTu.equals("-") || kyTu.equals("*") || kyTu.equals(":")) {
                            viTriPhepTinh = i;
                            phepToan = kyTu;
                        }
                    }

                    if (viTriPhepTinh > 0 && viTriPhepTinh < formula.length() - 1) {
                        double so1 = Double.parseDouble(formula.substring(0, viTriPhepTinh));
                        double so2 = Double.parseDouble(formula.substring(viTriPhepTinh + 1));
                        double ketQua = 0;

                        if (phepToan.equals("+")) ketQua = so1 + so2;
                        else if (phepToan.equals("-")) ketQua = so1 - so2;
                        else if (phepToan.equals("*")) ketQua = so1 * so2;
                        else if (phepToan.equals(":")) {
                            if (so2 != 0) ketQua = so1 / so2;
                            else { editFormula.setText("Error"); return; }
                        }

                        String strKetQua = (ketQua == (int) ketQua) ? String.valueOf((int) ketQua) : String.valueOf(ketQua);

                        // Lưu vào lịch sử
                        saveHistory(formula + " = " + strKetQua);

                        editFormula.setText(strKetQua);
                    }
                } catch (Exception e) {
                    editFormula.setText("Error");
                }
            }
        });

        // Nút +/-
        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double val = Double.parseDouble(editFormula.getText().toString());
                    editFormula.setText(String.valueOf(val * -1));
                } catch (Exception e) {}
            }
        });

        // Nút Chấm (.)
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = editFormula.getText().toString();
                if (!current.contains(".")) {
                    editFormula.setText(current + ".");
                }
            }
        });

        // Xử lý các nút Memory (MC, MR, M+, M-, MS)
        m_onclick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double hienTai = Double.parseDouble(editFormula.getText().toString());
                    int id = view.getId();
                    if (id == R.id.txtMc) {
                        memoryValue = 0;
                        txtM.setText("");
                    } else if (id == R.id.txtMr) {
                        editFormula.setText(String.valueOf(memoryValue));
                    } else if (id == R.id.txtMPlus) {
                        memoryValue += hienTai;
                        txtM.setText("M");
                    } else if (id == R.id.txrMMinus) {
                        memoryValue -= hienTai;
                        txtM.setText("M");
                    } else if (id == R.id.txtMs) {
                        memoryValue = hienTai;
                        txtM.setText("M");
                    }
                } catch (Exception e) {}
            }
        };
        txtMc.setOnClickListener(m_onclick);
        txtMr.setOnClickListener(m_onclick);
        txtMPlus.setOnClickListener(m_onclick);
        txrMMinus.setOnClickListener(m_onclick);
        txtMs.setOnClickListener(m_onclick);

        // Xử lý các nút toán học nhanh
        math_onclick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double val = Double.parseDouble(editFormula.getText().toString());
                    if (view.equals(btnsq)) val = val * val;
                    else if (view.equals(btnsqrt)) val = Math.sqrt(val);
                    else if (view.equals(btn1x)) val = 1 / val;
                    else if (view.equals(btnprecent)) val = val / 100;
                    editFormula.setText(String.valueOf(val));
                } catch (Exception e) { editFormula.setText("Error"); }
            }
        };
        btnsq.setOnClickListener(math_onclick);
        btnsqrt.setOnClickListener(math_onclick);
        btn1x.setOnClickListener(math_onclick);
        btnprecent.setOnClickListener(math_onclick);
    }

    private void saveHistory(String entry) {
        SharedPreferences sharedPreferences = getSharedPreferences(name_history_pref, MODE_PRIVATE);
        String oldHistory = sharedPreferences.getString("historyData", "");
        String newHistory = entry + "\n" + oldHistory;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("historyData", newHistory);
        editor.apply();

        txtHistory.setText(newHistory);
    }

    private void loadHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences(name_history_pref, MODE_PRIVATE);
        String history = sharedPreferences.getString("historyData", "Chưa có lịch sử");
        txtHistory.setText(history);
    }

    public void processInputData(View view) {
        Button btn_clicked = (Button) view;
        String old_value = editFormula.getText().toString();
        String input_value = btn_clicked.getText().toString();
        editFormula.setText(old_value + input_value);
    }
}