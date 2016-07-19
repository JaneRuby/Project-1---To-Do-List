package com.example.janerubygrissom.project1revised;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by janerubygrissom on 7/18/16.
 */
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
    MainObject mainObject;

    public RecyclerViewAdapter2(MainObject mainObject) {
        this.mainObject = mainObject;
    }

    //sets up the view holder to inflate and make the info display

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_two, parent, false);
        ViewHolder viewTwo = new ViewHolder(layoutView);
        return viewTwo;
    }

    //binds the info from the first activity to the second so it knows where it goes

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Singleton singleton = Singleton.getInstance();
        String description = mainObject.getmDetailsObject().get(position).getmDescription();
        holder.textView.setText(description);

       //TODO //set onclick listener on the card
        //TODO //set dialog box here (don't forget to do the xml layout for it)
       //TODO //add details to object

    }

    //returns the details of the object
    @Override
    public int getItemCount() {

        return mainObject.getmDetailsObject().size();
    }

    //identifies the placement of the edit text info
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView card;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.recyclerViewTwo);
            card = (CardView) itemView.findViewById(R.id.card);
        }
    }
}