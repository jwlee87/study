package kr.co.mlec.lecture;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    private Switch switchBtn;
    private ToggleButton toggleBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchBtn = (Switch)findViewById(R.id.switchBtn);
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                Toast.makeText(
                        getApplicationContext(),
                        isCheck ? "체크 상태" : "체크해제 상태",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        toggleBtn = (ToggleButton) findViewById(R.id.toggleBtn);
        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                Toast.makeText(
                        getApplicationContext(),
                        isCheck ? "토글 체크 상태" : "토글 체크해제 상태",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }


}
