package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.HelpModel;
import in.microlan.www.perfectmatrimony.common.adapter.HelpRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.recycleviewtouchlistener.RecyclerTouchListener;

public class HelpActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView back_Img;
    private Intent intent;
    private RecyclerView rvHelp;
    private HelpRecyclerAdapter helpRecyclerAdapter;
    private List<HelpModel> helpModelList = new ArrayList<>();
    private HelpModel helpModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_help;
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back_Img = toolbar.findViewById(R.id.menu_back);
        back_Img.setOnClickListener(this);
        rvHelp = (RecyclerView) findViewById(R.id.recycler_view_help);

        helpRecyclerAdapter = new HelpRecyclerAdapter(helpModelList);
        prepareHelpData();
        rvHelp.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvHelp.setLayoutManager(mLayoutManager);
        rvHelp.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvHelp.setItemAnimator(new DefaultItemAnimator());
        rvHelp.setAdapter(helpRecyclerAdapter);

        rvHelp.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvHelp, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                HelpModel helpModel = helpModelList.get(position);
                Toast.makeText(getApplicationContext(), helpModel.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void prepareHelpData() {
        helpModel = new HelpModel("Any Help Regarding Donation");
        helpModelList.add(helpModel);
        helpModel = new HelpModel("Blood Donate");
        helpModelList.add(helpModel);
        helpModel = new HelpModel("Help from Our Support Team");
        helpModelList.add(helpModel);
        helpModel = new HelpModel("Call us 24/7");
        helpModelList.add(helpModel);
        helpModel = new HelpModel("help@care.in");
        helpModelList.add(helpModel);
        helpRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_back:
                intent = new Intent(HelpActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                HelpActivity.this.finish();
                break;

        }

    }


}
