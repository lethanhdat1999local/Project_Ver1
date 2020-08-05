package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.RecyclerViewAdapter;
import tdc.edu.doanlaptrinhdidong2.ModulesClass.xemay;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbQuanLyXe;
import tdc.edu.doanlaptrinhdidong2.R;

public class allProducts_activity extends AppCompatActivity {
    ArrayList <xemay> dsXe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbQuanLyXe db= new dbQuanLyXe(allProducts_activity.this);
        dsXe = db.layDuLieu();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,dsXe);
        RecyclerView rcv = findViewById(R.id.recyclerview);
        rcv.setLayoutManager(new GridLayoutManager(this,2));
        rcv.setAdapter(recyclerViewAdapter);
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
                Intent intent = new Intent(allProducts_activity.this,AddNew_activity.class);
                startActivity(intent);
                break;
            case R.id.menutatcasanpham:
                Intent intent1 = new Intent(allProducts_activity.this,allProducts_activity.class);
                startActivity(intent1);
            case R.id.menuhome:
                Intent intent2 = new Intent(allProducts_activity.this,manhinhchinh_activity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
