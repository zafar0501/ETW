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
import in.microlan.www.perfectmatrimony.authenticate.model.NewsFeedModel;

/**
 * Created by Akshaya on 11-05-2017.
 */

public class HelpRecyclerAdapter extends RecyclerView.Adapter<HelpRecyclerAdapter.MyViewHolder> {

    private List<HelpModel> helplList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, desc;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.help_title);

        }
    }


    public HelpRecyclerAdapter(List<HelpModel> helpModelList) {
        this.helplList = helpModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_help, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HelpModel home = helplList.get(position);
        holder.title.setText(home.getTitle());


    }

    @Override
    public int getItemCount() {
        return helplList.size();
    }

}
