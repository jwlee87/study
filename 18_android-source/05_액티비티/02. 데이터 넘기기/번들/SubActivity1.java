package kr.co.mlec.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity1 extends Activity {
    private Button backBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        String name = bundle.getString("name");
        int age  = bundle.getInt("age");

        Toast.makeText(getApplicationContext(), name + "-" + age, Toast.LENGTH_LONG).show();

        backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
