package com.example.student_management;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Review_Adapter_class extends RecyclerView.Adapter<Review_Adapter_class.MyViewHolder> {

    ArrayList<Student> list;
    public Review_Adapter_class(ArrayList<Student> list)
    {
            this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.username.setText(list.get(i).getUsername());
        myViewHolder.contact.setText(list.get(i).getContact());
        myViewHolder.email.setText(list.get(i).getEmail());
        myViewHolder.pass.setText(list.get(i).getPass());
        myViewHolder.birth.setText(list.get(i).getBirth());
        myViewHolder.clg.setText(list.get(i).getClg());
        myViewHolder.gender.setText(list.get(i).getGender());
        myViewHolder.tech.setText(list.get(i).getTech());
        myViewHolder.duration.setText(list.get(i).getDuration());
        myViewHolder.sem.setText(list.get(i).getSem());
        myViewHolder.degree.setText(list.get(i).getDegree());
        myViewHolder.projectname.setText(list.get(i).getProjectname());
        myViewHolder.grp1.setText(list.get(i).getGrp1());
        myViewHolder.grp2.setText(list.get(i).getGrp2());
        myViewHolder.guide.setText(list.get(i).getGuide());
        myViewHolder.join.setText(list.get(i).getJoin());
        myViewHolder.end.setText(list.get(i).getEnd());
        myViewHolder.tool.setText(list.get(i).getTool());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView username,contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username =itemView.findViewById(R.id.tvname);
            contact = itemView.findViewById(R.id.tvcontact);
            email = itemView.findViewById(R.id.tvemail);
            pass = itemView.findViewById(R.id.tvpass);
            birth = itemView.findViewById(R.id.tvbirth);
            clg = itemView.findViewById(R.id.tvclg);
            gender = itemView.findViewById(R.id.tvgender);
            tech = itemView.findViewById(R.id.tvtech);
            duration = itemView.findViewById(R.id.tvduration);
            sem = itemView.findViewById(R.id.tvsem);
            degree = itemView.findViewById(R.id.tvdegree);
            projectname = itemView.findViewById(R.id.tvproname);
            grp1 = itemView.findViewById(R.id.tvgrp1);
            grp2 = itemView.findViewById(R.id.tvgrp2);
            guide = itemView.findViewById(R.id.tvguide);
            join = itemView.findViewById(R.id.tvjoin);
            end = itemView.findViewById(R.id.tvend);
            tool = itemView.findViewById(R.id.tvtool);

        }
    }
}
