package com.example.nirvan.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    final List<String> temp=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv=(RecyclerView) findViewById(R.id.rv);
        final myAdapter adapter=new myAdapter(temp);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(adapter);


        //the firebase code
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                temp.clear();
                for (DataSnapshot p : dataSnapshot.getChildren())
                {
                    temp.add(p.getValue(String.class));
                }

                adapter.notifyDataSetChanged();
                Log.e("TAG","temp[0]="+temp.get(0));
                Log.e("TAG","temp[1]="+temp.get(1));
                Log.e("TAG","temp[2]="+temp.get(2));
                Log.e("TAG","temp[3]="+temp.get(3));

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Log.e("TAG","Failure!");
            }


        });
        //



    }









}
