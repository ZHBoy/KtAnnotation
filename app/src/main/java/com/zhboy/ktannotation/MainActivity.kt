package com.zhboy.ktannotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //测试注解
        //参考：https://www.jianshu.com/p/2bec8f5a3afd
        testAnnotation()
    }
}