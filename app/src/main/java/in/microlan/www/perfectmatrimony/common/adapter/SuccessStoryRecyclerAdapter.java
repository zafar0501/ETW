package in.microlan.www.perfectmatrimony.common.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.MyMatrimonyModel;

/**
 * Created by Akshaya on 11-05-2017.
 */

public class SuccessStoryRecyclerAdapter extends RecyclerView.Adapter<SuccessStoryRecyclerAdapter.MyViewHolder> {

    private List<MyMatrimonyModel> myMatrimonyModelList;
    private Context context;
    private ImageView icon;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.profile_name);
            age = (TextView) view.findViewById(R.id.profile_age);
            icon = (ImageView) view.findViewById(R.id.profile_image);


        }
    }


    public SuccessStoryRecyclerAdapter(Context context, List<MyMatrimonyModel> myMatrimonyModelList) {
        this.myMatrimonyModelList = myMatrimonyModelList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_success_story, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyMatrimonyModel matrimonyModel = myMatrimonyModelList.get(position);
        holder.name.setText(matrimonyModel.getName());
        holder.age.setText(matrimonyModel.getAge());
        //Loading Image from URL
        Picasso.with(context)
                .load(matrimonyModel.getIcon_url())
                .resize(400,400)                        // optional
                .into(icon);


    }

    @Override
    public int getItemCount() {
        return myMatrimonyModelList.size();
    }

}
