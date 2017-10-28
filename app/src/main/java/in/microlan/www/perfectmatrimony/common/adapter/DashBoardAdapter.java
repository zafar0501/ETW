package in.microlan.www.perfectmatrimony.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

import java.util.ArrayList;

import in.microlan.www.perfectmatrimony.R;

/**
 * Created by Vishal on 13-Sep-16.
 */
public class DashBoardAdapter extends FragmentStatePagerAdapter implements IconPagerAdapter {
    private final int[] icons = new int[]{
            R.drawable.tab_home_bg,
            R.drawable.tab_home_bg,
            R.drawable.tab_home_bg,
            R.drawable.tab_home_bg};


    private final String[] pageTitles;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public DashBoardAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList, String[] pageTitles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.pageTitles = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }

    @Override
    public int getIconResId(int index) {
        return icons[index];
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}