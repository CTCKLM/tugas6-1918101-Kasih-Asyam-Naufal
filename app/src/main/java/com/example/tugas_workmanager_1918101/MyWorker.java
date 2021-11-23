package com.example.tugas_workmanager_1918101;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull
            WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        displayNotification("Idih pencet - pencet","Yang bawah yang asli");
        return Result.success();
    }

    public void displayNotification(String task, String desc){
        NotificationManager manager = (NotificationManager)
                        getApplicationContext().
                                getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new
                NotificationChannel("test123",
                "test123", NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);

        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getApplicationContext(),
                "test123")
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.drawable.system)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        manager.notify(1, builder.build());
    }
}