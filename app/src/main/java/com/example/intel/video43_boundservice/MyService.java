package com.example.intel.video43_boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Binder;

public class MyService extends Service {

    private final IBinder buckysBinder = new MyLocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return buckysBinder;
    }

    public class MyLocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    public String getCurrenttime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }

}
