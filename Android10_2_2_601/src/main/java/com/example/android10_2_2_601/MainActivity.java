package com.example.android10_2_2_601;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] title = new String[]{
            "01","02","03","04","05","06","07","08","09","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  アダプター生成
        ListAdapter adapter = ( ListAdapter )new ArrayAdapter<String>( MainActivity.this, android.R.layout.simple_list_item_1, title );

        //  アダプターをリストビューにセット
        ListView varListView = ( ListView )findViewById( R.id.listView );
        varListView.setAdapter( adapter );

        //  リストビューを指定の位置までスクロール
        varListView.setSelection(15);

        //  クリックリスナー設定
        varListView.setOnItemClickListener( this );
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id )
    {
        Toast.makeText( getApplication(), (( TextView )view ).getText(), Toast.LENGTH_SHORT ).show();
    }
}
