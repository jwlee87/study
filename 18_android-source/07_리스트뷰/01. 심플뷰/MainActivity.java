import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                actors
        );

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(), actors.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
