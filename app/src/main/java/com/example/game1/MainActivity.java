package com.example.game1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("About")    //设置标题
                .setMessage("开发者：曦微（QQ 2273805195）")  //设置提醒的信息
                .setIcon(R.mipmap.yao)    //设置图标
                .setPositiveButton("已知晓",null) //添加确定按钮
                //.setNegativeButton("取消",null) //添加取消按钮
                .create();
        dialog.show();
    }


    public void gofirst(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, firstActivity.class);
        startActivity(intent);
    }
    public void gosecond(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, secondActivity.class);
        startActivity(intent);
    }
}