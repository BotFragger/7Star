package com.example.a7star;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PasswordAdapterClass extends RecyclerView.Adapter<PasswordAdapterClass.ViewHolder> {
   List<PasswordModelClass> password;
   Context context;
   DatabaseHelperClass databaseHelperClass;

    public PasswordAdapterClass(List<PasswordModelClass> password, Context context) {
        this.password = password;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.password_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PasswordModelClass passwordModelClass = password.get(position);

        holder.textViewID.setText(Integer.toString(passwordModelClass.getId()));
        holder.editText_Email.setText(passwordModelClass.getemail());
        holder.editText_Password.setText(passwordModelClass.getpassword());
        holder.button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringEmail = holder.editText_Email.getText().toString();
                String stringPassword = holder.editText_Password.getText().toString();
                databaseHelperClass.updatePassword(new PasswordModelClass(passwordModelClass.getId(),stringEmail,stringPassword));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deletePassword(passwordModelClass.getId());
                password.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return password.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Email;
        EditText editText_Password;
        Button button_edit;
        Button button_delete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.text_id);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Password = itemView.findViewById(R.id.edittext_password);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_edit = itemView.findViewById(R.id.button_edit);
        }
    }
}
