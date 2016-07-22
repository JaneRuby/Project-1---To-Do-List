package com.example.janerubygrissom.project1revised;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by janerubygrissom on 7/18/16.
 */

//extends recyclerview.adapter<nameofadapter.viewholder>,

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<MainObject> mainObjectArrayList = new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<MainObject> mainObjectArrayList) {
        this.mainObjectArrayList = mainObjectArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_one, parent, false);
        ViewHolder viewOne = new ViewHolder(layoutView);

        //inflate
        return viewOne;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Singleton singleton = Singleton.getInstance();
//        CustomObject2 customObject2 = new CustomObject2("hi", "badfaflah");
        final ArrayList<MainObject> mainObjects = singleton.getmMainObjectArrayList();
        String title = mainObjects.get(position).getmTitle();
        holder.textView.setText(title);

        //TODO holder.card.setOnLongClickListener();


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("position", position);
                Context context = view.getContext();
                context.startActivity(intent);

            }
        });

        holder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mainObjects.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mainObjectArrayList.size());
                notifyDataSetChanged();
                //delete stuff
                return true;
            }
        });

        //set texts, onCLickListeners...

    }

    //sets the info into the card view and lists it

    @Override
    public int getItemCount() {
        if (mainObjectArrayList == null) {
            //return array list
            return 0;
        }
        return mainObjectArrayList.size();
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