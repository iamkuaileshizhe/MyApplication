package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @author huxx
 * @Description:
 * @return
 * @date 2018-07-05 13:14
 * @update
 */
public class ButtonTestActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_confirm)
    Button btn_confirm;
    List<CheckBox>  checkBoxs = new ArrayList<>();
    @BindView(R.id.sk_size)
    SeekBar sk_size;
    @BindView(R.id.sk_rotat)
    SeekBar sk_rotat;
    @BindView(R.id.img_test)
    ImageView img_test;
    @BindView(R.id.txt_image)
    TextView txt_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("testActivit","------------------------------activiti创建");
        super.onCreate(savedInstanceState);
        String[] strs = new String[]{"是学生吗？","是老师吗？","是小菜吗？"};

        View view = getLayoutInflater().inflate(R.layout.activity_buttontest, null);
        LinearLayout ll = view.findViewById(R.id.testFor);
        for(int i = 0;i<strs.length;i++){
            CheckBox cb = (CheckBox) getLayoutInflater().inflate(R.layout.checkbox,null);
            checkBoxs.add(cb);
            checkBoxs.get(i).setText(strs[i]);
            ll.addView(cb);
        }

        setContentView(view);
        ButterKnife.bind(this);

        btn_confirm.setOnClickListener(this);

        final  int minWith = 80;

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        sk_size.setMax(dm.widthPixels-minWith);

        SeekBar.OnSeekBarChangeListener oscl = new  SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekBar.getId() == R.id.sk_size){
                    int newWidth = progress + minWith;
                    int newHeight = (int) (newWidth);
                    img_test.setLayoutParams(new LinearLayout.LayoutParams(newWidth,newHeight));
                    txt_image.setText("图像宽度："+newWidth +"图像高度："+newHeight);
                }else if(seekBar.getId() == R.id.sk_rotat){
                    Bitmap bp = ((BitmapDrawable)getResources().getDrawable(R.drawable.image)).getBitmap();
                    Matrix matrix = img_test.getMatrix();
                    matrix.setRotate(progress);
                    bp = Bitmap.createBitmap(bp,0,0,bp.getWidth(),bp.getHeight(),matrix,true);
                    img_test.setImageBitmap(bp);
                    txt_image.setText("图像旋转"+progress+"度");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        sk_size.setOnSeekBarChangeListener(oscl);
        sk_rotat.setOnSeekBarChangeListener(oscl);
    }



    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_confirm :
                String s = "";
                for(CheckBox cb:checkBoxs){
                    if(cb.isChecked()){
                        s += cb.getText() + "\n";
                    }
                }
                if ("".equals(s)) {
                    s = "请选择";
                }
                new AlertDialog.Builder(this).setMessage(s).setPositiveButton("关闭",null).show();
                break;

            default:
                break;

        }
    }


}
