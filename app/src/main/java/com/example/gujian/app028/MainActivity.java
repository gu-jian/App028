package com.example.gujian.app028;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private static final String[] countriesStr =
            { "怜怜", "莉莉", "妾妾", "娜娜" };
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    Animation myAnimation;


    //test git push
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       //setContentView(R.layout.activity_main);

         /* 载入main.xml Layout */
        setContentView(R.layout.main);

   /*     Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



        /* 以findViewById()取得对象 */
        myTextView = (TextView) findViewById(R.id.myTextView);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countriesStr);
        /* myspinner_dropdown为自定义下拉菜单模式定义在res/layout目录下 */
        adapter.setDropDownViewResource(R.layout.myspinner);

        /* 将ArrayAdapter添加Spinner对象中 */
        mySpinner.setAdapter(adapter);

        /* 将mySpinner添加OnItemSelectedListener */
        mySpinner.setOnItemSelectedListener
                (new Spinner.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected
                            (AdapterView<?> arg0, View arg1, int arg2,
                             long arg3)
                    {
                        /* 将所选mySpinner的值带入myTextView中 */
                        myTextView.setText("您选择的是" + countriesStr[arg2]);
                        /* 将mySpinner显示 */
                        arg0.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0)
                    {
                        // TODO Auto-generated method stub
                        return;
                    }
                });

        /* 取得Animation定义在res/anim目录下 */
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.my_anim);

        /* 将mySpinner添加OnTouchListener */
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
        /* 将mySpinner运行Animation */
                v.startAnimation(myAnimation);
        /* 将mySpinner隐藏 */
                v.setVisibility(View.INVISIBLE);
                return false;
            }

        });

        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                // TODO Auto-generated method stub

                //ddddddcccc
                return;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
