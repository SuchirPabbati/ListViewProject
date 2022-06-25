package com.example.listviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Valorant> valorantArrayList;
    TextView healthText, dateText, content;
    String scontent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_id);
        valorantArrayList = new ArrayList<Valorant>();
        healthText =findViewById(R.id.healthText);
        dateText =findViewById(R.id.dateText);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            content = findViewById(R.id.textView4);

        }

        valorantArrayList.add(new Valorant("Sage","China", R.drawable.sage,"150hp","March 2020", "Sage is a very good support agent. Usually used in every team composition as healing is vital to winning rounds. Sage also has great defensive capabilities with her wall."));
        valorantArrayList.add(new Valorant("Phoenix","UK", R.drawable.phoenix,"136hp","March 2020","Phoenix is a duelist who usually takes close quarter combat. With his flash and molotov, he has deadly solo capability. He is also able to heal himself with his fire which can make or break a fight. Phoenix is also able to make a clone of himself with his ultimate and safely engage a fight without putting his main body at risk."));
        valorantArrayList.add(new Valorant("Cypher","Morocco", R.drawable.cypher,"98hp","January 2021","Cypher is an intelligence and defensive oriented agent. With his variety of utility he is able to defend sites easily with his mix of tripwires and cyber cages. He is also able to gather intelligence of the enemy team with his spy camera and his ultimate which reveals the enemies locations. "));
        valorantArrayList.add(new Valorant("Jett","South Korea", R.drawable.jett,"50hp","January 2020","Jett is a fast paced offensive agent. Jett is usually played with snipers as she is able to get to high places and snipe from unexpected places. Jett’s ultimate brings out a flurry of knives which are complained to be overpowered by the Valorant community."));
        valorantArrayList.add(new Valorant("Omen","Unknown",R.drawable.omen,"175hp","March 2021","Omen is a controller agent whose purpose is to set the pace for the match and initiate fights. Omen uses his smokes to cut off angles where enemies can appear from. Omen also uses his paranoia to blind the enemies and sneak up on them with his teleport."));
        if(savedInstanceState !=null)
        {
            scontent = (savedInstanceState.getString("scontent"));
            //content.setText(savedInstanceState.getString("valInfo"));
            healthText.setText(savedInstanceState.getString("valHP"));
            dateText.setText(savedInstanceState.getString("valDate"));
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                content.setText((savedInstanceState).getString("scontent"));
            }
            valorantArrayList = savedInstanceState.getParcelableArrayList("valList");

        }
        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, valorantArrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                healthText.setText(valorantArrayList.get(position).getHealth());
                dateText.setText(valorantArrayList.get(position).getDate());
                scontent = valorantArrayList.get(position).getInfo();
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    content.setText(valorantArrayList.get(position).getInfo());
                }
            }
        });


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("valList",valorantArrayList);
        outState.putString("valDate",dateText.getText().toString());
        outState.putString("valHP",healthText.getText().toString());
        outState.putString("scontent",scontent);
        //outState.putString("valName",);
        //outState.putString("valPlace",);





    }
    }



