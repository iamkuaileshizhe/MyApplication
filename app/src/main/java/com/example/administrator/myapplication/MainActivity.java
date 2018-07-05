package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn_click ;
    TextView txt_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_click =findViewById(R.id.btn_click);
        txt_show =findViewById(R.id.txt_show);


        txt_show.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                txt_show.setText("哈哈，我又变了");
            }
        });
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"你好啊 ！我是神",Toast.LENGTH_LONG).show();
                Log.i("d","h啊哈哈哈");
                txt_show.setText("哈哈哈，我变了");
//                Intent intent  = new Intent(MainActivity.this,TestActivity.class);
//                startActivity(intent);
            }
        });
        txt_show.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txt_show.setText("你快压死我啦");
                return true;
            }
        });


    }
}
