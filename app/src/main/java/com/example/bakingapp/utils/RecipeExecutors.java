package com.example.bakingapp.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecipeExecutors {
    private static final Object LOCK = new Object();
    private static RecipeExecutors sInstance;
    private final Executor diskIO;
    private final Executor networkIO;
    private final Executor mainThread;

    private RecipeExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public static RecipeExecutors getInstance() {
        if( sInstance == null ) {
            synchronized (LOCK) {
                sInstance = new RecipeExecutors(
                        Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new MainThreadExecutor()
                );
            }
        }
        return sInstance;
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}