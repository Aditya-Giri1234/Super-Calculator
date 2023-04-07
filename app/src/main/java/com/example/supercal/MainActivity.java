package com.example.supercal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView cal, show,logo;
    Button ac, del, per, add, sub, mul, div, equal, d0, zero, point, one, two, three, four, five, six, seven, eight, nine;
    String result;
    int gl;
    boolean switching = false;
    ImageView dark,appIcon;
    boolean dark_mode;
    LinearLayout zeroth_l,first_l,second_l,third_l,fourth_l,fifth_l,sixth_l,seventh_l;
    Window window;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        window=getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.black));
        window.setNavigationBarColor(getResources().getColor(R.color.black));

        zeroth_l=findViewById(R.id.zeroth_l);
        first_l=findViewById(R.id.first_l);
        second_l=findViewById(R.id.second_l);
        third_l=findViewById(R.id.third_l);
        fourth_l=findViewById(R.id.fourth_l);
        fifth_l=findViewById(R.id.fifth_l);
        sixth_l=findViewById(R.id.sixth_l);
        seventh_l=findViewById(R.id.seventh_l);
        cal = findViewById(R.id.cal);
        show = findViewById(R.id.show);
        logo = findViewById(R.id.logo);
        appIcon=findViewById(R.id.appIcon);
        ac = findViewById(R.id.ac);
        del = findViewById(R.id.del);
        per = findViewById(R.id.per);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        d0 = findViewById(R.id.d0);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equal);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        gl = cal.getText().length();
        dark=findViewById(R.id.dark);

        SharedPreferences sp=getSharedPreferences("Dark Checking", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        dark_mode=sp.getBoolean("dark_mode",true);

        
        if(!dark_mode){
            dark.setImageResource(R.drawable.light);
            window.setStatusBarColor(getResources().getColor(R.color.white));
            window.setNavigationBarColor(getResources().getColor(R.color.white));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }


            zeroth_l.setBackgroundColor(Color.WHITE);
            cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
            show.setBackground(getResources().getDrawable(R.drawable.light_show));
            cal.setTextColor(Color.BLACK);
            show.setTextColor(Color.BLACK);
            // change background color
            ac.setBackgroundResource(R.drawable.light_r);
            equal.setBackgroundResource(R.drawable.light_g);
            del.setBackgroundResource(R.drawable.white_border_main);
            per.setBackgroundResource(R.drawable.white_border_main);
            add.setBackgroundResource(R.drawable.white_border_main);
            sub.setBackgroundResource(R.drawable.white_border_main);
            mul.setBackgroundResource(R.drawable.white_border_main);
            div.setBackgroundResource(R.drawable.white_border_main);

            d0.setBackgroundResource(R.drawable.white_border_number);
            zero.setBackgroundResource(R.drawable.white_border_number);
            point.setBackgroundResource(R.drawable.white_border_number);
            one.setBackgroundResource(R.drawable.white_border_number);
            two.setBackgroundResource(R.drawable.white_border_number);
            three.setBackgroundResource(R.drawable.white_border_number);
            four.setBackgroundResource(R.drawable.white_border_number);
            five.setBackgroundResource(R.drawable.white_border_number);
            six.setBackgroundResource(R.drawable.white_border_number);
            seven.setBackgroundResource(R.drawable.white_border_number);
            eight.setBackgroundResource(R.drawable.white_border_number);
            nine.setBackgroundResource(R.drawable.white_border_number);

            //change text color
            logo.setTextColor(getResources().getColor(R.color.light_stroke));
            ac.setTextColor(Color.BLACK);
            del.setTextColor(Color.BLACK);
            per.setTextColor(Color.BLACK);
            add.setTextColor(Color.BLACK);
            sub.setTextColor(Color.BLACK);
            mul.setTextColor(Color.BLACK);
            div.setTextColor(Color.BLACK);
            equal.setTextColor(Color.BLACK);
            d0.setTextColor(Color.BLACK);
            zero.setTextColor(Color.BLACK);
            point.setTextColor(Color.BLACK);
            one.setTextColor(Color.BLACK);
            two.setTextColor(Color.BLACK);
            three.setTextColor(Color.BLACK);
            four.setTextColor(Color.BLACK);
            five.setTextColor(Color.BLACK);
            six.setTextColor(Color.BLACK);
            seven.setTextColor(Color.BLACK);
            eight.setTextColor(Color.BLACK);
            nine.setTextColor(Color.BLACK);
        }
        else{
            dark.setImageResource(R.drawable.dark);
            window.setStatusBarColor(getResources().getColor(R.color.black));
            window.setNavigationBarColor(getResources().getColor(R.color.black));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            zeroth_l.setBackgroundColor(Color.BLACK);

            cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
            show.setBackground(getResources().getDrawable(R.drawable.black_show));
            cal.setTextColor(Color.WHITE);
            show.setTextColor(Color.WHITE);

            // change background color
            ac.setBackgroundResource(R.drawable.black_r);
            equal.setBackgroundResource(R.drawable.black_g);
            del.setBackgroundResource(R.drawable.black_border_main);
            per.setBackgroundResource(R.drawable.black_border_main);
            add.setBackgroundResource(R.drawable.black_border_main);
            sub.setBackgroundResource(R.drawable.black_border_main);
            mul.setBackgroundResource(R.drawable.black_border_main);
            div.setBackgroundResource(R.drawable.black_border_main);




            d0.setBackgroundResource(R.drawable.black_border_number);
            zero.setBackgroundResource(R.drawable.black_border_number);
            point.setBackgroundResource(R.drawable.black_border_number);
            one.setBackgroundResource(R.drawable.black_border_number);
            two.setBackgroundResource(R.drawable.black_border_number);
            three.setBackgroundResource(R.drawable.black_border_number);
            four.setBackgroundResource(R.drawable.black_border_number);
            five.setBackgroundResource(R.drawable.black_border_number);
            six.setBackgroundResource(R.drawable.black_border_number);
            seven.setBackgroundResource(R.drawable.black_border_number);
            eight.setBackgroundResource(R.drawable.black_border_number);
            nine.setBackgroundResource(R.drawable.black_border_number);

            //change text color
            logo.setTextColor(getResources().getColor(R.color.black_stroke));

            ac.setTextColor(Color.WHITE);
            del.setTextColor(Color.WHITE);
            per.setTextColor(Color.WHITE);
            add.setTextColor(Color.WHITE);
            sub.setTextColor(Color.WHITE);
            mul.setTextColor(Color.WHITE);
            div.setTextColor(Color.WHITE);
            equal.setTextColor(Color.WHITE);

            d0.setTextColor(Color.WHITE);
            zero.setTextColor(Color.WHITE);
            point.setTextColor(Color.WHITE);
            one.setTextColor(Color.WHITE);
            two.setTextColor(Color.WHITE);
            three.setTextColor(Color.WHITE);
            four.setTextColor(Color.WHITE);
            five.setTextColor(Color.WHITE);
            six.setTextColor(Color.WHITE);
            seven.setTextColor(Color.WHITE);
            eight.setTextColor(Color.WHITE);
            nine.setTextColor(Color.WHITE);
        }
        dark.setOnClickListener(v->{
            if(dark_mode) {
                dark_mode=false;
                editor.putBoolean("dark_mode", false);
                editor.apply();
                dark.setImageResource(R.drawable.light);
                    window.setStatusBarColor(getResources().getColor(R.color.white));
                    window.setNavigationBarColor(getResources().getColor(R.color.white));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }


                zeroth_l.setBackgroundColor(Color.WHITE);
                cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                show.setBackground(getResources().getDrawable(R.drawable.light_show));
                cal.setTextColor(Color.BLACK);
                show.setTextColor(Color.BLACK);
                // change background color
                ac.setBackgroundResource(R.drawable.light_r);
                equal.setBackgroundResource(R.drawable.light_g);
                del.setBackgroundResource(R.drawable.white_border_main);
                per.setBackgroundResource(R.drawable.white_border_main);
                add.setBackgroundResource(R.drawable.white_border_main);
                sub.setBackgroundResource(R.drawable.white_border_main);
                mul.setBackgroundResource(R.drawable.white_border_main);
                div.setBackgroundResource(R.drawable.white_border_main);

                d0.setBackgroundResource(R.drawable.white_border_number);
                zero.setBackgroundResource(R.drawable.white_border_number);
                point.setBackgroundResource(R.drawable.white_border_number);
                one.setBackgroundResource(R.drawable.white_border_number);
                two.setBackgroundResource(R.drawable.white_border_number);
                three.setBackgroundResource(R.drawable.white_border_number);
                four.setBackgroundResource(R.drawable.white_border_number);
                five.setBackgroundResource(R.drawable.white_border_number);
                six.setBackgroundResource(R.drawable.white_border_number);
                seven.setBackgroundResource(R.drawable.white_border_number);
                eight.setBackgroundResource(R.drawable.white_border_number);
                nine.setBackgroundResource(R.drawable.white_border_number);

                //change text color
              logo.setTextColor(getResources().getColor(R.color.light_stroke));
              ac.setTextColor(Color.BLACK);
              del.setTextColor(Color.BLACK);
              per.setTextColor(Color.BLACK);
              add.setTextColor(Color.BLACK);
              sub.setTextColor(Color.BLACK);
              mul.setTextColor(Color.BLACK);
              div.setTextColor(Color.BLACK);
              equal.setTextColor(Color.BLACK);
              d0.setTextColor(Color.BLACK);
              zero.setTextColor(Color.BLACK);
              point.setTextColor(Color.BLACK);
              one.setTextColor(Color.BLACK);
              two.setTextColor(Color.BLACK);
              three.setTextColor(Color.BLACK);
              four.setTextColor(Color.BLACK);
              five.setTextColor(Color.BLACK);
              six.setTextColor(Color.BLACK);
              seven.setTextColor(Color.BLACK);
              eight.setTextColor(Color.BLACK);
              nine.setTextColor(Color.BLACK);
            }
            else{
                dark_mode=true;
                editor.putBoolean("dark_mode", true);
                editor.apply();
                dark.setImageResource(R.drawable.dark);
                window.setStatusBarColor(getResources().getColor(R.color.black));
                window.setNavigationBarColor(getResources().getColor(R.color.black));
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                zeroth_l.setBackgroundColor(Color.BLACK);

                cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                show.setBackground(getResources().getDrawable(R.drawable.black_show));
                cal.setTextColor(Color.WHITE);
                show.setTextColor(Color.WHITE);

                // change background color
                ac.setBackgroundResource(R.drawable.black_r);
                equal.setBackgroundResource(R.drawable.black_g);
                del.setBackgroundResource(R.drawable.black_border_main);
                per.setBackgroundResource(R.drawable.black_border_main);
                add.setBackgroundResource(R.drawable.black_border_main);
                sub.setBackgroundResource(R.drawable.black_border_main);
                mul.setBackgroundResource(R.drawable.black_border_main);
                div.setBackgroundResource(R.drawable.black_border_main);




                d0.setBackgroundResource(R.drawable.black_border_number);
                zero.setBackgroundResource(R.drawable.black_border_number);
                point.setBackgroundResource(R.drawable.black_border_number);
                one.setBackgroundResource(R.drawable.black_border_number);
                two.setBackgroundResource(R.drawable.black_border_number);
                three.setBackgroundResource(R.drawable.black_border_number);
                four.setBackgroundResource(R.drawable.black_border_number);
                five.setBackgroundResource(R.drawable.black_border_number);
                six.setBackgroundResource(R.drawable.black_border_number);
                seven.setBackgroundResource(R.drawable.black_border_number);
                eight.setBackgroundResource(R.drawable.black_border_number);
                nine.setBackgroundResource(R.drawable.black_border_number);

                //change text color
                logo.setTextColor(getResources().getColor(R.color.black_stroke));

                ac.setTextColor(Color.WHITE);
                del.setTextColor(Color.WHITE);
                per.setTextColor(Color.WHITE);
                add.setTextColor(Color.WHITE);
                sub.setTextColor(Color.WHITE);
                mul.setTextColor(Color.WHITE);
                div.setTextColor(Color.WHITE);
                equal.setTextColor(Color.WHITE);

                d0.setTextColor(Color.WHITE);
                zero.setTextColor(Color.WHITE);
                point.setTextColor(Color.WHITE);
                one.setTextColor(Color.WHITE);
                two.setTextColor(Color.WHITE);
                three.setTextColor(Color.WHITE);
                four.setTextColor(Color.WHITE);
                five.setTextColor(Color.WHITE);
                six.setTextColor(Color.WHITE);
                seven.setTextColor(Color.WHITE);
                eight.setTextColor(Color.WHITE);
                nine.setTextColor(Color.WHITE);
            }
        });


        d0.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText(R.string.d0);
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("00");
                }
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
            }

        });
        zero.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("0");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("0");
                }
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
            }

        });
        point.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText(".");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append(".");
                }
            } else {
                cal.setText("0");
                cal.setText(".");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        one.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {

                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("1");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("1");
                }
            } else {
                cal.setText("1");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        two.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("2");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("2");
                }
            } else {
                cal.setText("2");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        three.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("3");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("3");
                }
            } else {
                cal.setText("3");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        four.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("4");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("4");
                }
            } else {
                cal.setText("4");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        five.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("5");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("5");
                }
            } else {
                cal.setText("5");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        six.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;

                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("6");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("6");
                }
            } else {
                cal.setText("6");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        seven.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;
                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("7");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("7");
                }
            } else {
                cal.setText("7");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        eight.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;
                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("8");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("8");
                }
            } else {
                cal.setText("8");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        nine.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;
                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setAlpha(.8f);
                    show.setTextSize(30f);
                    cal.setText("9");
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    cal.append("9");
                }
            } else {
                cal.setText("9");
            }
            result = MainActivity.calculate(cal.getText().toString());
            show.setText(" = ");
            show.append(result);
        });
        ac.setOnClickListener(v -> {
            cal.setText("");
            show.setText("0");
            if (switching) {
                cal.setTextSize(40f);
                cal.setAlpha(1f);
                show.setTextSize(30f);
                show.setAlpha(.8f);
                if(dark_mode) {
                    cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                    show.setBackground(getResources().getDrawable(R.drawable.black_show));
                }else{
                    cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                    show.setBackground(getResources().getDrawable(R.drawable.light_show));
                }
            }
        });
        del.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (!switching) {
                    int length = cal.getText().length();
                    String support = cal.getText().toString();
                    StringBuilder delString = new StringBuilder();
                    for (int i = 0; i < length - 1; i++) {
                        delString.append(support.charAt(i));
                    }
                    cal.setText(delString.toString());
                    result = MainActivity.calculate(delString.toString());
                    show.setText(" = ");
                    show.append(result);
                }
            } else {
                cal.setText("");
                show.setText("0");
            }
        });
        per.setOnClickListener(v -> {
            if (!cal.getText().toString().equals("")) {
                if (!switching) {
                    String support = cal.getText().toString();
                    String result1, result2;
                    int index = 0;
                    for (int i = support.length() - 1; i >= 0; i--) {
                        if (support.charAt(i) == '+' || support.charAt(i) == '-' || support.charAt(i) == 'x' || support.charAt(i) == '÷') {
                            index = i;
                            break;
                        }
                    }

                    if(cal.getText().toString().length()!=index+1){
                     double value = Double.parseDouble(support.substring(index + 1));


                    if (support.charAt(index) == '+' || support.charAt(index) == '-') {
                        try {
                            if (!cal.getText().toString().contains("NaN") && (!cal.getText().toString().contains("E-4"))) {
                                result1 = MainActivity.calculate(support.substring(0, index));
                                value = Double.parseDouble(result1) * value / 100;
                                cal.setText(support.substring(0, index));
                                cal.append(Character.toString(support.charAt(index)));
                                cal.append(Double.toString(value));
                                support = result1 + support.charAt(index) + value;
                                result = MainActivity.calculate(support);
                                show.setText(" = ");
                                show.append(result);
                            } else {
                                cal.setText(cal.getText().toString().replace("E-4", "E-NaN"));
                            }
                        } catch (NumberFormatException ex) {
                            if (!cal.getText().toString().contains("NaN")) {
                                cal.setText(support.substring(0, index));
                                cal.append(Character.toString(support.charAt(index)));
                                cal.append("NaN");
                                cal.setText(support.substring(0, index));
                                cal.append(Character.toString(support.charAt(index)));
                                cal.append("NaN");
                            }
                        }


                    } // end if for + and -
                    else {
                        if (support.charAt(index) == 'x' || support.charAt(index) == '÷') {
                            try {
                                if (!cal.getText().toString().contains("NaN")) {
                                    result2 = MainActivity.calculate(support.substring(0, index));
                                    value = value / 100;
                                    cal.setText(support.substring(0, index));
                                    cal.append(Character.toString(support.charAt(index)));
                                    cal.append(Double.toString(value));
                                    support = result2 + support.charAt(index) + value;
                                    result = MainActivity.calculate(support);
                                    show.setText(" = ");
                                    show.append(result);
                                } else {
                                    cal.setText(cal.getText().toString().replace("E-4", "E-NaN"));
                                }
                            } catch (NumberFormatException ex) {
                                if (!cal.getText().toString().contains("NaN")) {
                                    cal.setText(support.substring(0, index));
                                    cal.append(Character.toString(support.charAt(index)));
                                    cal.append("NaN");
                                }
                            }

                        }  // end if for * and /

                        else {
                            result = MainActivity.calculate(cal.getText().toString());
                            result = Double.toString(Double.parseDouble(result) / 100);
                            cal.setText(result);
                            show.setText(" = ");
                            show.append(result);
                        }
                    }//first if else
                    }//check condition for value
                }// end if for not  switching
                else {     // for switching than this code run
                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setTextSize(30f);
                    show.setAlpha(.8f);
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                    result = MainActivity.calculate(cal.getText().toString());
                    result = Double.toString(Double.parseDouble(result) / 100);
                    cal.setText(result);
                    show.setText(" = ");
                    show.append(result);
                }

            } //end  if for when not empty textview

        });
        add.setOnClickListener(v -> {
            if(!cal.getText().toString().equals("")) {
                if (switching) {
                    switching = false;
                    cal.setText(result);
                    cal.append("+");
                    result = MainActivity.calculate(cal.getText().toString());
                    show.setText(" = ");
                    show.append(result);
                    cal.setTextSize(40f);
                    cal.setAlpha(1f);
                    show.setTextSize(30f);
                    show.setAlpha(.8f);
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
                } else {
                    if (cal.getText().toString().charAt(cal.getText().length() - 1) == '+' || cal.getText().toString().charAt(cal.getText().length() - 1) == '-' || cal.getText().toString().charAt(cal.getText().length() - 1) == 'x' || cal.getText().toString().charAt(cal.getText().length() - 1) == '÷') {
                        cal.setText(cal.getText().toString().substring(0, cal.getText().toString().length() - 1));
                    }
                    cal.append("+");
                    result = MainActivity.calculate(cal.getText().toString());
                    show.setText(" = ");
                    show.append(result);
                }
            }
            else{
                cal.setText("0");
                cal.append("+");
            }

        });
        sub.setOnClickListener(v -> {
            if(!cal.getText().toString().equals("")) {

                if (switching) {
                switching = false;

                cal.setText(result);
                cal.append("-");
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
                cal.setTextSize(40f);
                cal.setAlpha(1f);
                show.setTextSize(30f);
                show.setAlpha(.8f);
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
            } else {
                if (cal.getText().toString().charAt(cal.getText().length() - 1) == '+' || cal.getText().toString().charAt(cal.getText().length() - 1) == '-' || cal.getText().toString().charAt(cal.getText().length() - 1) == 'x' || cal.getText().toString().charAt(cal.getText().length() - 1) == '÷') {
                    cal.setText(cal.getText().toString().substring(0, cal.getText().toString().length() - 1));
                }
                cal.append("-");
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
            }
        }
              else{
                cal.setText("0");
                cal.append("-");
            }
        });
        mul.setOnClickListener(v -> {
            if(!cal.getText().toString().equals("")) {

                if (switching) {
                switching = false;

                cal.setText(result);
                cal.append("x");
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
                cal.setTextSize(40f);
                cal.setAlpha(1f);
                show.setTextSize(30f);
                show.setAlpha(.8f);
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
            } else {
                if (cal.getText().toString().charAt(cal.getText().length() - 1) == '+' || cal.getText().toString().charAt(cal.getText().length() - 1) == '-' || cal.getText().toString().charAt(cal.getText().length() - 1) == 'x' || cal.getText().toString().charAt(cal.getText().length() - 1) == '÷') {
                    cal.setText(cal.getText().toString().substring(0, cal.getText().toString().length() - 1));
                }
                cal.append("x");
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
            }
        }
              else{
            cal.setText("0");
            cal.append("x");
        }
        });
        div.setOnClickListener(v -> {
            if(!cal.getText().toString().equals("")) {

                if (switching) {
                switching = false;

                cal.setText(result);
                cal.append("÷");
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
                cal.setTextSize(40f);
                cal.setAlpha(1f);
                show.setTextSize(30f);
                show.setAlpha(.8f);
                    if(dark_mode) {
                        cal.setBackground(getResources().getDrawable(R.drawable.black_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.black_show));
                    }else{
                        cal.setBackground(getResources().getDrawable(R.drawable.light_cal_border));
                        show.setBackground(getResources().getDrawable(R.drawable.light_show));
                    }
            } else {
                if (cal.getText().toString().charAt(cal.getText().length() - 1) == '+' || cal.getText().toString().charAt(cal.getText().length() - 1) == '-' || cal.getText().toString().charAt(cal.getText().length() - 1) == 'x' || cal.getText().toString().charAt(cal.getText().length() - 1) == '÷') {
                    cal.setText(cal.getText().toString().substring(0, cal.getText().toString().length() - 1));
                }
                cal.append("÷");
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
            }
    }
              else{
        cal.setText("0");
        cal.append("÷");
    }
        });
        equal.setOnClickListener(v -> {
            if (!cal.getText().toString().contains("NaN")) {

                switching = true;
                cal.setAlpha(.8f);
                cal.setTextSize(30);
                show.setTextSize(40);
                show.setAlpha(1f);
                result = MainActivity.calculate(cal.getText().toString());
                show.setText(" = ");
                show.append(result);
            } else {
                switching = true;
                cal.setAlpha(.8f);
                cal.setTextSize(30);
                show.setTextSize(40);
                show.setAlpha(1f);
                show.setText(" = ");
                show.append("Error");
            }
            if(dark_mode) {
                show.setBackground(getResources().getDrawable(R.drawable.black_show_border));
                cal.setBackground(getResources().getDrawable(R.drawable.black_cal));
            }
            else{
                show.setBackground(getResources().getDrawable(R.drawable.light_show_border));
                cal.setBackground(getResources().getDrawable(R.drawable.light_cal));
            }
        });
    }


    public static String calculate(String value) {
        try {
            String support;
            if (value.equals("")) {
                value += "0";
            }
            if (value.charAt(value.length() - 1) == '+' || value.charAt(value.length() - 1) == '-' || value.charAt(value.length() - 1) == 'x' || value.charAt(value.length() - 1) == '÷') {
                value = value.substring(0, value.length() - 1);
            }
            value = value.replaceAll("x", "*");
            value = value.replaceAll("÷", "/");
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("javascript");
                support = Double.toString((double) engine.eval(value));
                int length = support.length();
                if ((support.charAt(length - 1) == '0') && (support.charAt(length - 2) == '.')) {
                    support = support.substring(0, support.length() - 2);
                }
                return support;

        } catch (ScriptException e) {
            e.printStackTrace();
            return "";
        }
    }
}
