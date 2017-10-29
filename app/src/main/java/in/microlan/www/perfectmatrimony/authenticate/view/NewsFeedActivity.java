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

public class NewsFeedActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView back_Img, ivFilter;
    private Intent intent;
    private RecyclerView rvNewsFeed;
    private NewsFeedRecyclerAdapter newsFeedRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<NewsFeedModel> newsFeedList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_news_feed;
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
        ivFilter = toolbar.findViewById(R.id.ivFilter);
        rvNewsFeed = (RecyclerView) findViewById(R.id.rvNewsFeed);

        newsFeedRecyclerAdapter = new NewsFeedRecyclerAdapter(newsFeedList);
        mLayoutManager = new LinearLayoutManager(this);
        rvNewsFeed.setLayoutManager(mLayoutManager);
        rvNewsFeed.setItemAnimator(new DefaultItemAnimator());
        rvNewsFeed.setAdapter(newsFeedRecyclerAdapter);
        prepareHomeData();

        back_Img.setOnClickListener(this);
        ivFilter.setOnClickListener(this);

    }

    private void prepareHomeData() {
        newsFeedList.clear();
        NewsFeedModel home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);
        home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);
        home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);
        home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);
        home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);
        home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);
        home = new NewsFeedModel("News Title", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        newsFeedList.add(home);


        newsFeedRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_back:
                intent = new Intent(NewsFeedActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                NewsFeedActivity.this.finish();
                break;
            case R.id.ivFilter:
                intent = new Intent(NewsFeedActivity.this, NewsFeedFilterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
