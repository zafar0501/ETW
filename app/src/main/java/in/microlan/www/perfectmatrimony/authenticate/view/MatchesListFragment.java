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


public class MatchesListFragment extends BaseFragment implements IItemViewAction, View.OnClickListener, IResultView {

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
        userProfileInfoModel = new UserProfileInfoModel("NAME : Sana Hussain","AGE : 24","HEIGHT : 5'2","WEIGHT : 50","QUALIFICATION : BE (CSE)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ6UhvlwxYW4xqKKQOu_19qht7Q0pLl_qRxYMS2CDyiy8WimxC");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Heena Khan","AGE : 26","HEIGHT : 5","WEIGHT : 48","QUALIFICATION : BE (IT)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN46gKP9kRtXv0J-05i4rZ_0w_QpbORtgFA5vTZ02vTbsAbZ_a");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Saba Perveen","AGE : 21","HEIGHT : 5'6","WEIGHT : 52","QUALIFICATION : BE (CIVIL)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGeI-LsSLgTmOiPNDHBB0ebgaVY_q04JFfXLeKT1MPIJLA2TUyTg");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Alfaa Begum","AGE : 20","HEIGHT : 5,2","WEIGHT : 50","QUALIFICATION : BE (MECH)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKzzv89kc23QhFs8E9ume2pnJhJRK3Gvxz7k-dzMylfMC8CX4J");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Sufiyana kaif","AGE : 25","HEIGHT : 5,9","WEIGHT : 60","QUALIFICATION : BE (EE)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3mH1b6Ls4KUgQZNqRb_aFIPTx5q0aqn5j9-4z22ln7id1OqA7");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Diya Khan","AGE : 28","HEIGHT : 6'0","WEIGHT : 65","QUALIFICATION : BE (C TECH)","https://i.pinimg.com/736x/a6/02/e6/a602e6c8c300bcae750bf88d2b28e41b--katrina-wallpaper-katrina-kaif-wallpapers.jpg");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Rubi Khan","AGE : 30","HEIGHT : 4'10","WEIGHT : 48","QUALIFICATION : BE (CT)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5x_WjHgIguAegI-ze75-o57uWpZnUUmXY81yrJDWjDp3RrmCXhw");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileInfoModel = new UserProfileInfoModel("NAME : Juhi Khan","AGE : 22","HEIGHT : 4,6","WEIGHT : 52","QUALIFICATION : BE (ECE)","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ6UhvlwxYW4xqKKQOu_19qht7Q0pLl_qRxYMS2CDyiy8WimxC");
        userProfileInfoModelList.add(userProfileInfoModel);
        userProfileRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.matches_fragment;
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
