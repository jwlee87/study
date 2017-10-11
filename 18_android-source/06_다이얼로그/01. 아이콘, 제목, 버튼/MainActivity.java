import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
대화상자(Dialog)
사용자에게 중요한 사항을 알려준 후, 어떤 선택을 하게 하는 것이 목적

1. 대화상자 설정
   : AlertDialog.Builder

2. 용도에 따른 설정
   : setTitle() : 제목 설정
   : setMessage() : 내용 입력
   : setIcon() : 아이콘 설정
   : setPositiveButton() : <OK> 버튼
   : setNegativeButton() : <Cancel> 버튼
   : setItems() : 목록출력
   : setSingleChoiceItems() : 라디오버튼 목록 출력
   : setMultiChoiceItems() : 체크박스 목록 출력

3. 대화상자 화면 출력
   : show()
 */

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        MainActivity.this);
                dlg.setTitle("제목입니다");
                dlg.setMessage("이곳이 내용입니다");
                dlg.setIcon(R.drawable.ic_launcher);
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });
    }
}
