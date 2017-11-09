package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.UserProfileInfoModel;
import in.microlan.www.perfectmatrimony.common.adapter.UserProfileRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.base.BaseFragment;
import in.microlan.www.perfectmatrimony.common.presenter.IItemViewAction;
import in.microlan.www.perfectmatrimony.common.presenter.IResultView;


public class NewMatchesListFragment extends BaseFragment implements IItemViewAction, View.OnClickListener, IResultView {

    private Context context;
    private BottomNavigationView bnvFooter;
    private Toolbar homeToolbar;
    private ImageView imageView_back;
    private RecyclerView rcvValidationMessage;
    private RecyclerView rvUserInfo;
    private UserProfileRecyclerAdapter userProfileRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<UserProfileInfoModel> userProfileInfoModelList = new ArrayList<>();
    private UserProfileInfoModel userProfileInfoModel;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitView(view);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void InitView(View view) {

        context = getContext();
        rvUserInfo = (RecyclerView) getActivity().findViewById(R.id.recycler_view);

        userProfileRecyclerAdapter = new UserProfileRecyclerAdapter(userProfileInfoModelList,getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvUserInfo.setLayoutManager(mLayoutManager);
        rvUserInfo.setItemAnimator(new DefaultItemAnimator());
        rvUserInfo.setAdapter(userProfileRecyclerAdapter);
        prepareUserInfoData();

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Toast.makeText(getActivity(),"Going to Implement",Toast.LENGTH_SHORT).show();
            }
        });



    }



    private void prepareUserInfoData() {
        userProfileInfoModel = new UserProfileInfoModel("NAME : Razia Sultan","AGE : 24","HEIGHT : 5'2","WEIGHT : 50","QUALIFICATION : BE (CSE)","https://i.pinimg.com/736x/c2/2b/85/c22b85f2ba99b7b3094cd6c9f08e018c--wallpaper-pictures-hd-wallpaper.jpg");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Zohra Khan","AGE : 26","HEIGHT : 5","WEIGHT : 48","QUALIFICATION : BE (IT)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5xIj9EN765aIXSVtgQijfG4JnRLtTl3nZGqsxXM5WkNnfT-y_Bw");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Rubi Shaikh","AGE : 21","HEIGHT : 5'6","WEIGHT : 52","QUALIFICATION : BE (CIVIL)","http://images.mid-day.com/images/2017/may/ash-cannes-pic-d.jpg");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Shehjadi Begum","AGE : 20","HEIGHT : 5,2","WEIGHT : 50","QUALIFICATION : BE (MECH)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLdj5Jq_rnGt_7r8wqyhXB7aSaGPku7GCJUC0zC1trsX9kge8UWg");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Alia Khan","AGE : 25","HEIGHT : 5,9","WEIGHT : 60","QUALIFICATION : BE (EE)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqKBkjHM46Iqx9abumuuFg3n7JW_SiObEtJCb3d1Ljv4EliQXrOg");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Ajiya Khatoon","AGE : 28","HEIGHT : 6'0","WEIGHT : 65","QUALIFICATION : BE (C TECH)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST56BGi20_FWdTqzi3fizk9hArSWqt_ck4dT1_osGvGpQpE4tofQ");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Saba Khan","AGE : 30","HEIGHT : 4'10","WEIGHT : 48","QUALIFICATION : BE (CT)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLFOC1dcUyEb2U59cyHLHwg9rqPS-8-f9Wi5e6raZmPwSaoqJt");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.new_matches_fragment;
    }



    @Override
    public void onItemRowClick(Object itemDoInfo, int position) {

        switch (position) {
            //notes
            case 0:

                break;

            case 1:

                break;
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }

    @Override
    public void displayErrorList(List errorList) {

    }

    @Override
    public void showResult(Object listDO) {

    }

    @Override
    public void onDisplayMessage(String message) {

    }

    @Override
    public void showResultList(List resultDOList) {

    }

    public void showErrorMessageList(List errorList) {

    }
}
