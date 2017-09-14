package com.example.cuitao.myapplication;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

//import com.jaeger.library.StatusBarUtil;

import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<MyAdapter.MyViewHolder> adapter;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("currentThread---",Thread.currentThread().getName());
        initView();
//        Retrofit retrofit=new Retrofit.Builder().build();
//        Volley.newRequestQueue(this).add(null);
        Volley.newRequestQueue(this,null);
        ThreadPoolExecutor ThreadPoolExecutor;
        Map<String,String> map=new HashMap<>();
//        ExecutorService executorService= Executors.newSingleThreadExecutor(new ThreadFactory() {
//            @Override
//            public Thread newThread(@NonNull Runnable runnable) {
//                Thread t=new Thread(runnable);
//                t.setDaemon(true);
//                return t;
//            }
//        });
        ExecutorService executorService= Executors.newFixedThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable runnable) {
                Thread t=new Thread(runnable);
                return t;



            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread1",Thread.currentThread().getName());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread2",Thread.currentThread().getName());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread3",Thread.currentThread().getName());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread4",Thread.currentThread().getName());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread5",Thread.currentThread().getName());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread6",Thread.currentThread().getName());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThread7",Thread.currentThread().getName());
            }
        });
        PriorityBlockingQueue blockingDeque=new PriorityBlockingQueue<>();
//        FutureTask<String> task=new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Log.d("currentThread",Thread.currentThread().getName());
//
////                Toast.makeText(MainActivity.this,Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
//
//                Looper.prepare();
//
//                Looper looper= Looper.myLooper();
//
//                Looper.loop();
//
//                mHandler =new Handler(looper){
//                    @Override
//                    public void handleMessage(Message msg) {
//                        super.handleMessage(msg);
//                        switch (msg.what){
//                            case 0:
//                                Log.d("loop1",Thread.currentThread().getName());
//                                Log.d("loop",(String)msg.obj);
//                                break;
//
//                        }
//                    }
//                };
////                SystemClock.sleep(100);
//
//
//
//                return new String("1");
//            }
//        });
//        new Thread(task).start();




//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("currentThreadRun",Thread.currentThread().getName());
//                Message msg=Message.obtain();
//                msg.what=0;
//                msg.obj=Thread.currentThread().getName();
//                mHandler.sendMessage(msg);
//            }
//        }).start();
        String str=new String("0000");
        String s="123456789";




        Toast.makeText(this,fun(s),Toast.LENGTH_SHORT).show();
    }

    public String fun(String s){
        Log.i("------",s);
//        String str=(s.length()>0?fun(s.substring(1))+s.charAt(0):"");
        String str=(s.length()>0?fun(s.substring(1)):"");
        Log.i("1---1",str);
        return str;

    }
    public void  initView(){
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        List<String> list=new ArrayList<String>();
        for (int i=0;i<100;i++){
            list.add("数据源"+i);
        }
        adapter=new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                Log.d("currentThreadrecycler",Thread.currentThread().getName());
            }
        });
    }
    protected void setStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
    private class Task1 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


}
