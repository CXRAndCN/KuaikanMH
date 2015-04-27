package com.example.administrator.kuaikanmh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.administrator.kuaikanmh.fragment.FondFragment;
import com.example.administrator.kuaikanmh.fragment.PersonFragment;
import com.example.administrator.kuaikanmh.fragment.RecommentFragment;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用推荐fragment
        showFragment(new RecommentFragment());
        rg= ((RadioGroup) findViewById(R.id.rg));
        rg.setOnCheckedChangeListener(this);
    }

    //打开fragment页面的方法
    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_recommend:
                showFragment(new RecommentFragment());
                break;
            case R.id.rb_found:
                showFragment(new FondFragment());
                break;
            case R.id.rb_personal:
                showFragment(new PersonFragment());
                break;
        }
    }
}
