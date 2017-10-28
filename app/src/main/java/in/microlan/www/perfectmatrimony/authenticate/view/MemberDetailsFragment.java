package in.microlan.www.perfectmatrimony.authenticate.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.MemberDetailModel;
import in.microlan.www.perfectmatrimony.common.adapter.MemberDetailAdapter;
import in.microlan.www.perfectmatrimony.common.base.BaseFragment;

import static android.widget.LinearLayout.VERTICAL;

/**
 * Created by Shefali on 22/10/17.
 */

public class MemberDetailsFragment extends BaseFragment {
    View memberView;
    private List<MemberDetailModel> personalDetail = new ArrayList<>();
    private List<MemberDetailModel> jobDetail = new ArrayList<>();

    private RecyclerView recyclerView;
    public TextView myplace;
    public TextView tvEducation;
    private MemberDetailAdapter personalDetailAdapter;
    private MemberDetailAdapter jobDetailAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        memberView = inflater.inflate(R.layout.fragment_memberdetail, container, false);


        myplace = (TextView) memberView.findViewById(R.id.tvMyPlace);
        recyclerView = (RecyclerView) memberView.findViewById(R.id.rvPersonalDetail);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        personalDetailAdapter = new MemberDetailAdapter(this.personalDetail, MemberDetailsFragment.this);
        recyclerView.setAdapter(personalDetailAdapter);
        personalDetails();

        tvEducation = (TextView) memberView.findViewById(R.id.tvEducation);
        recyclerView = (RecyclerView) memberView.findViewById(R.id.rvJobDetail);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        jobDetailAdapter = new MemberDetailAdapter(jobDetail, MemberDetailsFragment.this);

        recyclerView.setAdapter(jobDetailAdapter);
        jobDetails();

        setLayoutView(memberView);
        return memberView;
    }

    private void jobDetails() {
        jobDetail.add(new MemberDetailModel("Education :", "BE Computers"));
        jobDetail.add(new MemberDetailModel("Job Education :", "BE Computers"));
        jobDetail.add(new MemberDetailModel("Job Details :", "BE Computers"));
        jobDetailAdapter.notifyDataSetChanged();
    }

    private void personalDetails() {
        personalDetail.add(new MemberDetailModel("Date of Birth :", "3 Feb 1993"));
        personalDetail.add(new MemberDetailModel("Age :", "24"));
        personalDetail.add(new MemberDetailModel("Status :", "Single"));
        personalDetail.add(new MemberDetailModel("Lives In :", "Thane"));
        personalDetail.add(new MemberDetailModel("Native Place :", "Kandivali"));
        personalDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void InitView(View view) {

    }

    @Override
    protected int getLayoutResourceId() {
        return 0;
    }
}
