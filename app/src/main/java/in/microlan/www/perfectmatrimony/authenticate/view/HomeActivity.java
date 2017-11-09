package in.microlan.www.perfectmatrimony.authenticate.view;
import android.content.Context;
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
import android.widget.ScrollView;

import in.microlan.www.perfectmatrimony.R;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{

    private Intent intent;
    private ImageView IMG_SEARCH,IMG_NEWSFEED,IMG_TOWARDS,IMG_COMMUNITY,IMG_ADS,IMG_HELP;
    private ImageView IMG_DOWN_ARRAY;
    private ScrollView scrollView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context=this;
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
        IMG_DOWN_ARRAY=(ImageView)findViewById(R.id.img_downarrow_focus);
        scrollView = (ScrollView)findViewById(R.id.scv_login_scroll);

        IMG_SEARCH.setOnClickListener(this);
        IMG_NEWSFEED.setOnClickListener(this);
        IMG_TOWARDS.setOnClickListener(this);
        IMG_COMMUNITY.setOnClickListener(this);
        IMG_ADS.setOnClickListener(this);
        IMG_HELP.setOnClickListener(this);
        IMG_DOWN_ARRAY.setOnClickListener(this);


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

        if (id == R.id.nav_mymatrimony) {
            intent = new Intent(new Intent(context, MyMatrimonyActivity.class));
            startActivity(intent);

        }   else if (id == R.id.nav_verify) {

            intent = new Intent(new Intent(context, VerifyUsersActivity.class));
            startActivity(intent);

        } else if (id == R.id.nav_changepassword) {
            intent = new Intent(new Intent(context, ChangePasswordActivity.class));
            startActivity(intent);

        }
        else if (id == R.id.nav_user_main_profile_page) {
            intent = new Intent(new Intent(context, UserMainProfilePageActivity.class));
            startActivity(intent);

        }else if (id == R.id.nav_dashboard) {
            intent = new Intent(new Intent(context, DashboardActivity.class));
            startActivity(intent);
        }else if (id == R.id.nav_send) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        }else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.img_search:
                intent = new Intent(new Intent(context, SearchActivity.class));
                startActivity(intent);
                break;
            case R.id.img_newsfeed:
                intent = new Intent(new Intent(context, NewsFeedActivity.class));
                startActivity(intent);
                break;
            case R.id.img_towards:
                intent = new Intent(new Intent(context, TowardsActivity.class));
                startActivity(intent);
                break;
            case R.id.img_community:
                intent = new Intent(new Intent(context, CommunityActivity.class));
                startActivity(intent);
                break;
            case R.id.img_ads:
                intent = new Intent(new Intent(context, AdsActivity.class));
                startActivity(intent);
                break;
            case R.id.img_help:
                intent = new Intent(new Intent(context, HelpActivity.class));
                startActivity(intent);
                break;
            case R.id.img_downarrow_focus:
                scrollView.scrollTo(0, scrollView.getBottom());
                break;






        }



    }

}