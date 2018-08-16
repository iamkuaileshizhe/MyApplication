package com.example.administrator.myApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.*;
import butterknife.ButterKnife;

/**
 * @param
 * @author huxx
 * @Description: 测试自动填充编辑框
 * @return
 * @date 2018-07-05 13:14
 * @update
 */
public class AutoEditTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("testActivit","------------------------------activiti创建");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoedittest);
        ButterKnife.bind(this);
        String[] autoString = new String[]{"北京","上海","山东省","山东省济南市"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,autoString);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoEdit);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView multiAutoCompleteTextView =findViewById(R.id.multAutoEdit);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }


}
