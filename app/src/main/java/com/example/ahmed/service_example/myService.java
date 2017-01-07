package com.example.ahmed.service_example;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ahmed on 04/01/17.
 */

public class myService extends Service {


   public Task task ;

    MediaPlayer mediaPlayer ;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {

        Toast.makeText(getApplicationContext() , "Service Created" ,Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onDestroy() {

        //task.cancel(true);
        mediaPlayer.stop();

        Toast.makeText(getApplicationContext() , "Service Destroyed" ,Toast.LENGTH_SHORT ).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound);

        mediaPlayer.start();

        //task = new Task();
        //task.execute();

        return START_STICKY;
    }


    public class Task extends AsyncTask<Void,Integer,Void>{

        @Override
        protected Void doInBackground(Void... params) {


            for (int i=0 ; i<10 ; i++){


                publishProgress(i);

                if (isCancelled())
                    return null;

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

            Toast.makeText(getApplicationContext(),String.valueOf( values [0]) , Toast.LENGTH_SHORT).show();

        }
    }
}
