package com.example.android10_1_2_593;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] title = new String[] {
            "01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  ViewGroupの生成と表示
        LinearLayout varLayout = new LinearLayout( this );
        varLayout.setOrientation( LinearLayout.VERTICAL );
        setContentView( varLayout );

        //  リストビュー生成
        ListView varListView = new ListView( MainActivity.this );

        //  アダプタを生成して配列にtitleを登録
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                title
        );

        //  リストビューをビューグループに配置
        varLayout.addView( varListView );

        //  アダプターをリストビューに登録
        varListView.setAdapter( adapter );

        //  イベントリスナー登録
        varListView.setOnItemClickListener( MainActivity.this );
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id )
    {
//      Toast.makeText( MainActivity.this, title[position], Toast.LENGTH_SHORT ).show();
        Toast.makeText( MainActivity.this, (( TextView )view ).getText(), Toast.LENGTH_SHORT ).show();
    }
}
