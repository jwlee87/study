import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.drawable.ic_launcher);
                final String[] versionArray = new String[] { "젤리빈", "킷켓", "롤리팝" };
                /*
                dlg.setItems(versionArray,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                button1.setText(versionArray[which]);
                            }
                        });
                */
                /*
                dlg.setSingleChoiceItems(versionArray, 0,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                button1.setText(versionArray[which]);
                            }
                        });
                */
				dlg.setPositiveButton("닫기", null);



				// 다중 체크일 경우 체크된것 확인
				/*
                final boolean[] checkArray = new boolean[] { true, false, false };
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked) {
                                button1.setText(versionArray[which]);
                            }
                 });
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, Arrays.toString(checkArray), Toast.LENGTH_SHORT).show();
                    }
                });
				*/
                dlg.show();
            }
        });
    }
}