package com.example.janerubygrissom.to_do_list_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by janerubygrissom on 7/14/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    ArrayList<CustomObject2> thingOne = new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<CustomObject2> thingOne) {
        this.thingOne = thingOne;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_one,parent,false);
        ViewHolder viewOne = new ViewHolder(layoutView);

        //inflate
        return viewOne;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Singleton bobDylan = Singleton.getInstance();
//        CustomObject2 customObject2 = new CustomObject2("hi", "badfaflah");
        ArrayList<CustomObject2> customObject2 = bobDylan.getBobDylan();
        String title = customObject2.get(position).getTitle();
        Log.d("title", title+"worked?");
        holder.textView.setText(title);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("position", position);
                Context context = view.getContext();
                context.startActivity(intent);

            }
        });

        //set texts, onCLickListeners...

    }

    @Override
    public int getItemCount() {
        if(thingOne == null) {
            //return array list
            return 0;
        }
        return thingOne.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView card;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.recyclerViewOne);
            card = (CardView) itemView.findViewById(R.id.card);


        }



    }
}
