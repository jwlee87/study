import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText contentEdit;
    private EditText sizeEdit;
    private RadioGroup colorGroup;
    private TextView resultTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentEdit = (EditText  )findViewById(R.id.contentEdit);
        sizeEdit    = (EditText  )findViewById(R.id.sizeEdit);
        colorGroup  = (RadioGroup)findViewById(R.id.colorGroup);
        resultTv    = (TextView  )findViewById(R.id.resultTv);

        findViewById(R.id.applyBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = "#000000";
                switch (colorGroup.getCheckedRadioButtonId()) {
                    case R.id.red:
                        color = "#ff0000";
                        break;
                    case R.id.blue:
                        color = "#0000ff";
                        break;
                    case R.id.black:
                        color = "#000000";
                        break;
                }
                resultTv.setTextColor(Color.parseColor(color));
                resultTv.setTextSize(Integer.parseInt(sizeEdit.getText().toString()));
                resultTv.setText(contentEdit.getText().toString());
            }
        });
    }
}







