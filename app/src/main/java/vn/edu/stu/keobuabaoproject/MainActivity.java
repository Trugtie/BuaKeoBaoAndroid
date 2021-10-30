package vn.edu.stu.keobuabaoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton btnKeo, btnBua, btnGiay;
    Button btnNghiChoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        btnKeo = findViewById(R.id.btnKeo);
        btnBua = findViewById( R.id.btnBua);
        btnGiay = findViewById(R.id.btnGiay);
        btnNghiChoi = findViewById(R.id.btnThoat);
    }

    private void addEvents(){
        btnKeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnBua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnGiay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnNghiChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void xuLyRa(View v){
        String banRa = ((ImageButton)v).getTag().toString();
        Intent intent = new Intent(MainActivity.this,KetQuaActivity.class);
        intent.putExtra("BANRA",banRa);
        startActivity(intent);
    }
}