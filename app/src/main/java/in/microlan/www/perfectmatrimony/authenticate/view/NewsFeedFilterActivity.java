package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.adapter.ExpandableListAdapter;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;

public class NewsFeedFilterActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Intent intent;
    private ImageView back_Img;
    TextView toolbarTitle;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


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
        toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);

        toolbarTitle.setText("Sort/Filter");

        back_Img.setOnClickListener(this);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.elvFilter);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    /*
         * Preparing the list data
         */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("State");
        listDataHeader.add("City");
        listDataHeader.add("Category");

        // Adding child data
        List<String> stateList = new ArrayList<String>();
        stateList.add("Maharashtra");
        stateList.add("Karnataka");
        stateList.add("Gujarat");
        stateList.add("West Bengal");


        List<String> cityList = new ArrayList<String>();
        cityList.add("Mumbai");
        cityList.add("Bengaluru");
        cityList.add("Chennai");
        cityList.add("Pune");


        List<String> categoryList = new ArrayList<String>();
        categoryList.add("Category 1");
        categoryList.add("Category 2");
        categoryList.add("Category 3");


        listDataChild.put(listDataHeader.get(0), stateList); // Header, Child data
        listDataChild.put(listDataHeader.get(1), cityList);
        listDataChild.put(listDataHeader.get(2), categoryList);
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
