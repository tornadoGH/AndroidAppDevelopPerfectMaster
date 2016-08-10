package com.example.android_10_1_1_583;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  string.xmlのarray01の文字列を取得
        String[] title = getResources().getStringArray( R.array.array01 );

        //  アダプターの生成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                R.layout.listitem,      //  res/layout/listitem.xml
                title
        );
        //  アダプターをListViewに登録
        setListAdapter( adapter );

        //  ListViewのインスタンス取得
        ListView varListView = getListView();

        //  フィルター機能ON（キー入力で、リストアイテムの絞り込みができる）
        varListView.setTextFilterEnabled( true );

        //  アイテムのクリックリスナー
        varListView.setOnItemClickListener( MainActivity.this );

        //  アイテムのロングクリックリスナー
        varListView.setOnItemLongClickListener( MainActivity.this );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id )
    {
        TextView item = ( TextView )v;
        Toast.makeText( MainActivity.this, item.getText(), Toast.LENGTH_SHORT ).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id )
    {
        TextView item = ( TextView )v;
        Toast.makeText( MainActivity.this, "LONG:" + item.getText(), Toast.LENGTH_SHORT ).show();

        return false;
    }
}
