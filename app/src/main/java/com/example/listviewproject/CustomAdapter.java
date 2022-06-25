package com.example.listviewproject;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Valorant> {
        List<Valorant> list;
        Context context;
        int xmlResource;

        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Valorant> objects) {
            super(context, resource, objects);
            xmlResource = resource;
            list = objects;
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //return super.getView(position, convertView, parent);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout = layoutInflater.inflate(xmlResource, null);

            TextView name = adapterLayout.findViewById(R.id.textView);
            TextView place = adapterLayout.findViewById(R.id.textView2);
            ImageView image = adapterLayout.findViewById(R.id.imageView);
            Button remove = adapterLayout.findViewById(R.id.button);
            Switch switch1 = adapterLayout.findViewById(R.id.switch1);
            remove.setText("Eliminate");
            final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.sound);

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!(switch1.isChecked())) {
                        mp1.start();
                        notifyDataSetChanged();
                        list.remove(position);
                    }
                }
            });
            name.setText(list.get(position).getName());
            place.setText("Origin: "+list.get(position).getPlace());
            image.setImageResource(list.get(position).getImage());
            return adapterLayout;

        }
    }

