package com.jm.app.mili.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jm.app.mili.MainActivity;
import com.jm.app.mili.R;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 登陆界面
 */
public class LogInAcitivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ed_ID, ed_paword;//账号密码
    private TextView tv_enroll, tv_wj;//注册账号忘记密码
    private Button tv_go;//登陆
    private LinearLayout tv_qq, tv_wx;//QQ登陆//微信
    //声明并初始化请求码
    private static final int  REQUST_CODE1 = 4;
    private static final int  REQUST_CODE2 = 5;
    private static final int  REQUST_CODE3 = 6;
    private static final int  REQUST_CODE4 = 7;
    private static final int  REQUST_CODE5 = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_acitivity);
        ed_ID = (EditText) findViewById(R.id.ed_ID);
        ed_paword = (EditText) findViewById(R.id.ed_paword);
        tv_enroll = (TextView) findViewById(R.id.tv_enroll);
        tv_wj = (TextView) findViewById(R.id.tv_wj);
        tv_go = (Button) findViewById(R.id.tv_go);
        tv_qq = (LinearLayout) findViewById(R.id.tv_qq);
        tv_wx = (LinearLayout) findViewById(R.id.tv_wx);

        tv_enroll.setOnClickListener(this);
        tv_wj.setOnClickListener(this);
        tv_go.setOnClickListener(this);
        tv_qq.setOnClickListener(this);
        tv_wx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_go:
                //点击登录，进入商城界面
                String user = ed_ID.getText().toString().trim();
                String pwd = ed_paword.getText().toString().trim();
                if(user.equals("")||pwd.equals("")){
                    Toast.makeText(this, "用户名或密码不能为空！！", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent1 = new Intent(LogInAcitivity.this,MainActivity.class);
                    startActivityForResult(intent1, REQUST_CODE1);
                }

                break;
            case R.id.tv_enroll:
                //点击注册，进入注册界面
                Intent intent2 = new Intent(LogInAcitivity.this,Register_Activity.class);
                startActivityForResult(intent2, REQUST_CODE2);
                break;
            case R.id.tv_wj:
                //点击注册，进入忘记密码
                Intent intent3 = new Intent(LogInAcitivity.this,ChangePasswordActivity.class);
                startActivityForResult(intent3, REQUST_CODE3);
                break;
            case R.id.tv_qq:
                //点击注册，进入QQ登陆
//                Intent intent4 = new Intent(LogInAcitivity.this,SignActivity.class);
//                startActivityForResult(intent4, REQUST_CODE4);
                break;
            case R.id.tv_wx:
                //点击注册，进入微信登陆
//                Intent intent5 = new Intent(LogInAcitivity.this,SignActivity.class);
//                startActivityForResult(intent5, REQUST_CODE5);
                break;
            default:
                break;
        }
    }
}
