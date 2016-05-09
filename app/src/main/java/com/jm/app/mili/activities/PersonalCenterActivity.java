package com.jm.app.mili.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.jm.app.mili.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//个人中心
@ContentView(R.layout.activity_personal_center)
public class PersonalCenterActivity extends AppCompatActivity implements View.OnClickListener {
    @ViewInject(R.id.llAvatar)
    private Dialog dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llAvatar:
                View view = getLayoutInflater().inflate(R.layout.dialog_xc,
                        null);
                dialog1 = new Dialog(this);
                dialog1.setContentView(view, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Window window = dialog1.getWindow();
                WindowManager.LayoutParams wl = window.getAttributes();
                wl.x = 0;
                wl.y = getWindowManager().getDefaultDisplay().getHeight();
                // 以下这两句是为了保证按钮可以水平满屏
                wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
                wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                // 设置显示位置
                dialog1.onWindowAttributesChanged(wl);
                // 设置点击外围解散
                dialog1.setCanceledOnTouchOutside(true);
                dialog1.show();
                break;


            default:
                break;
        }
    }
}
