package com.example.janerubygrissom.project1revised;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Singleton singleton = Singleton.getInstance();
        String description = mainObject.getmDetailsObject().get(position).getmDescription();
        holder.textView.setText(description);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();



                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
//                LayoutInflater inflater = ________________getLayoutInflater();

                dialogBuilder.setView(R.layout.dialog_description);


                dialogBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Singleton singleton = Singleton.getInstance();
                        Dialog dialog = (Dialog) dialogInterface;

                        final EditText mEditTextOne = (EditText) dialog.findViewById(R.id.textDescription);


                        String one = mEditTextOne.getText().toString().trim();


                        if( one == "" ) {
                            mEditTextOne.setError("Not valid entry");
                        }

                        else if(one.isEmpty()){
                            mEditTextOne.setError("Can't leave empty");

                        }

                        else{
                            mainObject.getmDetailsObject().get(position).setmDescription(one);
                            String temp = mainObject.getmDetailsObject().get(position).getmDescription();

//                            mainObject.getmDetailsObject().get(position).setmDetail(one);
                            String title = mainObject.getmDetailsObject().get(position).getmDetail();

                            holder.textView.setText(title + "\n" + temp);
//                            adapterFirst.notifyDataSetChanged();
//                            dialogInterface.dismiss();
                        }
                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dialogBuilder.setTitle("Add Item Description");

                final AlertDialog bundler = dialogBuilder.create();

                bundler.show();



            }
        });
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
