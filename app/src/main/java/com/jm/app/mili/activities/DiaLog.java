package com.jm.app.mili.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jm.app.mili.R;


public class DiaLog extends Activity implements View.OnClickListener {
    private EditText person_page_car_item_num;
    private ImageView back;
    private Button btn_yes, fivw, ten, fifteen, twenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_log);
        person_page_car_item_num = (EditText) findViewById(R.id.person_page_car_item_num);
        back = (ImageView) findViewById(R.id.back);
        btn_yes = (Button) findViewById(R.id.btn_yes);
        fivw = (Button) findViewById(R.id.fivw);
        ten = (Button) findViewById(R.id.ten);
        fifteen = (Button) findViewById(R.id.fifteen);
        twenty = (Button) findViewById(R.id.twenty);
        back.setOnClickListener(this);
        btn_yes.setOnClickListener(this);
        fivw.setOnClickListener(this);
        ten.setOnClickListener(this);
        fifteen.setOnClickListener(this);
        twenty.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.btn_yes:
                String yes = person_page_car_item_num.getText().toString().trim();
                if (yes.equals("")) {
                    Toast.makeText(this, "请输入正确参数", Toast.LENGTH_LONG).show();
                } else {

                }
                break;
            case R.id.fivw:
                person_page_car_item_num.setText("5");
                break;
            case R.id.ten:
                person_page_car_item_num.setText("10");
                break;
            case R.id.fifteen:
                person_page_car_item_num.setText("15");
                break;
            case R.id.twenty:
                person_page_car_item_num.setText("20");
                break;

            default:
                break;
        }
    }
}
