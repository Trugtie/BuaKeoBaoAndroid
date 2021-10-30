package vn.edu.stu.keobuabaoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class KetQuaActivity extends AppCompatActivity {
    public static ArrayList<String> kbg= new ArrayList<String>(){
        {
            add("KÉO");
            add("BÚA");
            add("GIẤY");
        }
    };

    TextView txtBanRa, txtMayRa, txtKetQua;
    Button btnTroLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
        addControls();
        addEvents();
        xuLyThongTinBanChon();
    }

    private void addControls(){
        txtBanRa = findViewById(R.id.txtBanRa);
        txtMayRa = findViewById(R.id.txtMayRa);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnTroLai = findViewById(R.id.btnReturn);
    }

    private void addEvents(){
        btnTroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void xuLyThongTinBanChon(){
        Intent intent = getIntent();
        if(intent.hasExtra("BANRA")) {
            String banRa = intent.getStringExtra("BANRA");
            if(banRa==""){
                txtKetQua.setText("KHÔNG CÓ THÔNG TIN");
            }else{
                txtBanRa.setText("Bạn ra: " + banRa);
                int iBanRa = kbg.indexOf(banRa);
                int iMayRa = new Random().nextInt(kbg.size());
                String mayRa = kbg.get(iMayRa);
                txtMayRa.setText("Kết quả: " + mayRa);
                int kq = iBanRa-iMayRa;
                if(kq==0)txtKetQua.setText("Kết quả: HÒA");
                else if(kq==1 || kq==-2)
                    txtKetQua.setText("Kết quả: BẠN THẮNG");
                else txtKetQua.setText("Kết quả: BẠN THUA");
            }
        }else
        {
            txtBanRa.setText("KHÔNG CÓ THÔNG TIN");
        }
    }
}