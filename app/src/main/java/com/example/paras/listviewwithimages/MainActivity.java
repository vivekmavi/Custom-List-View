package com.example.paras.listviewwithimages;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// This project is based on statically loading images from drawable folder and displaying them
// on custom list view using custom adapter class



public class MainActivity extends AppCompatActivity
{

    int[] images = { R.drawable.image1 , R.drawable.image2 , R.drawable.image3 , R.drawable.image4,
                      R.drawable.image5 , R.drawable.image6 , R.drawable.image7 , R.drawable.image8,
                      R.drawable.image9 , R.drawable.image10 };
    ListView listView ;
    String[] titles ;
    String[] description ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources_obj = getResources();

        titles = resources_obj.getStringArray(R.array.titles);
        description = resources_obj.getStringArray(R.array.description);

        listView = (ListView) findViewById(R.id.listView_msin);

        List<DataList> dataList = new ArrayList<DataList>();
        DataList dataListObject;
        dataListObject = new DataList();
        for(int i=0 ; i<10 ; i++)
        {
            dataListObject = new DataList();
            dataListObject.setTitle(titles[i]);
            dataListObject.setDescription((description[i]));
            dataListObject.setImage(images[i]);

            dataList.add(dataListObject);
        }
// unable to populate using this... getView doesnot get called i guess
        MyCustomAdapter2 customAdapter2 = new MyCustomAdapter2(this,R.layout.custom_row,dataList);

        listView.setAdapter(customAdapter2);
    }


    class MyCustomAdapter2 extends ArrayAdapter
    {   Context context2 ;
        int resource2 ;
        List<DataList> dataList3 ;
        LayoutInflater inflater ;

        public MyCustomAdapter2(Context context,int resource3,List<DataList> dataList2 )
        {
            super(context, resource3,dataList2);

            this.dataList3 = dataList2;
            this.context2 = context ;
            this.resource2 = resource3 ;

        }
        @Override
        public View getView(int position,  View convertView, ViewGroup parent)
        {
            ViewHolder viewHolder = null;

            for (int i = 0 ; i<10 ; i++)
            {
                Toast.makeText(MainActivity.this, dataList3.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(convertView==null)
            {
                viewHolder = new ViewHolder();

                inflater = (LayoutInflater) context2.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(resource2,parent,false);

                viewHolder.textViewTites = (TextView) convertView.findViewById(R.id.textView1_row);
                viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.textView2_row);
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView_in_row);
                convertView.setTag(viewHolder);
            } else { viewHolder = (ViewHolder) convertView.getTag();}

            viewHolder.textViewTites.setText(dataList3.get(position).getTitle());
            viewHolder.textViewDescription.setText(dataList3.get(position).getDescription());
            viewHolder.imageView.setImageResource(dataList3.get(position).getImage());

            return convertView;
        }
        class ViewHolder
        {
            TextView textViewTites;
            ImageView imageView;
            TextView textViewDescription;
        }
    }

}
