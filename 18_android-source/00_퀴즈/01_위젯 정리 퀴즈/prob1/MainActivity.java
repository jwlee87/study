package kr.co.mlec.bit90;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;
    int result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnRem = (Button) findViewById(R.id.btnRem);

        textResult = (TextView) findViewById(R.id.textResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                calResult("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                calResult("-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                calResult("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                calResult("/");
            }
        });
    }

    private void calResult(String type) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();

        if (num1.trim().equals("") || num2.trim().equals("")) {
            Toast.makeText(getApplicationContext(),
                    "입력 값이 비었습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        if ("/".equals(type) && num2.trim().equals("0")) {
            Toast.makeText(getApplicationContext(),
                    "0으로 나누면 안됩니다!", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (type) {
            case "+":
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case "-":
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                break;
            case "*":
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                break;
            case "/":
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                break;
        }
        textResult.setText("계산 결과 : " + result);
    }
}