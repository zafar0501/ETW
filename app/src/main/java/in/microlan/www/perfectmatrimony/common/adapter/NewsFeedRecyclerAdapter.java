package in.microlan.www.perfectmatrimony.common.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.NewsFeedModel;

/**
 * Created by Akshaya on 11-05-2017.
 */

public class NewsFeedRecyclerAdapter extends RecyclerView.Adapter<NewsFeedRecyclerAdapter.MyViewHolder> {

    private List<NewsFeedModel> newsFeedlList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, desc;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.item1);
            desc = (TextView) view.findViewById(R.id.desc1);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }


    public NewsFeedRecyclerAdapter(List<NewsFeedModel> newsFeedlList) {
        this.newsFeedlList = newsFeedlList;
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
        holder.icon.setImageResource(home.getIcon());

    }

    @Override
    public int getItemCount() {
        return newsFeedlList.size();
    }

}
