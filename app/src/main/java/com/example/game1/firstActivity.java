package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class firstActivity extends AppCompatActivity {
    int n1=0;
    int n2=0;
    int score=0;
    private TextView show;
    private TextView scoreview;
    public SharedPreferences.Editor editor;
    Random random = new Random();
    String[] list={"剪刀","石头","布"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        show= findViewById(R.id.show);
        scoreview =findViewById(R.id.scoreview);
        //获取数据：
        SharedPreferences read = getSharedPreferences("lock",MODE_PRIVATE);
        int value = read.getInt("code",0);
        score=value;
        scoreview.setText(String.valueOf(score));
        Toast.makeText(getApplicationContext(), "读取成功", Toast.LENGTH_SHORT).show();
        //步骤2-1：创建一个SharedPreferences.Editor接口对象，lock表示要写入的XML文件名，MODE_WORLD_WRITEABLE写操作
        editor = getSharedPreferences("lock",MODE_PRIVATE).edit();
    }
    public void print(String s){
        show.setText(s);
    }
    public void check(String m1){
        int s = random.nextInt(3);//石头击败"剪刀"，赢了！布击败石头，赢了！
        String d=list[s];
        if (m1 == "剪刀" && d=="布") {
            show.setTextColor(Color.GREEN);
            n1+=1;
            print("您的剪刀击败布\n赢了！"+check1(n1,n2));

        }
        else if (m1 == "石头" && d=="剪刀") {
            show.setTextColor(Color.GREEN);
            n1+=1;
            print("您的石头击败剪刀\n赢了！"+check1(n1,n2));
        }
        else if (m1 == "布" && d=="石头") {
            show.setTextColor(Color.GREEN);
            n1+=1;
            print("您的布击败石头\n赢了！"+check1(n1,n2));
        }
        else if (m1 == d) {
            show.setTextColor(Color.BLACK);
            print("平局");
        }
        else{
            show.setTextColor(Color.RED);
            n2+=1;
            print("您的"+m1+"被"+d+"击败"+"\n输了"+check1(n1,n2));

        }

    }
    public String check1(int m, int n) {
        String res = "";
        if (m >= 2) {
            n1 = 0;
            n2 = 0;
            score += 1;
            res = ",您是最后的赢家！！(≧∇≦)ﾉ";
            scoreview.setText(String.valueOf(score));
        } else if (n >= 2) {
            n1 = 0;
            n2 = 0;
            score -= 1;
            res = ",您最终输了@_@";
            scoreview.setText(String.valueOf(score));
        }
            return res;

    }
    public void set(View v){
        editor.putInt("code", score);
        editor.commit();
        Toast.makeText(getApplicationContext(), "存档成功", Toast.LENGTH_SHORT).show();
    }
    public void chx(View v){
        //剪刀
        check("剪刀");
    }

    public void chd(View v){
        //石头
        check("石头");
    }

    public void chc(View v){
        //布
        check("布");
    }
}