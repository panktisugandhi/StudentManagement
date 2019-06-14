package com.example.student_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class List_adapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Student> users;

    public List_adapter(Context con,ArrayList<Student> users){

    context = con;
    layoutInflater = LayoutInflater.from(context);
    this.users = users;
    }


    @Override
    public int getCount() {
        return users.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listing_adapter, null, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tvname);
                holder.contact = (TextView) convertView.findViewById(R.id.tvcontact);
            holder.email = (TextView) convertView.findViewById(R.id.tvemail);
            holder.pass = (TextView) convertView.findViewById(R.id.tvpass);
            holder.birth = (TextView) convertView.findViewById(R.id.tvbirth);
            holder.clg = (TextView) convertView.findViewById(R.id.tvclg);
            holder.gender = (TextView) convertView.findViewById(R.id.tvgender);
            holder.tech = (TextView) convertView.findViewById(R.id.tvtech);
            holder.duration = (TextView) convertView.findViewById(R.id.tvduration);
            holder.sem = (TextView) convertView.findViewById(R.id.tvsem);
            holder.degree = (TextView) convertView.findViewById(R.id.tvdegree);
            holder.projectname = (TextView) convertView.findViewById(R.id.tvproname);
            holder.grp1 = (TextView) convertView.findViewById(R.id.tvgrp1);
            holder.grp2 = (TextView) convertView.findViewById(R.id.tvgrp2);
            holder.guide = (TextView) convertView.findViewById(R.id.tvguide);
            holder.join = (TextView) convertView.findViewById(R.id.tvjoin);
            holder.end = (TextView) convertView.findViewById(R.id.tvend);
            holder.tool = (TextView) convertView.findViewById(R.id.tvtool);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Student user=users.get(position);
        holder.name.setText(user.getUsername());
        holder.contact.setText(user.getContact());
        holder.email.setText(user.getEmail());
        holder.pass.setText(user.getPass());
        holder.birth.setText(user.getBirth());
        holder.clg.setText(user.getClg());
        holder.gender.setText(user.getGender());
        holder.tech.setText(user.getTech());
        holder.duration.setText(user.getDuration());
        holder.sem.setText(user.getSem());
        holder.degree.setText(user.getDegree());
        holder.projectname.setText(user.getProjectname());
        holder.grp1.setText(user.getGrp1());
        holder.grp2.setText(user.getGrp2());
        holder.guide.setText(user.getGuide());
        holder.join.setText(user.getJoin());
        holder.end.setText(user.getEnd());
        holder.tool.setText(user.getTool());
        return convertView;
    }
    public class ViewHolder {
        TextView name, contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;
    }


    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        users.clear();
        if (charText.length() == 0) {
            users.addAll(users);
        } else {
            for (Student wp : users) {
                if (wp.getUsername().toLowerCase(Locale.getDefault()).contains(charText)) {
                    users.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
