package com.example.kamranchaudhary.odabba.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.kamranchaudhary.odabba.Models.Package;
import com.example.kamranchaudhary.odabba.R;
import com.example.kamranchaudhary.odabba.payment;

import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.MyviewHolder> {

    private List<Package> PackagesList;
    private Context context;

    public RecylerAdapter(Context context,List<Package> list){
        this.context = context;
        this.PackagesList = list;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_cardview,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, final int position) {

        holder.packageType.setText(PackagesList.get(position).getPackage_type());
        holder.packageName.setText(PackagesList.get(position).getPackage_name());
        holder.packageDays.setText(String.valueOf(PackagesList.get(position).getPackage_duration()) + " Days");
        holder.packagePrice.setText("Rs. " + String.valueOf(PackagesList.get(position).getPackage_price()) + "/-");
        holder.packageDesc.setText(PackagesList.get(position).getPackage_description());
        holder.subscribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Package p = new Package(0,PackagesList.get(position).getPackage_name(),PackagesList.get(position).getPackage_type()
                    ,PackagesList.get(position).getPackage_price(),PackagesList.get(position).getPackage_duration()
                    ,PackagesList.get(position).getPackage_description());

            Intent i = new Intent(context,payment.class);
            i.putExtra("Package_Object",p);
            context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return PackagesList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView packageName,packageType,packageDays,packagePrice,packageDesc;
        Button subscribeBtn;

        public MyviewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.packageCardView);
            packageName = (TextView)itemView.findViewById(R.id.packageName);
            packageType = (TextView)itemView.findViewById(R.id.packageType);
            packageDays = (TextView)itemView.findViewById(R.id.packageDays);
            packagePrice = (TextView)itemView.findViewById(R.id.packagePrice);
            packageDesc = (TextView)itemView.findViewById(R.id.packageDesc);
            subscribeBtn = (Button)itemView.findViewById(R.id.subscribeBtn);

        }
    }
}
