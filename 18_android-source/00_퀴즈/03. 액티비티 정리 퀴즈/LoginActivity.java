import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {

    private Map<String, String> database = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDatabase();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pass = intent.getStringExtra("pass");

        // 0: 성공, 1 : 아이디 없음, 2 : 패스워드 틀림
        int code = validLogin(new Login(id, pass));
        if (code != 0) {
            setResult(500, new Intent().putExtra("code", code));
            finish();
        }

        setContentView(R.layout.login);
        setTitle("앱 테스트");

        TextView nameTv = (TextView)findViewById(R.id.nameTv);
        nameTv.setText(id);
    }

    private void setDatabase() {
        database.put("a", "a");
        database.put("b", "b");
        database.put("c", "c");
        database.put("d", "d");
    }

    private int validLogin(Login login) {
        String id = login.getId();
        if (!database.containsKey(id)) {
            return 1;
        }
        return database.get(id).equals(login.getPass()) ? 0 : 2;
    }
}