package com.example.administrator.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @param
 * @author huxx
 * @Description:
 * @return
 * @date 2018-07-05 13:14
 * @update
 */
public class EditTestActivity extends AppCompatActivity {
    Button btn_click1 ;
    TextView txt_show1;
    @BindView(R.id.btn_call)
    Button btn_call;
    @BindView(R.id.btn_showCall)
    Button btn_showCall;
    @BindView(R.id.btn_show)
    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("testActivit","------------------------------activiti创建");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittest);
        ButterKnife.bind(this);
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
//                txt_show1.setText("你快压死我啦");
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//              // We don't have permission so prompt the user如果我们没有权限就弹出提示请求用户赋予权限
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }

                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18953186913"));
                startActivity(call);
                return true;
            }
        });
        btn_click1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(EditTestActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//              // We don't have permission so prompt the user如果我们没有权限就弹出提示请求用户赋予权限
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }

                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18953186913"));
                startActivity(call);
            }
        });

        btn_showCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//              // We don't have permission so prompt the user如果我们没有权限就弹出提示请求用户赋予权限
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }

                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18953186913"));
                startActivity(call);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//              // We don't have permission so prompt the user如果我们没有权限就弹出提示请求用户赋予权限
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }

                Intent call = new Intent("com.android.phone.action.TOUCH_DIALER");
                startActivity(call);
            }
        });

        //--------------------------------------------输入上移参数测试 START----------------------------------------------
        //弹出输入法时，界面会上移，默认值
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //弹出输入法时，阻止界面上移
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        //弹出输入法时不显示标题，界面会上移
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //弹出输入法时，显示标题，界面会上移，效果同resize一样
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED);

        //--------------------------------------------输入上移参数测试 END------------------------------------------------
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
