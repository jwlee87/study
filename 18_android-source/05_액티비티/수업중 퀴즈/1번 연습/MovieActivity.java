package kr.co.mlec.bit90;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MovieActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        Button exitBtn = (Button)findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현재 실행중인 액티비티 종료
                finish();
            }
        });
    }
}
