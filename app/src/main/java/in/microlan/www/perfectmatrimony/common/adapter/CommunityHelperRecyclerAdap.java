package in.microlan.www.perfectmatrimony.common.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.NewsFeedModel;

import static in.microlan.www.perfectmatrimony.R.id.ivLike;

/**
 * Created by Shefali on 11/11/17.
 */

public class CommunityHelperRecyclerAdap extends RecyclerView.Adapter<CommunityHelperRecyclerAdap.MyViewHolder> {

    private List<NewsFeedModel> commHelplList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, desc;
        public ImageView icon;
        CardView cvCommHelpItem;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.item1);
            desc = (TextView) view.findViewById(R.id.desc1);
            icon = (ImageView) view.findViewById(R.id.icon);
            /*tvLikes = (TextView) view.findViewById(R.id.tvLikes);
            ivLike = (ImageView) view.findViewById(R.id.ivLike);*/


            cvCommHelpItem = (CardView) view.findViewById(R.id.cvCommHelpItem);
            view.setOnClickListener(this);
//            ivLike.setOnClickListener(this);
            icon.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case ivLike:
                {
                    Toast.makeText(activity, "Like Button Click", Toast.LENGTH_SHORT).show();
                }
                break;
                case R.id.icon:
                {
                    Toast.makeText(activity, "Icon Button Click", Toast.LENGTH_SHORT).show();
                }
                break;
            }
//            clickListener.onClick(v, getPosition(), false);


        }

    }


    public CommunityHelperRecyclerAdap(List<NewsFeedModel> commHelplList, Activity activity) {
        this.commHelplList = commHelplList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_comm_help, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsFeedModel home = commHelplList.get(position);
        holder.title.setText(home.getTitle());
        holder.desc.setText(home.getDesc());
       /* holder.tvLikes.setText(home.getLikesCount());
        holder.ivLike.setImageResource(home.getLikeStatus());*/
        holder.icon.setImageResource(home.getIcon());

        holder.cvCommHelpItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*holder.cvCommHelpItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ivLike: {
                        Toast.makeText(activity, "Like Button Click", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case R.id.icon: {
                        Toast.makeText(activity, "Icon Button Click", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }

            }

        });*/

    }

    @Override
    public int getItemCount() {
        return commHelplList.size();
    }
}

