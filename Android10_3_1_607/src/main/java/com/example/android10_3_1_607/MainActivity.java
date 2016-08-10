package com.example.android10_3_1_607;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] title = new String[]{
            "00","01","02","03","04","05","06","07","08","09",
            "10","11","12","13","14","15","16","17","18","19",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  アダプター生成
        ListAdapter adapter = ( ListAdapter )new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, title );

        //  リストビューのインスタンス取得
        ListView varListView = ( ListView )findViewById( R.id.listView );

        //  ヘッダー用のテキストビュー生成
        TextView varTextView1 = new TextView( MainActivity.this );
        //  ヘッダー用のテキストを設定
        varTextView1.setText("Header");
        //  リストビューのヘッダーにテキストビューを配置
        varListView.addHeaderView( varTextView1 );

        //  フッター用のテキストビュー生成
        TextView varTextView2 = new TextView( MainActivity.this );
        //  フッター用のテキストを設定
        varTextView2.setText("Footer");
        //  リストビューのフッターにテキストビューを配置
        varListView.addFooterView( varTextView2 );

        //  アダプターをリストビューにセット
        varListView.setAdapter( adapter );

        //  リストビューにイベントリスナーセット
        varListView.setOnItemClickListener( MainActivity.this );
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id )
    {
        //  ヘッダーとフッターも１ラインとして数えられている
        String text = String.format("positon:%d  text:%s", position, (( TextView )view ).getText());
            Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT ).show();
    }
}
