package com.example.student_management;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchScreen extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    SharedPreferences sharedPreferences;
    DatabaseReference databaseReference;
    ArrayList<Student> list;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        sharedPreferences = getSharedPreferences("SortSetting",MODE_PRIVATE);
        String msorting = sharedPreferences.getString("Sort","Newest");
        if (msorting.equals("Newest")){
            linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setReverseLayout(true);
            linearLayoutManager.setStackFromEnd(true);
        }else if (msorting.equals("Oldest")){
            linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setReverseLayout(false);
            linearLayoutManager.setStackFromEnd(false);
        }


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Student");
        recyclerView = findViewById(R.id.rview);
        searchView = findViewById(R.id.search);

        recyclerView.setLayoutManager(linearLayoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.admin_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.sort:
                showsortingdialog();
        }
        return true;
    }
private void showsortingdialog(){
        String[] sortoption = {"Newest","Oldest"};
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Sort by")
            .setIcon(R.drawable.ic_sort)
            .setItems(sortoption, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //'which' is argument contain the index position of the select item
                    // 0 means "newest" 1 means "oldest"
                    if (which==0){

//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("Sort","Newest");
//                        editor.apply();
//                        recreate();
                    }else if(which==1){
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("Sort","Oldest");
//                        editor.apply();
//                        recreate();
                    }
                }
            });
            builder.show();
}
    @Override
    protected void onStart() {
        super.onStart();

        if (databaseReference!=null){
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()){

                        list = new ArrayList<>();
                        for (DataSnapshot ds :dataSnapshot.getChildren()){
                            list.add(ds.getValue(Student.class));
                        }
                        Review_Adapter_class reviewAdapterClass = new Review_Adapter_class(list);
                        recyclerView.setAdapter(reviewAdapterClass);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(SearchScreen.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        if (searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return false;
                }
            });
        }
    }
    private void search(String str){
        ArrayList<Student> mylist = new ArrayList<>();
        for (Student object:list){
            if (object.getUsername().toLowerCase().contains(str.toLowerCase())){
                mylist.add(object);
            }else if (object.getGuide().toLowerCase().contains(str.toLowerCase())){
                mylist.add(object);
            }else if (object.getClg().toLowerCase().contains(str.toLowerCase())){
                mylist.add(object);
            }
           Review_Adapter_class adapter_class = new Review_Adapter_class(mylist);
            recyclerView.setAdapter(adapter_class);
        }
    }
}
//    Button btn_getdata,btn_back;
//    ListView listView;
//    ListView allusers;
//    private SearchView editsearch;
//    ProgressDialog mProgressDialog;
//    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
//    ListingAdapter adapter;
//    ArrayList<Student> users=new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_screen);
//
//        listView = findViewById(R.id.allusers);
//        btn_back = findViewById(R.id.backto);
//        btn_getdata = findViewById(R.id.getdata);
//
//        //deta search
//        editsearch = (SearchView) findViewById(R.id.search);
//        editsearch.setOnQueryTextListener(this);
//
//
//
//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SearchScreen.this,Admin_login.class));
//            }
//        });
//btn_getdata.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//
//        allusers=(ListView)findViewById(R.id.allusers);
//        adapter=new ListingAdapter(SearchScreen.this,users);
//        allusers.setAdapter(adapter);
//        getDataFromServer();
//
//    }
//});
//    }
//
//    public void getDataFromServer()
//    {
//        showProgressDialog();
//        databaseReference.child("Student").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                if(dataSnapshot.exists())
//                {
//                    for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
//                    {
//                        Student user=postSnapShot.getValue(Student.class);
//                        users.add(user);
//                        adapter.notifyDataSetChanged();
//                    }
//
//                }
//                hideProgressDialog();
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                hideProgressDialog();
//                Toast.makeText(SearchScreen.this, "NetWork Error... Please Check your Connection...", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    private void showProgressDialog() {
//        if (mProgressDialog == null) {
//            mProgressDialog = new ProgressDialog(SearchScreen.this);
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(true);
//        }
//        mProgressDialog.show();
//    }
//    private void hideProgressDialog() {
//        if (mProgressDialog != null && mProgressDialog.isShowing()) {
//            mProgressDialog.dismiss();
//        }
//    }
//
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        return false;
//    }
//
//    private class ListingAdapter extends BaseAdapter {
//        Context context;
//        LayoutInflater layoutInflater;
//        ArrayList<Student> users;
//        public ListingAdapter(Context con,ArrayList<Student> users)
//        {
//            context=con;
//            layoutInflater = LayoutInflater.from(context);
//            this.users=users;
//        }
//        @Override
//        public int getCount() {
//            return users.size();
//        }
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder holder;
//            if (convertView == null) {
//                convertView = layoutInflater.inflate(R.layout.listing_adapter, null, false);
//                holder = new ViewHolder();
//                holder.name = (TextView) convertView.findViewById(R.id.tvname);
//                holder.contact = (TextView) convertView.findViewById(R.id.tvcontact);
//                holder.email = (TextView) convertView.findViewById(R.id.tvemail);
//                holder.pass = (TextView) convertView.findViewById(R.id.tvpass);
//                holder.birth = (TextView) convertView.findViewById(R.id.tvbirth);
//                holder.clg = (TextView) convertView.findViewById(R.id.tvclg);
//                holder.gender = (TextView) convertView.findViewById(R.id.tvgender);
//                holder.tech = (TextView) convertView.findViewById(R.id.tvtech);
//                holder.duration = (TextView) convertView.findViewById(R.id.tvduration);
//                holder.sem = (TextView) convertView.findViewById(R.id.tvsem);
//                holder.degree = (TextView) convertView.findViewById(R.id.tvdegree);
//                holder.projectname = (TextView) convertView.findViewById(R.id.tvproname);
//                holder.grp1 = (TextView) convertView.findViewById(R.id.tvgrp1);
//                holder.grp2 = (TextView) convertView.findViewById(R.id.tvgrp2);
//                holder.guide = (TextView) convertView.findViewById(R.id.tvguide);
//                holder.join = (TextView) convertView.findViewById(R.id.tvjoin);
//                holder.end = (TextView) convertView.findViewById(R.id.tvend);
//                holder.tool = (TextView) convertView.findViewById(R.id.tvtool);
//                convertView.setTag(holder);
//            } else {
//                holder = (SearchScreen.ListingAdapter.ViewHolder) convertView.getTag();
//            }
//            Student user=users.get(position);
//            holder.name.setText(user.getUsername());
//            holder.contact.setText(user.getContact());
//            holder.email.setText(user.getEmail());
//            holder.pass.setText(user.getPass());
//            holder.birth.setText(user.getBirth());
//            holder.clg.setText(user.getClg());
//            holder.gender.setText(user.getGender());
//            holder.tech.setText(user.getTech());
//            holder.duration.setText(user.getDuration());
//            holder.sem.setText(user.getSem());
//            holder.degree.setText(user.getDegree());
//            holder.projectname.setText(user.getProjectname());
//            holder.grp1.setText(user.getGrp1());
//            holder.grp2.setText(user.getGrp2());
//            holder.guide.setText(user.getGuide());
//            holder.join.setText(user.getJoin());
//            holder.end.setText(user.getEnd());
//            holder.tool.setText(user.getTool());
//            return convertView;
//        }
//        public class ViewHolder {
//            TextView name, contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;
//        }
//        @Override
//        public Object getItem(int position) {
//            return users.get(position);
//        }
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//    }
//
//}
