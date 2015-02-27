
package com.example.bittt2;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class Main extends Activity {

    private ViewPager viewPager;
    private MyLinePoints linePoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amain);
      
    }
    
    //
    public void  bt_function1(View view){
        startActivity(new Intent(this, Activity_1.class));
    }
    
    
    public void  bt_function2(View view){
        startActivity(new Intent(this, Activity_2.class));
    }
    
    public void  bt_function3(View view){
        startActivity(new Intent(this, Activity_3.class));
    }
    
    
    public void  bt_function4(View view){
        startActivity(new Intent(this, Activity_4.class));
    }
    
    public void  bt_function5(View view){
        startActivity(new Intent(this, Activity_5.class));
    }
    
    
    
    public void  bt_function6(View view){
        startActivity(new Intent(this, Activity_6.class));
    }
    
    public void  bt_function7(View view){
        startActivity(new Intent(this, Activity_7.class));
    }
}
