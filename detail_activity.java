package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.xemay;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbQuanLyXe;
import tdc.edu.doanlaptrinhdidong2.R;

public class detail_activity extends AppCompatActivity {
    EditText tvten,tvxuatxu,tvdungtich,tvgia;
    Button btnchuky,btnupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        setControl();
        setEvent();
    }
    private void setEvent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String ten = bundle.getString("tenxe");
        String dungtich = bundle.getString("dungtich");
        String soluong = bundle.getInt("soluong")+"";
        String gia = bundle.getInt("gia")+"";
        final int ma_xe = bundle.getInt("idxemay");
        tvten.setText(ten+"");
        tvxuatxu.setText(""+dungtich);
        tvdungtich.setText(""+soluong);
        tvgia.setText(""+gia);
        btnchuky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detail_activity.this,chukydientu.class);
                Bundle bundle1 = new Bundle();
                bundle1.putInt("maxe",ma_xe);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xemay xemay = new xemay();
                xemay.setMaxe(ma_xe);
                xemay.setTenxe(tvten.getText().toString());
                xemay.setDungtich(tvxuatxu.getText().toString());
                xemay.setSoluong( Integer.parseInt(tvdungtich.getText().toString()));
                xemay.setMaloai(Integer.parseInt(tvgia.getText().toString()));
                dbQuanLyXe db= new dbQuanLyXe(detail_activity.this);
                db.update(xemay,ma_xe);
                Toast.makeText(getApplicationContext(),"update thành công" ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setControl() {
        tvten = findViewById(R.id.tvchitiettenxe);
        tvxuatxu = findViewById(R.id.tvchitietxuatxu);
        tvdungtich = findViewById(R.id.tvchitietdungtich);
        tvgia   = findViewById(R.id.tvchitietgia);
        btnchuky = findViewById(R.id.btnchukydientu);
        btnupdate = findViewById(R.id.btnupdate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuthemsanpham:
                Intent intent = new Intent(detail_activity.this,AddNew_activity.class);
                startActivity(intent);
                break;
            case R.id.menutatcasanpham:
                Intent intent1 = new Intent(detail_activity.this,allProducts_activity.class);
                startActivity(intent1);
            case R.id.menuhome:
                Intent intent2 = new Intent(detail_activity.this,manhinhchinh_activity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
