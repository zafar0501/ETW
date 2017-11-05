package in.microlan.www.perfectmatrimony.common.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.HelpModel;
import in.microlan.www.perfectmatrimony.authenticate.model.MyMatrimonyModel;
import in.microlan.www.perfectmatrimony.authenticate.view.MyMatrimonyActivity;

/**
 * Created by Akshaya on 11-05-2017.
 */

public class SuccessProfileRecyclerAdapter extends RecyclerView.Adapter<SuccessProfileRecyclerAdapter.MyViewHolder> {

    private List<MyMatrimonyModel> myMatrimonyModelList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.profile_name);
            age = (TextView) view.findViewById(R.id.profile_age);
            icon = (ImageView) view.findViewById(R.id.profile_image);

        }
    }


    public SuccessProfileRecyclerAdapter(List<MyMatrimonyModel> myMatrimonyModelList) {
        this.myMatrimonyModelList = myMatrimonyModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_success_story, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyMatrimonyModel home = myMatrimonyModelList.get(position);
        holder.name.setText(home.getName());
        holder.age.setText(home.getAge());


    }

    @Override
    public int getItemCount() {
        return myMatrimonyModelList.size();
    }

}
