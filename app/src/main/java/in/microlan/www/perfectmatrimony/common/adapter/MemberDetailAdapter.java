package in.microlan.www.perfectmatrimony.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.MemberDetailModel;
import in.microlan.www.perfectmatrimony.authenticate.view.MemberDetailsFragment;

/**
 * Created by Akshaya on 16-05-2017.
 */

public class MemberDetailAdapter extends RecyclerView.Adapter<MemberDetailAdapter.MyViewHolder> {
    private List<MemberDetailModel> detailModels;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);

        }
    }


    public MemberDetailAdapter(List<MemberDetailModel> detailModels, MemberDetailsFragment mainActivity) {
        this.detailModels = detailModels;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_member_detail_fragment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        MemberDetailModel detailModel = detailModels.get(position);
        holder.title.setText(detailModel.getTitle());
        holder.description.setText(detailModel.getDescription());


    }


    @Override
    public int getItemCount() {
        return detailModels.size();
    }


}
