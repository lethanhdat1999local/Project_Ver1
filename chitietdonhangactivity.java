package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.chitietdonhang;
import tdc.edu.doanlaptrinhdidong2.ModulesClass.ctdhadapter;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbchitietdonhang;
import tdc.edu.doanlaptrinhdidong2.R;

public class chitietdonhangactivity extends AppCompatActivity {
    EditText edtmaxe,edtsoluong,edtdongia,edtngaylap;
    ImageButton imgthem,imgthoat,imgtimkiem;
    ListView lvresult;
    ArrayList<chitietdonhang> danhsachdonhang;
    ctdhadapter ctdhadapter;
    dbchitietdonhang dbchitietdonhang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietdonhangactivity);
        setControll();
        setEvent();
        dbchitietdonhang = new dbchitietdonhang(this);
        danhsachdonhang = dbchitietdonhang.layDuLieu();
        setAdapter();
    }

    private void setAdapter() {
        if(ctdhadapter==null){
            ctdhadapter = new ctdhadapter(this,R.layout.tencongty,danhsachdonhang);
            lvresult.setAdapter(ctdhadapter);
        }else{
            ctdhadapter.notifyDataSetChanged();
        }
    }
    private void updateInfor(){
        danhsachdonhang.clear();
        danhsachdonhang.addAll(dbchitietdonhang.layDuLieu());
        setAdapter();
    }
    private void setEvent() {
        imgthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chitietdonhang ct = createChitiet();
                if(ct!=null){
                    dbchitietdonhang.Them(ct);
                }
                updateInfor();
            }
        });
        imgthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imgtimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chitietdonhangactivity.this,timkiem_chitietdonhang.class);
                startActivity(intent);
            }
        });
    }

    private chitietdonhang createChitiet(){
        int maxe = Integer.parseInt(String.valueOf(edtmaxe.getText()));
        int soluong = Integer.parseInt(String.valueOf(edtsoluong.getText()));
        int dongia = Integer.parseInt(String.valueOf(edtdongia.getText()));
        String ngaylap = edtngaylap.getText().toString();
        chitietdonhang ct = new chitietdonhang(maxe,soluong,dongia,ngaylap);
        return ct;
    }

    private void setControll(){
        edtmaxe = findViewById(R.id.edtmaxe_chitietdonhang);
        edtsoluong = findViewById(R.id.edtsoluong_chitietdonhang);
        edtdongia = findViewById(R.id.edtdongia_chitietdonhang);
        edtngaylap = findViewById(R.id.edtngaylap_chitietdonhang);
        imgthem = findViewById(R.id.btnthem_chitietdonhang);
        imgthoat = findViewById(R.id.btnexit_chitietdonhang);
        lvresult = findViewById(R.id.listviewchitietdonhang);
        imgtimkiem = findViewById(R.id.btntimkiem_chitietdonhang);
    }
}
