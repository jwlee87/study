import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private int rowLayout;
    private ArrayList<Singer> data;
    private LayoutInflater inflater;

    public MyListAdapter(Context context, int rowLayout, ArrayList<Singer> data) {
        this.context = context;
        this.data = data;
        this.rowLayout = rowLayout;
        // 리스트뷰에 그려질 rowLayout(R.layout.my_row) 파일의 내용을
        // 인플레이션 하기 위해서...
        inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }
    @Override
    public int getCount() { return data.size(); }

    @Override
    public Object getItem(int index) { return data.get(index); }

    @Override
    public long getItemId(int index) { return index; }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        // 1. view 가 null 이라면 View 객체를 인플레이션을 통해서 생성하기
        if (view == null) {
            //  rowLayout == R.layout.my_row
            view = inflater.inflate(rowLayout, null);
        }
        TextView nameTv  = (TextView ) view.findViewById(R.id.name);
        TextView birthTv = (TextView ) view.findViewById(R.id.birth);
        ImageView img    = (ImageView) view.findViewById(R.id.img);

        Singer singer = data.get(index);

        // list row 에 데이터 설정
        nameTv .setText(singer.getName());
        birthTv.setText(singer.getBirth());
        img.setImageResource(singer.getImg());

        return view;
    }
}













