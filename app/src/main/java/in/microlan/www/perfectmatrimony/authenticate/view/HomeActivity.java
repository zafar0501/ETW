package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import in.microlan.www.perfectmatrimony.R;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{
    private Intent intent;
    private ImageView IMG_SEARCH,IMG_NEWSFEED,IMG_TOWARDS,IMG_COMMUNITY,IMG_ADS,IMG_HELP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        IMG_SEARCH=(ImageView)findViewById(R.id.img_search);
        IMG_NEWSFEED=(ImageView)findViewById(R.id.img_newsfeed);
        IMG_TOWARDS=(ImageView)findViewById(R.id.img_towards);
        IMG_COMMUNITY=(ImageView)findViewById(R.id.img_community);
        IMG_ADS=(ImageView)findViewById(R.id.img_ads);
        IMG_HELP=(ImageView)findViewById(R.id.img_help);

        IMG_SEARCH.setOnClickListener(this);
        IMG_NEWSFEED.setOnClickListener(this);
        IMG_TOWARDS.setOnClickListener(this);
        IMG_COMMUNITY.setOnClickListener(this);
        IMG_ADS.setOnClickListener(this);
        IMG_HELP.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            intent = new Intent(new Intent(getApplicationContext(), SearchActivity.class));

        } else if (id == R.id.nav_newsfeed) {
            intent = new Intent(new Intent(getApplicationContext(), NewsFeedActivity.class));

        } else if (id == R.id.nav_toward) {

            intent = new Intent(new Intent(getApplicationContext(), TowardsActivity.class));
        } else if (id == R.id.nav_community) {

            intent = new Intent(new Intent(getApplicationContext(), CommunityActivity.class));
        } else if (id == R.id.nav_ads) {

            intent = new Intent(new Intent(getApplicationContext(), AdsActivity.class));

        } else if (id == R.id.nav_help) {
            intent = new Intent(new Intent(getApplicationContext(), HelpActivity.class));

        }else if (id == R.id.nav_dashboard) {
            intent = new Intent(new Intent(getApplicationContext(), DashboardActivity.class));

        }
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.img_search:
                intent = new Intent(new Intent(getApplicationContext(), SearchActivity.class));
                break;
            case R.id.img_newsfeed:
                intent = new Intent(new Intent(getApplicationContext(), NewsFeedActivity.class));
                break;
            case R.id.img_towards:
                intent = new Intent(new Intent(getApplicationContext(), TowardsActivity.class));
                break;
            case R.id.img_community:
                intent = new Intent(new Intent(getApplicationContext(), CommunityActivity.class));
                break;
            case R.id.img_ads:
                intent = new Intent(new Intent(getApplicationContext(), AdsActivity.class));
                break;
            case R.id.img_help:
                intent = new Intent(new Intent(getApplicationContext(), HelpActivity.class));
                break;



        }
        startActivity(intent);
    }
}