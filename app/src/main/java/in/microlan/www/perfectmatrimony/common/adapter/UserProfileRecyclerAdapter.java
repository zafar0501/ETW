package in.microlan.www.perfectmatrimony.common.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.UserProfileInfoModel;

/**
 * Created by Akshaya on 16-05-2017.
 */

public class UserProfileRecyclerAdapter extends RecyclerView.Adapter<UserProfileRecyclerAdapter.MyViewHolder> {
    private List<UserProfileInfoModel> userProfileInfoModelList;
    private Context context;
    private CircleImageView circleImageView;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Name,Age,Height,Weight,Qualification;



        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.user_name);
            Age = (TextView) view.findViewById(R.id.user_age);
            Height = (TextView) view.findViewById(R.id.user_height);
            Weight = (TextView) view.findViewById(R.id.user_weight);
            Qualification = (TextView) view.findViewById(R.id.user_qualifiaction);
            circleImageView=(CircleImageView) view.findViewById(R.id.user_profile_icon);


        }
    }


    public UserProfileRecyclerAdapter(List<UserProfileInfoModel> userProfileInfoModelList, Activity activity) {
        this.userProfileInfoModelList = userProfileInfoModelList;
        this.context=activity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_userinfo_fragment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        UserProfileInfoModel userProfileInfoModel = userProfileInfoModelList.get(position);
        holder.Name.setText(userProfileInfoModel.getUser_Name());
        holder.Age.setText(userProfileInfoModel.getUser_Age());
        holder.Height.setText(userProfileInfoModel.getUser_Height());
        holder.Weight.setText(userProfileInfoModel.getUser_Weight());
        holder.Qualification.setText(userProfileInfoModel.getUser_Qualification());
        Picasso.with(context)
                .load(userProfileInfoModel.getUser_icon_url())
                .resize(400,400)                        // optional
                .into(circleImageView);




    }


    @Override
    public int getItemCount() {
        return userProfileInfoModelList.size();
    }


}
