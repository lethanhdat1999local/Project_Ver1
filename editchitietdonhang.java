package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.chitietdonhang;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbchitietdonhang;
import tdc.edu.doanlaptrinhdidong2.R;

public class editchitietdonhang extends AppCompatActivity {
    EditText edtmaxe,edtsoluong,edtdongia,edtngaylap;
    ImageButton btnsua,btnthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editchitietdonhang);
        setControll();
        setEvent();
    }
    private void setEvent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final int maHD = bundle.getInt("maDH");
        final int maxe = bundle.getInt("maxe");
        final int soluong = bundle.getInt("soluong");
        final int dongia = bundle.getInt("dongia");
        final String ngaylap = bundle.getString("ngaylap");
        edtmaxe.setText(maxe+"");
        edtsoluong.setText(soluong+"");
        edtdongia.setText(dongia+"");
        edtngaylap.setText(ngaylap+"");
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chitietdonhang ct = new chitietdonhang();
                ct.setMaxe(Integer.parseInt(edtmaxe.getText().toString().trim()));
                ct.setSoluongdonhang(Integer.parseInt(edtsoluong.getText().toString().trim()));
                ct.setDongia(Integer.parseInt(edtdongia.getText().toString().trim()));
                ct.setNgaylap(edtngaylap.getText().toString().trim());
                dbchitietdonhang db = new dbchitietdonhang(editchitietdonhang.this);
                db.update(ct,maHD);
                Toast.makeText(getApplicationContext(),"update thanh cong",Toast.LENGTH_SHORT).show();
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });
    }
    private void setControll() {
        edtmaxe = findViewById(R.id.edtmaxe_chitietdonhang);
        edtsoluong = findViewById(R.id.edtsoluong_chitietdonhang);
        edtdongia = findViewById(R.id.edtdongia_chitietdonhang);
        edtngaylap = findViewById(R.id.edtngaylap_chitietdonhang);
        btnsua = findViewById(R.id.imgedit_chitietdonhang);
        btnthoat = findViewById(R.id.imgtrove_chitietdonhang);
    }
}
