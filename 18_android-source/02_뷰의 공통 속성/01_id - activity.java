package kr.co.mlec.lecture;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
id
뷰를 칭하는 이름을 정의하며, 코드나 XML 문서에서 뷰를 참조할 때 id를 사용하므로 직관적인 이름을 붙이는 것이 좋음
형식 : @[+]id/ID
    - @ : id를 리소스(R.java)에 정의하거나 참조한다는 뜻이며, 무조건 붙여야 함
    -  + : ID를 새로 정의한다는 뜻이며, 참조 시는 생략 가능
    - id : 예약어
    -  /  : 뒤에 원하는 이름을 작성하되, ID는 고유한 명칭이므로 명령 규칙에 맞아야 하며, 뷰끼리 중복되어서는 안됨
     ex) android:id=“@+id/name” : 텍스트 뷰에 name이라는  id를 부여함.

XML 문서에 ID를 지정하면 이 이름이 R.java에 정수형 상수로 정의

코드에서 뷰를 참조할 시 findViewById 메서드 호출, 인수로 참조할 뷰의 id를 전달
*/
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        getApplicationContext(), "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}