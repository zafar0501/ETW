package in.microlan.www.perfectmatrimony.authenticate.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.adapter.CustomViewPager;
import in.microlan.www.perfectmatrimony.common.adapter.DashBoardAdapter;

/**
 * Created by Vishal on 11-05-2017.
 */

public class DashBoardFragment extends DashBoardCommonFragment {
    CustomViewPager viewPager;
    TabPageIndicator homeTabIndicator;
    View homeView;
    Fragment homeFragment, feedFragment, accountFragment, settingFragment;
    ArrayList<Fragment> arrFragOnline = new ArrayList<>();


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        attachLayout(R.layout.fragment_dashboard);
        setUpView(homeView);
        return homeView;
    }



    private void setUpView(View homeView) {

        viewPager = (CustomViewPager) homeView.findViewById(R.id.viewPager);
        homeTabIndicator = (TabPageIndicator) homeView.findViewById(R.id.homeTabIndicator);
        String[] headingClientOnline = new String[4];
        headingClientOnline[0] = "         HOME";
        headingClientOnline[1] = "          FEED";
        headingClientOnline[2] = "      ACCOUNT";
        headingClientOnline[3] = "       SETTING";

        homeFragment = new MemberDetailsFragment();
        feedFragment = new MemberDetailsFragment();
        accountFragment = new MemberDetailsFragment();
        settingFragment = new MemberDetailsFragment();

        arrFragOnline.add(homeFragment);
        arrFragOnline.add(feedFragment);
        arrFragOnline.add(accountFragment);
        arrFragOnline.add(settingFragment);


        final FragmentStatePagerAdapter adapPagerOnline = new DashBoardAdapter(getChildFragmentManager(),
                arrFragOnline, headingClientOnline);
        viewPager.setAdapter(adapPagerOnline);

        homeTabIndicator.setViewPager(viewPager);

        viewPager.setCurrentItem(0);
        viewPager.setPagingEnabled(false);


        homeTabIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //  Log.d(TAG,"onPageScrolled Position: "+position);

            }

            @Override
            public void onPageSelected(int position) {
              /*  Log.d(TAG,"onPageSelected Position: "+position);
                if(position==0) {
                    meetingUpcomingFragment.loadUpcomingMeetings();
                    autoCompleteAdapter.setCurrentSearchType(SEARCH_TYPE_UPCOMING_MEETINGS);
                    autoCompleteAdapter.setMeetingCallList(upcomingMeetingList);
                }
                else if(position==1){
                    meetingUpdateFragment.loadPastMeetings();
                    autoCompleteAdapter.setCurrentSearchType(MeetingConstants.SEARCH_TYPE_UPDATE_MEETINGS);
                    autoCompleteAdapter.setMeetingCallList(pastMeetingList);
                }else {
                    meetingHistoryFragment.loadHistoryMeetings();
                    autoCompleteAdapter.setCurrentSearchType(MeetingConstants.SEARCH_TYPE_HISTORY_MEETINGS);
                    autoCompleteAdapter.setMeetingCallList(historyMeetingList);
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Log.d(TAG,"onPageScrollStateChanged state : "+state);
            }
        });

    }

}























