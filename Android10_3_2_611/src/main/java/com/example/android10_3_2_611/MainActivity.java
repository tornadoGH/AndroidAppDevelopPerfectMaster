package com.example.android10_3_2_611;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] infomation = new String[] {
            "infomation00",
            "infomation01",
            "infomation02",
            "infomation03",
            "infomation04",
            "infomation05",
            "infomation06",
            "infomation07",
            "infomation08",
            "infomation09",
            "infomation10",
    };

    private String[] title = new String[] {
        "title00",
        "title01",
        "title02",
        "title03",
        "title04",
        "title05",
        "title06",
        "title07",
        "title08",
        "title09",
        "title10",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  データを格納するためのArrayList
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();

        for( int i=0;i<infomation.length;i++ )
        {
            //  HashMapのインスタンス生成
            HashMap<String ,String> temp = new HashMap<String, String>();

            //  配列infomationの要素をkey_infomationに関連付けて代入
            temp.put("key_infomation", infomation[i]);
            //  配列titleの要素をkey_titleに関連付けて代入
            temp.put("key_title", title[i]);

            //  tempをdateに追加する
            data.add( temp );
        }

        //  SimpleAdapterクラスのアダプターを生成
        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                data,
                R.layout.listitem,
                new String[]{"key_infomation","key_title"},
                new int[]{R.id.infomation, R.id.title });

        //  アダプターをリストビューにセット
        ListView varListView = ( ListView )findViewById( R.id.listView );
        varListView.setAdapter( adapter );

        //  イベントリスナーをリストビューにセット
        varListView.setOnItemClickListener( MainActivity.this );
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id )
    {
        TextView textView = ( TextView )view.findViewById( R.id.infomation );
        Toast.makeText( getApplication(), textView.getText(), Toast.LENGTH_SHORT ).show();
    }
}
