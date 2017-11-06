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



        NewsFeedModel home = new NewsFeedModel("ABP NEWS ","STAR News was launched on 18 February 1998. 3 ", R.mipmap.abpnews, "0", R.drawable.ic_dislike_icon);
        newsFeedList.add(home);
        home = new NewsFeedModel("AAJ TAK", "फिल्म 'सुल्तान' में एक पहलवान की भूमिका निभाने के लिए वजन बढ़ाने वाले अभिनेता सलमान खान का कहना है कि इसके बाद वजन को कम करना उनके लिए तकलीफदेह रहा. फिल्म में सलमान ने पहलवान सुल्तान का किरदार निभाया था.  ", R.mipmap.ndtvnews, "1", R.drawable.ic_like_icon);
        newsFeedList.add(home);
        home = new NewsFeedModel("STAR PARIVAR", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads, "5", R.drawable.ic_like_icon);
        newsFeedList.add(home);
        home = new NewsFeedModel("Zee NEWS ", "Zee News reported that some of the students from Democratic Students' Union (DSU) raised slogans such as \"Bharat Ki Barbadi\" (\"Destruction of India\") and \" Pakistan Zindabad\" (\"long live Pakistan\"). ", R.mipmap.zeetv, "0", R.drawable.ic_dislike_icon);
        newsFeedList.add(home);
        home = new NewsFeedModel("TENS SPORT", "Sony TEN is a cluster of sports television channels based in India. It generally refers to television channels branded as Sony TEN 1, Sony TEN 2 ", R.mipmap.tenssportnews, "3", R.drawable.ic_like_icon);
        newsFeedList.add(home);
        home = new NewsFeedModel("SONY TV", "Sony began in the wake of World War II. In 1946, Masaru Ibuka started an electronics shop in a department store building in Tokyo. The company started with a capital of ¥190,000[17] and a total of eight employees.[18] In May 1946", R.mipmap.sonytv, "0", R.drawable.ic_dislike_icon);
        newsFeedList.add(home);
        home = new NewsFeedModel("ZEE TV", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.zeenarathi, "3", R.drawable.ic_like_icon);
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
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                NewsFeedActivity.this.finish();
                break;
        }
    }
}
