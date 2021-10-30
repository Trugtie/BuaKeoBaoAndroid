package vn.edu.stu.keobuabaoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class KetQuaActivity extends AppCompatActivity {
    public static ArrayList<String> kbg= new ArrayList<String>(){
        {
            add("1");
            add("2");
            add("3");
        }
    };

    TextView txtKetQua;
    Button btnTroLai;
    ImageButton btnBanRa,btnMayRa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
        addControls();
        addEvents();
        xuLyThongTinBanChon();
    }

    private void addControls(){
        txtKetQua = findViewById(R.id.txtKetQua);
        btnTroLai = findViewById(R.id.btnReturn);
        btnBanRa = findViewById(R.id.btnBanRa);
        btnMayRa = findViewById(R.id.btnMayRa);
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
                render(banRa,btnBanRa);
                int iBanRa = kbg.indexOf(banRa);
                int iMayRa = new Random().nextInt(kbg.size());
                String mayRa = kbg.get(iMayRa);
                render(mayRa,btnMayRa);
                int kq = iBanRa-iMayRa;
                if(kq==0)txtKetQua.setText("Kết quả: HÒA");
                else if(kq==1 || kq==-2)
                    txtKetQua.setText("Kết quả: BẠN THẮNG");
                else txtKetQua.setText("Kết quả: BẠN THUA");
            }
        }else
        {
            render("4",btnBanRa);;
        }
    }

    private void render(String tag,ImageButton btn){
        if(tag.equals("1"))
            btn.setImageResource(R.drawable.keo);
        else if (tag.equals("2"))
            btn.setImageResource(R.drawable.bua);
        else if(tag.equals("3"))
            btn.setImageResource(R.drawable.giay);
        else
            btn.setImageResource(R.drawable.khong);
    }
}