package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbQuanLyXe;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbchitietdonhang;
import tdc.edu.doanlaptrinhdidong2.R;
import tdc.edu.doanlaptrinhdidong2.touchPaintSign.PaintView;

public class chukydientu extends AppCompatActivity implements SensorEventListener {
    Button btnchukyxacnhan;
    private SensorManager sensorManager;
    PaintView paintView ;
    Sensor sensor;
    dbQuanLyXe dbQuanLyXe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chukydientu);
        paintView = (PaintView) findViewById(R.id.paintview);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
        setControl();
        setEvent();
        //tạo đối tượng sensormanager quản lý các sensor có trong thiết bị
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // tạo đối tượng sensor để lưu loại sensor muốn sử dụng
        sensor = sensorManager.getDefaultSensor(sensor.TYPE_PROXIMITY);
        // đăng kí sự kiện sensor
        sensorManager.registerListener(chukydientu.this,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }

    private void setEvent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final int maxe = bundle.getInt("maxe");
        btnchukyxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbQuanLyXe = new dbQuanLyXe(chukydientu.this);
                dbQuanLyXe.xoa(maxe);
                Toast.makeText(getApplicationContext(),"Bán hàng thành công",Toast.LENGTH_SHORT).show();
                paintView.saveToInternalStorage();
                Intent intent  = new Intent(chukydientu.this,allProducts_activity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
            btnchukyxacnhan = findViewById(R.id.btnkytenxacnhanmuahang);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]<sensor.getMaximumRange()){
            getWindow().getDecorView().setBackgroundColor(Color.RED);
            paintView.setDrawingCacheEnabled(true);
            paintView.saveToInternalStorage();
        }else{
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
