package kr.co.mlec.lecture;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
layout_width, layout_height
뷰의 폭과 높이를 지정하며, 수평, 수직 각 방향에 대해 크기를 지정 가능
속성값으로 아래의 세 가지 중 하나의 값을 가짐
    - match_parent(fill_parent) : 부모의 주어진 크기를 다 채움
    - wrap_content : 내용물의 크기만큼만 채움.
    - 정수 크기 : 지정한 크기에 맞춤

ex) “Start”라는 캡션을 가지는 버튼 배치
*/
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}