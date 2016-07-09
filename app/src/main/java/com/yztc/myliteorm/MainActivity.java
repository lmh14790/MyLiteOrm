package com.yztc.myliteorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.litesuits.orm.LiteOrm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    //创建liteOrm对象 最好定义成全局变量
    LiteOrm liteOrm;
    @InjectView(R.id.insert)
    Button insert;
    @InjectView(R.id.update)
    Button update;
    @InjectView(R.id.select)
    Button select;
    @InjectView(R.id.delete)
    Button delete;
    @InjectView(R.id.show)
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        liteOrm = LiteOrm.newSingleInstance(this, "liteOrm.db");

    }
   //页面增删改查的点击事件
    @OnClick({R.id.insert, R.id.update, R.id.select, R.id.delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert:

                takeTimes(new TakeTime() {
                    @Override
                    public void add() {
                        List<Stundet> students = new ArrayList<>();
                        for (int i = 0; i < 10000; i++) {
                            Stundet stundet = new Stundet("zs" + i, "" + (i % 100), "男");
                            students.add(stundet);
                        }

                        liteOrm.insert(students);

                    }

                    @Override
                    public void select() {

                    }
                },1);

                break;
            case R.id.update:
                break;
            case R.id.select:
                takeTimes(new TakeTime() {
                    @Override
                    public void add() {

                    }

                    @Override
                    public void select() {
                        List<Stundet> stundetList = liteOrm.query(Stundet.class);
                        show.setText(stundetList.toString());
                    }
                }, 2);

                break;
            case R.id.delete:
                break;
        }
    }


    interface TakeTime{
        void add();
        void select();
    }

    //测试增删改查的效率在10000条数据在500-700毫秒之间,经测试10000条数据greenDao效率更高
    private void takeTimes(TakeTime entity,int flage) {
        long time1=System.currentTimeMillis();
        if(flage==1){
            entity.add();
        }else{
            entity.select();
        }
        long time2=System.currentTimeMillis();
        SimpleDateFormat format=new SimpleDateFormat("mm:ss");
        Date date=new Date(time2-time1);
        String time=format.format(date);
        Toast.makeText(this, "花费时间是" + (time2 - time1), Toast.LENGTH_SHORT).show();
    }
}
