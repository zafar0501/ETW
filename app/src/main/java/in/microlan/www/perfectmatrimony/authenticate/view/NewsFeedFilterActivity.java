package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.NewsFeedModel;
import in.microlan.www.perfectmatrimony.common.adapter.NewsFeedRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;

public class NewsFeedFilterActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView back_Img;
    private Intent intent;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_news_feed_filter;
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


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_back:
                intent = new Intent(NewsFeedFilterActivity.this, NewsFeedActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                NewsFeedFilterActivity.this.finish();
                break;

        }
    }
}
