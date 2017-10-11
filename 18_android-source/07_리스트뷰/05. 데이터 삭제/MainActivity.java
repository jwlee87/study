import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> actors = new ArrayList<>();
        actors.add("황정민");
        actors.add("정우성");
        actors.add("이정재");
        actors.add("전지현");
        actors.add("알렉스");
        actors.add("한지민");
        actors.add("최민수");
        actors.add("이수민");
        actors.add("여진구");


        // ArrayAdapter(Context context, int resource, T[] objects)
        final ListView list = (ListView) findViewById(R.id.list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                actors
        );
        // 아래 메서드가 없다면 선택이 되지 않는다.
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> parent, View view, int position, long id) {
                String data = (String)list.getItemAtPosition(position);
                Toast.makeText(
                        getApplicationContext(),
                        data,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 데이터 삭제하기
        Button delBtn = (Button)findViewById(R.id.delBtn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (list.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    int position = list.getCheckedItemPosition();
                    /*
                    // adapter 에서 직접 삭제
                    */
                    String item = (String) list.getItemAtPosition(position);
                    adapter.remove(item);

                    /*  인텍스 위치로 삭제하기
                    actors.remove(position);
                    // 화면에서 삭제되지 않는다면.. 아래 코드 추가
                    adapter.notifyDataSetChanged();
                    */
                }
            }
        });
    }
}
