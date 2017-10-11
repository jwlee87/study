package kr.co.mlec.bit90;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProcessActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process);

        Intent intent = getIntent();
        String comm = intent.getStringExtra("comm");


        int imgId = R.drawable.kara_1;
        if (comm.equals("movie")) imgId = R.drawable.sunny;

        ImageView img = (ImageView)findViewById(R.id.img);
        img.setImageResource(imgId);

        Button exitBtn = (Button)findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
