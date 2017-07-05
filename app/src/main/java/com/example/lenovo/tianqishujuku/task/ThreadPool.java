package com.example.lenovo.tianqishujuku.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lenovo on 2017/5/27.
 */

public class ThreadPool {
    private static ThreadPool threadPool;
    private static ExecutorService executorService;
    private static final int MAX_THREAD_NUMBER=5;
    public synchronized static ThreadPool getInstanc(){
        if (threadPool==null){
     executorService= Executors.newFixedThreadPool(MAX_THREAD_NUMBER);
            threadPool=new ThreadPool();
        }else {

        }
        return threadPool;
    }
    public Future addRunnabable(Runnable runnable){


        return executorService.submit(runnable);
    }
}
