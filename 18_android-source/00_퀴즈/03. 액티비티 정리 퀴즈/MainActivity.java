import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("앱 테스트");
    }

    public void doLogin(View view) {
        EditText idEt = (EditText)findViewById(R.id.idEt);
        EditText passEt = (EditText)findViewById(R.id.passEt);

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra("id", idEt.getText().toString());
        intent.putExtra("pass", passEt.getText().toString());
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int code = data.getIntExtra("code", 0);
        TextView resultTv = (TextView)findViewById(R.id.resultTv);
        if (resultCode == 500) {
            resultTv.setText("입력하신 " + (code == 1 ? "아이디" : "패스워드") + " 올바르지 않습니다.");
        }
    }
}