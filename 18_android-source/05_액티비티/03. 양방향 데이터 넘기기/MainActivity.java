package kr.co.mlec.bigdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView result;

    private static final int PLUS = 100;
    private static final int MINUS = 200;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        result = (TextView)findViewById(R.id.result);
    }

    public void calActivityCall(View v) {
        switch (v.getId()) {
            case R.id.plus : callActivity(PLUS , PlusActivity.class ); break;
            case R.id.minus: callActivity(MINUS, MinusActivity.class); break;
        }
    }

    void callActivity(int requestCode, Class clz) {
        int num1Val = Integer.parseInt(num1.getText().toString());
        int num2Val = Integer.parseInt(num2.getText().toString());
        Intent intent = new Intent(getApplicationContext(), clz);
        intent.putExtra("num1", num1Val);
        intent.putExtra("num2", num2Val);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int calResult = data.getIntExtra("calResult", 0);
        String type = "";
        switch(requestCode) {
            case PLUS:
                type = "더하기";
                break;
            case MINUS:
                type = "빼기";
                break;
        }
        result.setText(type + " 결과 : " + calResult);
    }
}
















