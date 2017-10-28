package in.microlan.www.perfectmatrimony.authenticate.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.adapter.CustomAlertDialog;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;

/**
 * Created by Shefali on 23/10/17.
 */

public class DashboardActivity extends FragmentActivity {
    private RelativeLayout progressLayout;

    /*@Override
    public void InitView() {
        progressLayout = (RelativeLayout) findViewById(R.id.customProgress);


    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        progressLayout = (RelativeLayout) findViewById(R.id.customProgress);
        setupDefaultFragment(getIntent());

    }

    private void setupDefaultFragment(Intent data) {
       /* args.clear();
        args.putInt("Source", 0);*/
        setupFragment(new DashBoardFragment());
    }

    public void showProgress() {
        if (progressLayout != null) progressLayout.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressLayout.setVisibility(View.GONE);
    }

    public void goBackOnce() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Get the last fragment tag from FragmentManager.BackStackEntry
        DashBoardCommonFragment currentFragment;
        FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);
        String tag = backEntry.getName();

        // If getBackStackEntryCount != 0 , then pause the closing
        // fragment before calling popBackStackImmediate()
        DashBoardCommonFragment closingFragment = (DashBoardCommonFragment) fragmentManager.findFragmentByTag(tag);
        closingFragment.onFragmentPause();

        // Close the current fragment
        fragmentManager.popBackStackImmediate();

        if (fragmentManager.getBackStackEntryCount() != 0) {

            // Get the last fragment in back task after
            // popBackStackImmediate() to resume the current
            // fragment
            backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);
            tag = backEntry.getName();
            currentFragment = (DashBoardCommonFragment) fragmentManager.findFragmentByTag(tag);

        } else {
            // Last fragment is not attached to back stack. So get
            // the fragment by id and resume the fragment.
            currentFragment = (DashBoardCommonFragment) fragmentManager.findFragmentById(R.id.activityFrameLayout);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            Log.d("Called", "on Back Press Also" + keyCode);


            if (progressLayout.getVisibility() == View.VISIBLE) {
                progressLayout.setVisibility(View.GONE);
                return false;
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() == 1) {
                CustomAlertDialog.alertDialog(this, 0, "Patient App", "Do you want to exit the application?", "Yes", "No", true, new CustomAlertDialog.DialogListener() {

                    @Override
                    public void alertDialogAction(CustomAlertDialog.Action action, Object... data) {
                        if (action == CustomAlertDialog.Action.OK) {
                            finish();

                        }
                    }
                });
            } else {
                goBackOnce();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    public void setupFragment(DashBoardCommonFragment fragment) {
        addFragment(R.id.activityFrameLayout, fragment, true, getSupportFragmentManager(), true);
    }

    public void addFragment(int containerViewId, Fragment fragment, boolean addStack, FragmentManager fragmentManager, boolean isReplace) {
        addFragment(containerViewId, fragment, addStack, isReplace);
    }

    public void addFragment(int containerViewId, Fragment fragment, boolean addStack, boolean isReplace) {
        if (fragment == null) {
            //  MSFLog.error("Fragment is null.");
            Log.e("PatientCommonActivity", "Fragment is null.");
            return;
        }

//        if (!addStack) clearTitles();

        // if (fragmentManager == null)
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String tag = fragment.getClass().toString();

        if (fragmentManager.getBackStackEntryCount() != 0) {
            FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);

            // Pause the current fragment before adding new fragment
            DashBoardCommonFragment currentFragment = (DashBoardCommonFragment) fragmentManager.findFragmentByTag(backEntry.getName());

            currentFragment.onFragmentPause();
        } else {
            // Last fragment is not attached to back stack. So get
            // the fragment by id and pause the current fragment.
            DashBoardCommonFragment currentFragment = (DashBoardCommonFragment) fragmentManager.findFragmentById(containerViewId);
            if (currentFragment != null) currentFragment.onFragmentPause();
        }

        if (!addStack) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentManager.executePendingTransactions();
        }

        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {

            if (addStack) fragmentTransaction.add(containerViewId, fragment, tag);
            else {
                fragmentTransaction.replace(containerViewId, fragment, tag);
            }
        }

        if (addStack) {
            fragmentTransaction.addToBackStack(tag);
        } else {
            fragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
        if (!addStack) ((DashBoardCommonFragment) fragment).onFragmentResume();
    }

}
