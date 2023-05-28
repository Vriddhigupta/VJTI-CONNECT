package com.example.vjti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    TextView showPopupBtn;
    Button closePopupBtn;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;

    Button btn_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        showPopupBtn = (TextView) findViewById(R.id.text_btn_open_popup);
        linearLayout1 = (LinearLayout) findViewById(R.id.linear_layout_login);

        btn_to_home = findViewById(R.id.login_to_home_btn);

        //popup
        showPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file

                LayoutInflater layoutInflater = (LayoutInflater) LoginActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup_to_register,null);

                closePopupBtn = (Button) customView.findViewById(R.id.btn_close_popup);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 0, 0);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                View container = (View) popupWindow.getContentView().getParent();
                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
// add flag
                p.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                p.dimAmount = 0.3f;


                //close the popup window on button click
                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });



        //intent to home
        btn_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,dashboard.class);
                startActivity(intent);            }
        });

    }
}