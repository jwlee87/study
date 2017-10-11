import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Singer> data = new ArrayList<>();
        data.add(new Singer("1984-03-22", R.drawable.kara_1, "니콜"));
        data.add(new Singer("1985-03-22", R.drawable.kara_2, "박규리"));
        data.add(new Singer("1985-07-21", R.drawable.kara_3, "구하라"));
        data.add(new Singer("1983-05-11", R.drawable.kara_4, "강지영"));
        data.add(new Singer("1981-01-07", R.drawable.kara_5, "한승연"));

        final MyListAdapter adapter = new MyListAdapter(
            getApplicationContext(),
            R.layout.my_row,
            data
        );

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // 이벤트 설정은 직접해보기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                TextView nameTv = (TextView)view.findViewById(R.id.name);
                String name = nameTv.getText().toString();
                Singer singer = (Singer)adapter.getItem(index);
                String birth = singer.getBirth();

				Toast.makeText(getApplicationContext(),
                                         "이름 : " + name + ", 생일 : " + birth,
                                         Toast.LENGTH_SHORT).show();
            }
        });
    }
}









