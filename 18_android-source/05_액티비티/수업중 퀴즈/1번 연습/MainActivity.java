package kr.co.mlec.bit90;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton movie = (RadioButton) findViewById(R.id.movie);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;

                if (movie.isChecked() == true)
                    intent = new Intent(getApplicationContext(),
                            MovieActivity.class);
                else
                    intent = new Intent(getApplicationContext(),
                            SingerActivity.class);

                startActivity(intent);
            }
        });
    }
}
















