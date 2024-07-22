package com.example.lab5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LAB5Activity extends AppCompatActivity {
    EditText txt1,txt2,txt3;
    TextView tvKQ;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab5);
        txt1=findViewById(R.id.lab51Txt1);
        txt2=findViewById(R.id.lab51Txt2);
        txt3=findViewById(R.id.lab51Txt3);
        tvKQ=findViewById(R.id.lab51TvKQ);
        btn1=findViewById(R.id.lab51Btn1);
        btn1.setOnClickListener(v->{
            insertData(txt1,txt2,txt3,tvKQ);
        });
    }
    private void insertData(EditText txt1, EditText txt2, EditText txt3, TextView tvKQ) {

        SanPham s = new SanPham(txt1.getText().toString(),
                txt2.getText().toString(), txt3.getText().toString());

        // ipv4 ở nhà : 192.168.1.63
        // ipv4 trên trường : 10.24.42.249
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.24.42.249/000/20240720/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceInsertSanPham insertSanPham
                = retrofit.create(InterfaceInsertSanPham.class);

        Call<SvrResponseSanPham> call
                = insertSanPham.insertSanPham(s.getMaSP(),s.getTenSP(),s.getMoTa());

        call.enqueue(new Callback<SvrResponseSanPham>() {
            @Override
            public void onResponse(Call<SvrResponseSanPham> call, Response<SvrResponseSanPham> response) {
                    SvrResponseSanPham res = response.body();
                    tvKQ.setText(res.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseSanPham> call, Throwable t) {
                tvKQ.setText(t.getMessage());

            }
        });
    }
}