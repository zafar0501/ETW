package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.NewsFeedModel;
import in.microlan.www.perfectmatrimony.common.adapter.CommunityHelperRecyclerAdap;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.constant.StringConstant;
import in.microlan.www.perfectmatrimony.common.recycleviewtouchlistener.RecyclerTouchListener;

import static in.microlan.www.perfectmatrimony.R.id.rvNewsFeed;
import static in.microlan.www.perfectmatrimony.common.constant.StringConstant.IBundle.BUNDLE_FEATURE;
import static in.microlan.www.perfectmatrimony.common.constant.StringConstant.IBundle.COMMUNITY;

/**
 * Created by Shefali on 11/11/17.
 */

public class CommunityHelperActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView back_Img, ivFilter,ivHistory;
    private Intent intent;
    private RecyclerView rvCommunityHelp;
    private CommunityHelperRecyclerAdap communityHelperRecyclerAdap;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnCommHelp;
    private List<NewsFeedModel> commHelpList = new ArrayList<>();
    private TextView toolbarTitle;
    NewsFeedModel commHelpModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }



    @Override
    public void InitView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back_Img = toolbar.findViewById(R.id.menu_back);
        ivFilter = toolbar.findViewById(R.id.ivFilter);
        ivHistory = toolbar.findViewById(R.id.ivHistory);
        toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);
        ivFilter.setVisibility(View.GONE);
        ivHistory.setVisibility(View.GONE);
        toolbarTitle.setText("Community Helper");
        rvCommunityHelp = (RecyclerView) findViewById(R.id.rvCommunityHelp);
        btnCommHelp = (Button) findViewById(R.id.btnCommHelp);

        communityHelperRecyclerAdap = new CommunityHelperRecyclerAdap(commHelpList, this);
        mLayoutManager = new LinearLayoutManager(this);
        rvCommunityHelp.setLayoutManager(mLayoutManager);
        rvCommunityHelp.setItemAnimator(new DefaultItemAnimator());
        rvCommunityHelp.setAdapter(communityHelperRecyclerAdap);
        commHelpData();
        back_Img.setOnClickListener(this);
        ivFilter.setOnClickListener(this);

        btnCommHelp.setOnClickListener(this);

        rvCommunityHelp.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvCommunityHelp, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                commHelpModel = commHelpList.get(position);
                Toast.makeText(getApplicationContext(), commHelpModel.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                intent = new Intent(CommunityHelperActivity.this, NewsDetailActivity.class);
                intent.putExtra(BUNDLE_FEATURE,COMMUNITY);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
    private void commHelpData() {
        commHelpList.clear();

        commHelpModel = new NewsFeedModel("ABP NEWS ", "STAR News was launched on 18 February 1998. 3 ", R.mipmap.abpnews);
        commHelpList.add(commHelpModel);
        commHelpModel = new NewsFeedModel("AAJ TAK", "फिल्म 'सुल्तान' में एक पहलवान की भूमिका निभाने के लिए वजन बढ़ाने वाले अभिनेता सलमान खान का कहना है कि इसके बाद वजन को कम करना उनके लिए तकलीफदेह रहा. फिल्म में सलमान ने पहलवान सुल्तान का किरदार निभाया था.  ", R.mipmap.ndtvnews);
        commHelpList.add(commHelpModel);
        commHelpModel = new NewsFeedModel("STAR PARIVAR", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.ads);
        commHelpList.add(commHelpModel);
        commHelpModel = new NewsFeedModel("Zee NEWS ", "Zee News reported that some of the students from Democratic Students' Union (DSU) raised slogans such as \"Bharat Ki Barbadi\" (\"Destruction of India\") and \" Pakistan Zindabad\" (\"long live Pakistan\"). ", R.mipmap.zeetv);
        commHelpList.add(commHelpModel);
        commHelpModel = new NewsFeedModel("TENS SPORT", "Sony TEN is a cluster of sports television channels based in India. It generally refers to television channels branded as Sony TEN 1, Sony TEN 2 ", R.mipmap.tenssportnews);
        commHelpList.add(commHelpModel);
        commHelpModel = new NewsFeedModel("SONY TV", "Sony began in the wake of World War II. In 1946, Masaru Ibuka started an electronics shop in a department store building in Tokyo. The company started with a capital of ¥190,000[17] and a total of eight employees.[18] In May 1946", R.mipmap.sonytv);
        commHelpList.add(commHelpModel);
        commHelpModel = new NewsFeedModel("ZEE TV", "News Description.News Description.News Description.News Description.News Description.News Description.News Description.News Description. ", R.mipmap.zeenarathi);
        commHelpList.add(commHelpModel);


        communityHelperRecyclerAdap.notifyDataSetChanged();
    }
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_community_helper;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_back:
                intent = new Intent(CommunityHelperActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                CommunityHelperActivity.this.finish();
                break;

            case R.id.btnCommHelp:
                intent = new Intent(CommunityHelperActivity.this, AddCommRequestActiviy.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
        }
    }
}
