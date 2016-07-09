package com.yztc.myliteorm;

import android.support.annotation.NonNull;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * 用注解的方式生成表
 * Created by Administrator on 2016/7/9.
 */
@Table(value = "student")
public class Stundet {
    @PrimaryKey(value = AssignType.AUTO_INCREMENT)
    @NonNull
    private long id;
    @Column(value = "name")
    @NonNull
    private String name;
    @Column(value = "age")
    @NonNull
    private String age;
    @Column(value = "sex")
    @NonNull
    private String sex;

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getAge() {
        return age;
    }

    public void setAge(@NonNull String age) {
        this.age = age;
    }

    @NonNull
    public String getSex() {
        return sex;
    }

    public void setSex(@NonNull String sex) {
        this.sex = sex;
    }

    public Stundet(@NonNull String name, @NonNull String age, @NonNull String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Stundet() {
    }

    public Stundet(@NonNull long id, @NonNull String name, @NonNull String age, @NonNull String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Stundet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
