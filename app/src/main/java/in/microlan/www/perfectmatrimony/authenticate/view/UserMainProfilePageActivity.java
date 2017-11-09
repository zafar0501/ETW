package in.microlan.www.perfectmatrimony.authenticate.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.NewsFeedModel;
import in.microlan.www.perfectmatrimony.authenticate.model.UserProfileInfoModel;
import in.microlan.www.perfectmatrimony.common.adapter.NewsFeedRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.adapter.UserProfileRecyclerAdapter;
import in.microlan.www.perfectmatrimony.common.constant.StringConstant;
import in.microlan.www.perfectmatrimony.utility.HelperUtility;

public class UserMainProfilePageActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextMessage;
    private Toolbar toolbar;
    private ImageView menu_home,menu_chat,menu_bell;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_matches:
                    mTextMessage.setText(R.string.title_matches);
                    matchesFragment();
                    return true;
                case R.id.navigation_new_matches:
                    mTextMessage.setText(R.string.title_new_matches);
                    newmatchesFragment();
                    return true;
                case R.id.navigation_shortlisted:
                    mTextMessage.setText(R.string.title_shortlisted);
                    shortlistedFragment();
                    return true;
                case R.id.navigation_viewed:
                    mTextMessage.setText(R.string.title_viewed);
                    viewedFragment();
                    return true;
            }
            return false;
        }

    };

    private void matchesFragment() {
            HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                    new MatchesListFragment(), StringConstant.FragmentTag.MATCHES_TAG);
    }
    private void newmatchesFragment() {

        HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                new NewMatchesListFragment(), StringConstant.FragmentTag.NEW_MATCHES_TAG);
    }
    private void shortlistedFragment() {

        HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                new ShortlistedFragment(), StringConstant.FragmentTag.SHORTLISTED_TAG);
    }
    private void viewedFragment() {

        HelperUtility.ReplaceFragmentWithoutBackStack(getSupportFragmentManager(), R.id.fl_home_container,
                new ViewedListFragment(), StringConstant.FragmentTag.VIEWED_TAG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_profile_page);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        matchesFragment();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        menu_home = toolbar.findViewById(R.id.menu_home);
        menu_chat = toolbar.findViewById(R.id.menu_chat);
        menu_bell = toolbar.findViewById(R.id.menu_bell);

        menu_home.setOnClickListener(this);
        menu_chat.setOnClickListener(this);
        menu_bell.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.menu_home:
            {
                Intent intent = new Intent(UserMainProfilePageActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                UserMainProfilePageActivity.this.finish();
            }
            break;
            case R.id.menu_chat:
            {
                Toast.makeText(getApplicationContext(),"Chat",Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.menu_bell:
            {
                Toast.makeText(getApplicationContext(),"Bell",Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}
