package in.microlan.www.perfectmatrimony.authenticate.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.HelpModel;
import in.microlan.www.perfectmatrimony.authenticate.model.MyMatrimonyModel;
import in.microlan.www.perfectmatrimony.common.adapter.FeaturesProfileRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.adapter.HelpRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.adapter.NewestProfileRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.adapter.SuccessStoryRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.recycleviewtouchlistener.RecyclerTouchListener;

public class MyMatrimonyActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_Img;
    private Intent intent;

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView rc_succes_story,rc_feautres_profile,rc_newest_profile;
    private SuccessStoryRecyclerAdapter successStoryRecyclerAdapter;
    private NewestProfileRecyclerAdapter newestProfileRecyclerAdapter;
    private FeaturesProfileRecyclerAdapter featuresProfileRecyclerAdapter;
    private LinearLayoutManager horizontalLayoutManagaer;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<MyMatrimonyModel> myMatrimonyModelList_Success_Story  = new ArrayList<>();
    private List<MyMatrimonyModel> myMatrimonyModelList_Newest_Profile = new ArrayList<>();
    private List<MyMatrimonyModel> myMatrimonyModelList_Features_Profile  = new ArrayList<>();
    private MyMatrimonyModel myMatrimonyModel;
    private Context context;
    private TextView txt_edit_option;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_matrimony;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void InitView() {
        context=this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back_Img = toolbar.findViewById(R.id.menu_back);
        back_Img.setOnClickListener(this);
        txt_edit_option= (TextView) findViewById(R.id.edit_option);
        txt_edit_option.setOnClickListener(this);
        rc_succes_story = (RecyclerView) findViewById(R.id.recycler_view_sucess_story);
        rc_newest_profile = (RecyclerView) findViewById(R.id.recycler_view_new_profile);
        rc_feautres_profile = (RecyclerView) findViewById(R.id.recycler_view_feautes_profile);

        successStoryRecyclerAdapter = new SuccessStoryRecyclerAdapter(context,myMatrimonyModelList_Success_Story);
        newestProfileRecyclerAdapter = new NewestProfileRecyclerAdapter(context,myMatrimonyModelList_Newest_Profile);
        featuresProfileRecyclerAdapter = new FeaturesProfileRecyclerAdapter(context,myMatrimonyModelList_Features_Profile);


        prepareSuccessStory();
        prepareFeautresProfile();
        prepareNewestProfile();


        //RC FOR SUCCESS STORY
        rc_succes_story.setHasFixedSize(true);


        horizontalLayoutManagaer = new LinearLayoutManager(MyMatrimonyActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rc_succes_story.setLayoutManager(horizontalLayoutManagaer);
        rc_succes_story.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        rc_succes_story.setItemAnimator(new DefaultItemAnimator());
        rc_succes_story.setAdapter(successStoryRecyclerAdapter);

        //RC FOR Newest Profile
        rc_newest_profile.setHasFixedSize(true);
        horizontalLayoutManagaer = new LinearLayoutManager(MyMatrimonyActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rc_newest_profile.setLayoutManager(horizontalLayoutManagaer);
        rc_newest_profile.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        rc_newest_profile.setItemAnimator(new DefaultItemAnimator());
        rc_newest_profile.setAdapter(newestProfileRecyclerAdapter);


        //RC FOR Features Profile
        rc_feautres_profile.setHasFixedSize(true);
        horizontalLayoutManagaer = new LinearLayoutManager(MyMatrimonyActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rc_feautres_profile.setLayoutManager(horizontalLayoutManagaer);
        rc_feautres_profile.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        rc_feautres_profile.setItemAnimator(new DefaultItemAnimator());
        rc_feautres_profile.setAdapter(featuresProfileRecyclerAdapter);

        rc_succes_story.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rc_succes_story, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                myMatrimonyModel = myMatrimonyModelList_Success_Story.get(position);
                Toast.makeText(getApplicationContext(), myMatrimonyModel.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        rc_newest_profile.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rc_newest_profile, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                myMatrimonyModel  = myMatrimonyModelList_Newest_Profile.get(position);
                Toast.makeText(getApplicationContext(), myMatrimonyModel.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        rc_feautres_profile.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rc_feautres_profile, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                myMatrimonyModel  = myMatrimonyModelList_Newest_Profile.get(position);
                Toast.makeText(getApplicationContext(), myMatrimonyModel.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void prepareSuccessStory() {
        myMatrimonyModel = new MyMatrimonyModel("Katrina Kaif","32","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ6UhvlwxYW4xqKKQOu_19qht7Q0pLl_qRxYMS2CDyiy8WimxC");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Hina Saikh ","24","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN46gKP9kRtXv0J-05i4rZ_0w_QpbORtgFA5vTZ02vTbsAbZ_a");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Sana Khan ","20","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGeI-LsSLgTmOiPNDHBB0ebgaVY_q04JFfXLeKT1MPIJLA2TUyTg");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Khushboo Saikh","25","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKzzv89kc23QhFs8E9ume2pnJhJRK3Gvxz7k-dzMylfMC8CX4J");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Nazia Khan","25","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3mH1b6Ls4KUgQZNqRb_aFIPTx5q0aqn5j9-4z22ln7id1OqA7");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Alfa Khan","25","https://i.pinimg.com/736x/a6/02/e6/a602e6c8c300bcae750bf88d2b28e41b--katrina-wallpaper-katrina-kaif-wallpapers.jpg");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Sainaz Khan","22","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5x_WjHgIguAegI-ze75-o57uWpZnUUmXY81yrJDWjDp3RrmCXhw");
        myMatrimonyModelList_Success_Story.add(myMatrimonyModel);
        successStoryRecyclerAdapter.notifyDataSetChanged();
    }
    private void prepareNewestProfile() {
        myMatrimonyModel = new MyMatrimonyModel("Razia Sulatana","22","https://i.pinimg.com/736x/c2/2b/85/c22b85f2ba99b7b3094cd6c9f08e018c--wallpaper-pictures-hd-wallpaper.jpg");
        myMatrimonyModelList_Newest_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Zohra Khan ","25","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5xIj9EN765aIXSVtgQijfG4JnRLtTl3nZGqsxXM5WkNnfT-y_Bw");
        myMatrimonyModelList_Newest_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Rubi Shaikh","24","http://images.mid-day.com/images/2017/may/ash-cannes-pic-d.jpg");
        myMatrimonyModelList_Newest_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Sehzadi Begum","21","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLdj5Jq_rnGt_7r8wqyhXB7aSaGPku7GCJUC0zC1trsX9kge8UWg");
        myMatrimonyModelList_Newest_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Alia Khan ","28","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqKBkjHM46Iqx9abumuuFg3n7JW_SiObEtJCb3d1Ljv4EliQXrOg");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Ajia Khantoon ","25","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST56BGi20_FWdTqzi3fizk9hArSWqt_ck4dT1_osGvGpQpE4tofQ");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Juhi Khan ","21","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLFOC1dcUyEb2U59cyHLHwg9rqPS-8-f9Wi5e6raZmPwSaoqJt");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        successStoryRecyclerAdapter.notifyDataSetChanged();
    }
    private void prepareFeautresProfile() {
        myMatrimonyModel = new MyMatrimonyModel("Jhumki Khan","22","http://mrpopat.in/admin/upload/wallpaper/201610271477553655936006742.jpg");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Sama Parveen ","23","http://3.bp.blogspot.com/-ri2TdzMOElI/UCd6Ck-xSKI/AAAAAAAAF5Q/WsGuJR0-IHk/s1600/Kareena+Kapoor+%2815%29.jpg");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Zeenat Parveen ","24","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCJ-lOzbY4vxM-ht-ecO__ZWvz9wGYCjrQzfoOC7CeEyQRR0XE");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Sultana Khantoon ","25","https://3.bp.blogspot.com/-mVtltQ8a9xE/Wav-vnWNULI/AAAAAAAAAHg/vRfpiTWMkmssX1cN7wUL_vZegsfk_pZiACLcBGAs/s1600/kareena%2Bkapoor%2Bwallpapers%2Bin%2Bbodyguard..jpg");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Komal Khantoon ","21","https://hdwallsource.com/img/2016/2/kareena-kapoor-glasses-wallpaper-54914-56650-hd-wallpapers.jpg");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Hina Khantoon ","20","http://mobi-wall.brothersoft.com/files/240400/k/12832545192805.jpg");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        myMatrimonyModel = new MyMatrimonyModel("Tania Khan ","25","http://2.bp.blogspot.com/-_WTEl47HCj0/Vecfj-BReAI/AAAAAAAA6Vs/p8m8uPJ2fLc/s640/kareena%2Bkapoor%2BHD%2BWallpapers%2BFee%2BDownload1.png");
        myMatrimonyModelList_Features_Profile.add(myMatrimonyModel);
        successStoryRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_back:
                intent = new Intent(MyMatrimonyActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                MyMatrimonyActivity.this.finish();
                break;
            case R.id.edit_option:
                showChangeLangDialog();
                break;


        }

    }

    private void showChangeLangDialog() {
        // custom dialog
        final Dialog openDialog = new Dialog(context);
        openDialog.setContentView(R.layout.profile_alert_dailog);
        openDialog.setTitle("MyMatrimony");

        openDialog.show();
    }


}