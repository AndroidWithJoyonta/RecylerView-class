package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    HashMap<String ,String > hashMap;
    ArrayList<HashMap<String ,String >> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerView);



        arrayList = new ArrayList<>();

        hashMap=  new HashMap<>();
        hashMap.put("video_id","PLu0W_9lII9agtWvR_TZdb_r0dNI8-lDwG");
        hashMap.put("title","Introduction to Next.js");
        arrayList.add(hashMap);

        hashMap=  new HashMap<>();
        hashMap.put("video_id","PLu0W_9lII9agtWvR_TZdb_r0dNI8-lDwG");
        hashMap.put("title","Introduction to Next.js");
        arrayList.add(hashMap);



        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }

    //RecyclerView method Here

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {


        public class myViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView  = itemView.findViewById(R.id.imageView);
                textView  = itemView.findViewById(R.id.textView);
            }
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.video_item,parent,false);

            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            hashMap = arrayList.get(position);

            String title = hashMap.get("title");
            String video_id = hashMap.get("video_id");
            String imageUri="https://img.youtube.com/vi/"+video_id+"/0.jpg";

            Picasso.get()
                    .load(imageUri)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);

            holder.textView.setText(title);

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }
}