package kr.co.mlec.bigdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MinusActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        Intent rsltIntent = new Intent(getApplicationContext(), MainActivity.class);
        rsltIntent.putExtra("calResult", num1 - num2);
        setResult(200, rsltIntent);

        finish();
    }
}






