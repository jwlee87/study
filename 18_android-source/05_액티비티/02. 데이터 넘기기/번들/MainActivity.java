package kr.co.mlec.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button callBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callBtn = (Button)findViewById(R.id.callBtn);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity1.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", "홍길동");
                bundle.putInt("age", 22);
                intent.putExtra("data", bundle);

                startActivity(intent);
            }
        });
    }
}