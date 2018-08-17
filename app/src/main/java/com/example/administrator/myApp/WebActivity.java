package com.example.administrator.myApp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.web_show)
    WebView web_show ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
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
        web_show.loadUrl("http://www.baidu.com");
        web_show.getSettings().setJavaScriptEnabled(true);//加上这一行为响应式的
        web_show.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;//返回ture 立即跳转，返回false打开网页有延时
            }
        });


    }


    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_click :
                Toast.makeText(getApplicationContext(),"你好啊 ！我是神",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WebActivity.this,EditTestActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_show :
                Toast.makeText(getApplicationContext(),"你好啊 ！我是谁",Toast.LENGTH_LONG).show();
                break;
            case  R.id.btn_clickForAutoEdit:
                Intent intent1 = new Intent(WebActivity.this,AutoEditTestActivity.class);
                startActivity(intent1);
                break;
            case  R.id.btn_clickForButton:
                Intent intent2 = new Intent(WebActivity.this,ButtonTestActivity.class);
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

                if(count >10){
                    break;
                }
                count +=1;
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
