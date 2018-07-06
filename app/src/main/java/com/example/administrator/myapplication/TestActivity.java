package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @param
 * @author huxx
 * @Description:
 * @return
 * @date 2018-07-05 13:14
 * @update
 */
public class TestActivity extends AppCompatActivity {
    Button btn_click1 ;
    TextView txt_show1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("testActivit","------------------------------activiti创建");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btn_click1 = findViewById(R.id.btn_click1);
        txt_show1 = findViewById(R.id.txt_show1);


        txt_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_show1.setText("哈哈，我又变了");
            }
        });
        btn_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_show1.setText("哈哈哈，我变了");

            }
        });
        txt_show1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txt_show1.setText("你快压死我啦");
                return true;
            }
        });
        btn_click1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(TestActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            }
        });
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.i("testActivit","------------------------------activiti开始");
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.i("testActivit","------------------------------activiti获取焦点");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("testActivit","------------------------------activiti失去焦点");
    }
    @Override
    protected  void onStop(){
        super.onStop();
        Log.i("testActivit","------------------------------activiti停止");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("testActivit","------------------------------activiti关闭");
    }
}
