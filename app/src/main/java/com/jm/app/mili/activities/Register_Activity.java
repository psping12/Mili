package com.jm.app.mili.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.jm.app.mili.R;

//注册

public class Register_Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText ed_name, ed_pwd;//账号密码
    private Button btn_yes, tv_go;//获取验证码，验证
    private RadioButton rb_dl;//有账号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_safe_testing);
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_pwd = (EditText) findViewById(R.id.ed_pwd);
        btn_yes = (Button) findViewById(R.id.btn_yes);
        tv_go = (Button) findViewById(R.id.tv_go);
        rb_dl = (RadioButton) findViewById(R.id.rb_dl);

        btn_yes.setOnClickListener(this);
        tv_go.setOnClickListener(this);
        rb_dl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                //获取验证码
                String user = ed_name.getText().toString().trim();
                if (user.equals("") ) {
                    Toast.makeText(this, "账号错误请重新输入", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_go:
                //注册成功
                String user1 = ed_name.getText().toString().trim();
                String PWd = ed_pwd.getText().toString().trim();
                if (user1.equals("")||PWd.equals("")){
                    Toast.makeText(this, "账号验证码错误请重新输入", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent2 = new Intent(Register_Activity.this, RegisterYESActivity.class);
                    startActivity(intent2);
                }
                break;
            case R.id.rb_dl:
                //跳转登陆
                Intent intent3 = new Intent(Register_Activity.this, LogInAcitivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
