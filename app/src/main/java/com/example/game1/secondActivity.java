package com.example.game1;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;


public class secondActivity extends AppCompatActivity {
    private TextView inputtv;
    private TextView resulttv;
    private ScrollView sc;
    Random random = new Random();
    String[] list={"剪刀","石头","布"};

    class Text {
        String[] list={};
        public void add(String s){
            String[] list0=Arrays.copyOf(list,list.length+1);
            list0[list.length]= s;
            list=list0;
        }
        public String getsting(){

            return Arrays.toString(list).replace(',','\n');
        }
        public void print(TextView v){
            v.setText(getsting());
        }

    }

    public Text intext=new Text();
    public Text outtext=new Text();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inputtv= findViewById(R.id.inputtv);
        resulttv =findViewById(R.id.resulttv);
        sc=findViewById(R.id.inscroll);
    }

    public void chx(View v){
        intext.add("剪刀");
        //intext.add("\n");
        intext.print(inputtv);
        sc.scrollBy(0,66);
    }
    public void chd(View v){
        intext.add("石头");
        //intext.add("\n");
        intext.print(inputtv);
        sc.scrollBy(0,66);
    }
    public void chc(View v){
        intext.add("布");
        //intext.add("\n");
        intext.print(inputtv);
        sc.scrollBy(0,66);

    }

    public void clear(View v){
        intext.list= new String[] {};
        inputtv.setText("😊\n😘");
        outtext.list= new String[] {};
        resulttv.setText("😊\n😘");
    }

    public void start(View v){
        if(intext.list.length>0) {
            //outtext.print(resulttv);
            //int maxindex=intext.list.length-1;
            //int len=maxindex-index;
            int n1 = 0;
            int n2 = 0;
            for (int i = 0; i < intext.list.length; i++) {
                int s = random.nextInt(3);//石头击败"剪刀"，赢了！布击败石头，赢了！
                String d = list[s];
                String m1 = intext.list[i];
                if (m1 == "剪刀" && d == "布") {
                    outtext.add("第" + String.valueOf(i + 1) + "回合: 您的剪刀击败布 赢了！");
                    n1 += 1;
                } else if (m1 == "石头" && d == "剪刀") {
                    outtext.add("第" + (i + 1) + "回合: 您的石头击败剪刀 赢了！");
                    n1 += 1;
                } else if (m1 == "布" && d == "石头") {
                    outtext.add("第" + (i + 1) + "回合: 您的布击败石头 赢了！");
                    n1 += 1;
                } else if (m1 == d) {
                    outtext.add("第" + (i + 1) + "回合: 平局");
                } else {
                    outtext.add("第" + (i + 1) + "回合: 您的" + m1 + "被" + d + "击败" + " 输了");
                    n2 += 1;
                }
                outtext.print(resulttv);
            }
            double p = (double) n1 / intext.list.length * 100;
            outtext.add("您的胜率： "+ p +"%");
            outtext.print(resulttv);
        }
    }
}