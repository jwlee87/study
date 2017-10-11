package kr.co.mlec.lecture;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SubActivity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        Log.d("lifecycle", "SubActivity -> onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "SubActivity -> onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "SubActivity -> onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "SubActivity -> onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "SubActivity -> onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "SubActivity -> onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "SubActivity -> onStop");
    }
}
