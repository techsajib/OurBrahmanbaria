package com.techsajib.amaderbbaria.Bank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsajib.amaderbbaria.R;

import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>{

    private List<BankModel> bankList;
    private Context mContext;

    public BankAdapter(List<BankModel> bankList, Context mContext) {
        this.bankList = bankList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_main_page_row, parent, false);
        BankViewHolder bankViewHolder = new BankViewHolder(view);
        return bankViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {

        final BankModel bankPosition = bankList.get(position);

        holder.nameText.setText(" " + bankPosition.getName());
        holder.branchText.setText(" " + bankPosition.getBranch());
        holder.rountingText.setText(" Routing No: " + bankPosition.getRouting());
        holder.swiftText.setText(" SWIFT Code: " + bankPosition.getSwift());
        holder.numberText.setText(" " + bankPosition.getNumber());
        holder.emailText.setText(" " + bankPosition.getEmail());
        holder.webText.setText(" " + bankPosition.getWeb());
        holder.timeText.setText(" " + bankPosition.getTime());
        holder.addressText.setText(" " + bankPosition.getAddress());


    }

    @Override
    public int getItemCount() {
        return bankList.size();
    }

    public class BankViewHolder extends RecyclerView.ViewHolder {

        TextView nameText, branchText, rountingText, swiftText, numberText, emailText, webText, timeText, addressText;

        public BankViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.bankNameID);
            branchText = itemView.findViewById(R.id.bankBranchID);
            rountingText = itemView.findViewById(R.id.bankRoutingID);
            swiftText = itemView.findViewById(R.id.bankSwiftID);
            numberText = itemView.findViewById(R.id.bankNumberID);
            emailText = itemView.findViewById(R.id.bankEmailID);
            webText = itemView.findViewById(R.id.bankWebID);
            timeText = itemView.findViewById(R.id.bankTimeID);
            addressText = itemView.findViewById(R.id.bankAddressID);

        }
    }
}
