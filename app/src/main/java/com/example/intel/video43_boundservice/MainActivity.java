package com.example.intel.video43_boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.ServiceConnection;
import android.widget.TextView;
import android.view.View;

import com.example.intel.video43_boundservice.MyService.MyLocalBinder;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    MyService buckysService;
    boolean isBound = false;

    public void showTime(View view){
        // Testing commit again
        String currentTime = buckysService.getCurrenttime();
        TextView buckysText = (TextView) findViewById(R.id.buckysText);
        buckysText.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i, buckysConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection buckysConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyLocalBinder binder = (MyLocalBinder) iBinder;
            buckysService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };
}
