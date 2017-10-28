package in.microlan.www.perfectmatrimony.authenticate.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import java.util.ArrayList;

import in.microlan.www.perfectmatrimony.R;

/**
 * Created by Shefali on 23/10/17.
 */

public class DashBoardCommonFragment extends Fragment {
    protected ProgressDialog progress;
    public DashBoardCommonFragment previousFragment;
    protected FragmentActivity context;
    private FrameLayout mLinearContainerView;
    private Boolean isSensitive = false;
    /* public static List<SelectItem> subjectList = new ArrayList<>();*/
    public DashBoardCommonFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mCommonview = inflater.inflate(R.layout.common_base_layout, container, false);
        setupViews(mCommonview);

        //remove cache if login done
       /* if (AccountDetails.isFreshLogin()) {
            AccountDetails.setFreshLogin(false);
        }*/

        return mCommonview;
    }

    private void setupViews(View mCommonview) {
        mLinearContainerView = (FrameLayout) mCommonview.findViewById(R.id.commonContainerView);

        progress=new ProgressDialog(getActivity());
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(0);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = (FragmentActivity) activity;
    }



    public void setAppTitle(String fragment, String title) {
//        ((PatientCommonActivity) getMainActivity()).setAppTitle(fragment, title);
    }



   /* public void hideAppTitle() {
        ((DashboardActivity) getMainActivity()).hideAppTitle();
    }

    public void hideAppTitle(String className) {
        ((DashboardActivity) getMainActivity()).hideAppTitle(className);
    }*/

    /*public void showDate(TextView edit_text){
        ((PatientCommonActivity) getMainActivity()).showDate(edit_text);

    }*/

    public void goBackOnce() {
        ((DashboardActivity) getMainActivity()).goBackOnce();
    }

    public FragmentActivity getMainActivity() {
        if (context != null) {
            return context;
        } else {
            return super.getActivity();
        }
    }

    protected View attachLayout(int layoutId) {
        View view = null;
        try {
            view = LayoutInflater.from(getMainActivity()).inflate(layoutId, null, false);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mLinearContainerView.addView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void navigateTo(int id, Bundle bundle, FragmentManager fragmentManager, final boolean addStack) {
        InputMethodManager inputManager = (InputMethodManager) getMainActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager.isAcceptingText() && getMainActivity().getCurrentFocus() != null)
            inputManager.hideSoftInputFromWindow(getMainActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        DashBoardCommonFragment fragment = null;
        // PatientCommonActivity.USER USER_TYPE = PatientCommonActivity.USER_TYPE;
        switch (id) {
            /*case NAV_TO_CREATING_MEETING:
                fragment = new CreateMeetingFragment();
                fragment.setArguments(bundle);
                break;
            case NAV_TO_UPDATE_MEETING:
                fragment = new MeetingUpdateFragment();
                fragment.setArguments(bundle);
                break;
            case NAV_TO_MANAGE:
                fragment = new ManageMettingCalls();
                fragment.setArguments(bundle);
                break;

            case NAV_TO_MANAGE_MEETING:
                fragment = new ManageMeetingFragment();
                fragment.setArguments(bundle);
                break;
            case NAV_TO_CREATING_CALL:
                fragment = new CreateCallFragment();
                fragment.setArguments(bundle);
                break;
            *//*case NAV_TO_UPDATE_CALL:
                fragment = new CallUpdateFragment();
                fragment.setArguments(bundle);
                break;*//*
            case NAV_TO_MANAGE_CALL:
                fragment = new ManageMettingCalls();
                ((ManageMettingCalls)fragment).setCurrentItem(1);
                fragment.setArguments(bundle);
                break;*/

            default:
                break;
        }
        if (fragment != null) {
            fragment.previousFragment = this;
            fragment.setArguments(bundle);
            addFragment(R.id.activityFrameLayout, fragment, addStack);
        }


    }

    private void addFragment(int containerViewId, Fragment fragment, boolean addStack) {
        ((DashboardActivity) getMainActivity()).addFragment(containerViewId, fragment, addStack, false);
    }

 /*   public void showProgress() {
        if (getMainActivity() != null) ((PatientCommonActivity) getMainActivity()).showProgress();
    }

    public void hideProgress() {
        if (getMainActivity() != null) ((PatientCommonActivity) getMainActivity()).hideProgress();
    }*/

    public String getString(String key) {
        /*try {
            Hashtable label = (Hashtable) MSFConfig.getParam(getMainActivity(), MSFConfig.LABEL, MSFConfig.CONFIG);
            if (label != null && label.containsKey(key)) {
                // Read from Label Config
                // MSFLog.msg("Value from Label Config - Key = "+key+" value = "+value);
                return (String) label.get(key);
            } else {
                // Read from internal Strings.xml
                if (DataCache.getInstance(getMainActivity()).get(RFILE_REFLECTION_DATA) == null) {
                    Class c = Class.forName(getMainActivity().getPackageName() + ".R$string");
                    MSFHashtable rFileReflectionData = new MSFHashtable();
                    for (Field field : c.getDeclaredFields()) {
                        rFileReflectionData.put(field.getName(), field.get(field.getName()));
                    }
                    DataCache.getInstance(getMainActivity()).put(RFILE_REFLECTION_DATA, rFileReflectionData);
                }

                MSFHashtable rFileReflectionData = (MSFHashtable) DataCache.getInstance(getMainActivity()).get(RFILE_REFLECTION_DATA);
                Integer rId = (Integer) rFileReflectionData.get(key);
                String value = "";
                if (rId != null) value = getString(rId);
                if (value.equals("")) value = "PATIENT";
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return "";
    }



    @Override
    public void onDetach() {
        if (previousFragment != null) previousFragment.onFragmentResult(null);
        super.onDetach();
    }

    public void onFragmentResult(Object data) {
        // configureActionBar(actionBar);
    }

   /* @Override
    public void handleStreamResponse(StreamingResponse response) {
    }*/

    public void onFragmentResume() {

    }

    public void onFragmentPause() {

    }

    public ArrayList<String> getFromPreference(String userName, String assettype, boolean all) {
        /*if (all) {
            return ((PatientCommonActivity) getMainActivity()).getFromPreference(userName);
        } else {
            return ((PatientCommonActivity) getMainActivity()).getFromPreference(userName, assettype.toLowerCase());
        }*/
        return null;
    }

    public void addToPreference(String userName, String assetType, String symbol) {
        //((PatientCommonActivity) getMainActivity()).addToPreference(userName, assetType.toLowerCase(), symbol);
    }

    /*@Override
    public void showMsgOnScreen(int action, String msg, JSONResponse jsonResponse) {
        hideProgress();
        showMessageOnScreenManually(msg);
    }*/

    private void showMessageOnScreenManually(String msg) {
        // showMessageOnScreenManually(msg, R.id.showmsgLayout, R.id.errorHeader);
    }



    public boolean isBlank(String input) {
        if (input == null) {
            return true;
        }
        if (input.trim().length() == 0) {
            return true;
        }

        return false;
    }

    /* public String getSubjectName(String subjectIds){
         String subjectName=null;
         String subjectIdArr[]=subjectIds.split(",");

         for (String id:subjectIdArr){
             for (SelectItem item:subjectList){
                 if(id.equals(item.getCode())){
                    if(subjectName==null){
                        subjectName=item.getValue();
                    }else {
                        subjectName+=","+item.getValue();
                    }
                 }
             }
         }
         return subjectName;
     }*/

}