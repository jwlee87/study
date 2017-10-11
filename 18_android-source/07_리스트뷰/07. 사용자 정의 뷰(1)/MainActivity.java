import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] array = {"김유신","이순신","강감찬","을지문덕"};
        /*
             R.layout.list_row : 리스트뷰의 로우 항목 표현
             R.id.txtView : array의 데이터를 표현할 텍스트뷰 아이디
             리스트뷰에 표현할 데이터 배열
         */
        ArrayAdapter<String> Adapter =
                new ArrayAdapter<String>(this, R.layout.list_row, R.id.txtView, array);

        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(Adapter);
    }
}