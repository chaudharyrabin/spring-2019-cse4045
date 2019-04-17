package seu.edu.bd.smartdeviceappdevelopment.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Random;

import seu.edu.bd.smartdeviceappdevelopment.R;

public class MyService extends Service {

    private int min = 0;
    private int max = 100;
    private boolean isRandomNumberGenerate = true;
    private int randomNumber;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(getString(R.string.tag),"Service Start");
        // random number generation
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    generateRandomNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return START_STICKY;

    }

    private void generateRandomNumber() throws InterruptedException {
        while (isRandomNumberGenerate){
            Thread.sleep(1000);
            randomNumber = new Random().nextInt(max);

            // send to activity
            Intent intent = new Intent("action_random_number_service");

            intent.putExtra("data", randomNumber);

            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomNumberGeneration();
        Log.i(getString(R.string.tag),"Service stop");
    }

    private void stopRandomNumberGeneration() {
        isRandomNumberGenerate = false;
    }
}
