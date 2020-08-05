package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.xemay;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbQuanLyXe;
import tdc.edu.doanlaptrinhdidong2.R;

public class AddNew_activity extends AppCompatActivity {
    EditText edtten,edtdungtich,edtsoluong,edtmaloai;
    ImageButton btnthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Thêm sản phẩm thành công",Toast.LENGTH_SHORT).show();
                dbQuanLyXe db= new dbQuanLyXe(AddNew_activity.this);
                xemay bt = getxemay();
                db.Them(bt);
            }
        });
    }

    private xemay getxemay() {
            String tenxe = edtten.getText().toString();
            String dungtich = edtdungtich.getText().toString();
            int soluong =  Integer.parseInt(edtsoluong.getText().toString());
            int maloai = Integer.parseInt(edtmaloai.getText().toString());
            xemay xe = new xemay(tenxe,maloai,dungtich,soluong);
            return xe;
    }

    private void setControl() {
        edtten = findViewById(R.id.edtten);
        edtsoluong = findViewById(R.id.edtsoluong);
        edtdungtich = findViewById(R.id.edtdungtich);
        edtmaloai = findViewById(R.id.edtmaloai);
        btnthem = findViewById(R.id.btnthemsanpham);
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
                Intent intent = new Intent(AddNew_activity.this,AddNew_activity.class);
                startActivity(intent);
                break;
            case R.id.menutatcasanpham:
                Intent intent1 = new Intent(AddNew_activity.this,allProducts_activity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
