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

/**
 * Created by Akshaya on 11-05-2017.
 */

public class NewsFeedRecyclerAdapter extends RecyclerView.Adapter<NewsFeedRecyclerAdapter.MyViewHolder> {

    private List<NewsFeedModel> newsFeedlList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, desc, tvLikes;
        public ImageView icon, ivLike;
        CardView cvNewsfeedItem;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.item1);
            desc = (TextView) view.findViewById(R.id.desc1);
            tvLikes = (TextView) view.findViewById(R.id.tvLikes);
            icon = (ImageView) view.findViewById(R.id.icon);
            ivLike = (ImageView) view.findViewById(R.id.ivLike);
            cvNewsfeedItem = (CardView) view.findViewById(R.id.cvNewsfeedItem);
            view.setOnClickListener(this);
            ivLike.setOnClickListener(this);
            icon.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case R.id.ivLike:
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

        /*@Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), NewsDetailActivity.class);
            v.getContext().startActivity(intent);
            activity.overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

        }*/
    }


    public NewsFeedRecyclerAdapter(List<NewsFeedModel> newsFeedlList, Activity activity) {
        this.newsFeedlList = newsFeedlList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_view_news_feed, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsFeedModel home = newsFeedlList.get(position);
        holder.title.setText(home.getTitle());
        holder.desc.setText(home.getDesc());
        holder.tvLikes.setText(home.getLikesCount());
        holder.icon.setImageResource(home.getIcon());
        holder.ivLike.setImageResource(home.getLikeStatus());
        holder.cvNewsfeedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.cvNewsfeedItem.setOnClickListener(new View.OnClickListener() {
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

        });

    }

    @Override
    public int getItemCount() {
        return newsFeedlList.size();
    }
}
