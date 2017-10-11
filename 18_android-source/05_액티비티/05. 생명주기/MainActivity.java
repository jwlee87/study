package kr.co.mlec.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextBtn = (Button)findViewById(R.id.btn1);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubActivity1.class);
                startActivity(i);
            }
        });
        Log.d("lifecycle", "MainActivity -> onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "MainActivity -> onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "MainActivity -> onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "MainActivity -> onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "MainActivity -> onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "MainActivity -> onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "MainActivity -> onStop");
    }
}