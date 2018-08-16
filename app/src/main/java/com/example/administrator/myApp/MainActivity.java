package com.example.administrator.myApp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_click)
    Button btn_click ;
    @BindView(R.id.txt_show)
    TextView txt_show;
    @BindView(R.id.btn_clickForAutoEdit)
    Button btn_clickForAutoEdit;
    @BindView(R.id.btn_clickForButton)
    Button btn_clickForButton;

    @BindView(R.id.btn_readSMS)
    Button btn_readSMS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        btn_click =findViewById(R.id.btn_click);
//        txt_show =findViewById(R.id.txt_show);
//
//
//        txt_show.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick(View view){
//                txt_show.setText("哈哈，我又变了");
//            }
//        });
        btn_click.setOnClickListener(this);
        btn_clickForAutoEdit.setOnClickListener(this);
        txt_show.setOnClickListener(this);
        btn_clickForButton.setOnClickListener(this);
        btn_readSMS.setOnClickListener(this);


    }


    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_click :
                Toast.makeText(getApplicationContext(),"你好啊 ！我是神",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,EditTestActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_show :
                Toast.makeText(getApplicationContext(),"你好啊 ！我是谁",Toast.LENGTH_LONG).show();
                break;
            case  R.id.btn_clickForAutoEdit:
                Intent intent1 = new Intent(MainActivity.this,AutoEditTestActivity.class);
                startActivity(intent1);
                break;
            case  R.id.btn_clickForButton:
                Intent intent2 = new Intent(MainActivity.this,ButtonTestActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_readSMS:
                readSms();
                break;
            default:
                break;

        }
    }


    public void readSms(){
       //获取内容提供者
        ContentResolver contentResolver = getContentResolver();
        //获取短信表的路径
        Uri uri = Uri.parse("content://sms");
        //设置要查询的列名
        String[] line = {"address", "date", "body"};
        //各个参数的意思，路径、列名、条件、条件参数、排序
        Cursor cursor = contentResolver.query(uri, line, null ,null, null);
        //下面就跟操作普通数据库一样了
        if (cursor != null) {
            int count = 0;
            while (cursor.moveToNext()) {
                count +=1;
                if(count > 0){
                    break;
                }
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String body = cursor.getString(cursor.getColumnIndex("body"));
                Toast.makeText(getApplicationContext(),"address:" + address + " date:" + date + " body:" + body,Toast.LENGTH_LONG).show();
                Log.e("短信", "address:" + address + " date:" + date + " body:" + body);
            }
            cursor.close();
        }

    }
}
