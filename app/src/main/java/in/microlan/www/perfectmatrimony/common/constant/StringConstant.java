package in.microlan.www.perfectmatrimony.common.constant;


public class StringConstant {

    public interface IPreference {
        String ETW_PREF = "ETWPref";
        String ETW_PREF_LOGINCRENEDTIAL = "ETWPrefLoginCredential";
        String IS_USER_LOGGED_PREF = "IsUserLoggedPref";
        String IS_USER_ADD_REPLY_NOTE = "IsUserAddReplyNote";
        String AUTH_TOKEN_PREF = "AuthTokenPref";
        String USER_ID = "User_ID";
        String USER_FIRST_NAME = "FirstName";
        String USER_LAST_NAME = "LastName";
        String USER_TITLE = "Title";

        String USER_COMPANY_ID = "CompanyID";
        String USER_NAME = "UserName";
        String USER_PASSWORD = "Password";
        String DEVICE_TOKEN = "DeviceToken";

    }


    public interface ICommon {
        String HEADER_AUTHORIZATION = "Authorization=";
        String CONTENT_TYPE = "application/json";

    }

    public interface IGoalConstants {
        String PERFORMANCE_GOAL = "Performance Goals";
        String ROLE_GOAL = "Role Goals";
        String GOAL = "Goal";
        String PLAN = "Plan";
        String UNTITLED_PLAN = "Untitled Plan";

    }

    public interface FingerPrintStatus {
        int FingerPrintStatus = 0;
        final static int FPAuthNotSupported = 0;
        final static int FPAuthNotSelected = 1;
        final static int FPAuthSelected_TNCNotAccepted = 2;
        final static int FPAuthSelected_TNCAccepted = 3;

    }

    public interface IBundle {

        String BUNDLE_GOAL_NOTES = "bundleGoalNotes";
        String BUNDLE_GOAL_ID = "bundleGoalId";
        String BUNDLE_GOAL_TYPE = "bundleGoalType";
        String BUNDLE_GOAL_STATUS = "bundleGoalStatus";
        String BUNDLE_IS_FROM_NOTE_LIST = "bundleFromNoteList";
        String BUNDLE_IS_FROM_ARCHIVE_LIST = "bundleFromArchiveList";
        String BUNDLE_IS_FROM_GOAL_LIST = "bundleFromGoalList";
        String BUNDLE_NOTE_MESSAGE_ID = "bundleNoteMessageId";
        String BUNDLE_IS_NOTE_ARCHIVE = "bundleIsNoteArchive";
        String BUNDLE_IS_TOTAL_SWIPED_NOTES = "bundleIsTotalSwipeNotes";
        String BUNDLE_GOAL_INFO = "bundleGoalInfo";
        String BUNDLE_PASSWORD = "bundlePassword";
        String BUNDLE_RESULT_RECEIVER = "bundleResultReceiver";
    }

    public interface DeviceBrandInfo {
        final static String SAMSUNG_BRAND = "SAMSUNG";
    }


    public interface FragmentTag {

        String HOME_DETAIL_TAG = "homeDetailTag";
        String NOTES_LIST_TAG = "notesListTag";
        String GOALS_LIST_TAG = "goalsListTag";
        String TNC_LIST_TAG = "tncListTag";
        String GOALS_NOTES_LIST_TAG = "goalsNotesListTag";
        String GOALS_NOTES_REPLY_TAG = "goalsNotesReplyTag";
        String CHANGE_GOALS_STATUS_TAG = "changeGoalStatusTag";
        String FORGOT_PASSWORD_TAG = "forgotpasswordTag";
        String MULTIUSER_TAG = "multiuserTag";
    }

    public interface IFireBase {
        String LOGIN = "Login";
        String HOME_TAB_SELECTED = "HomeTabSelected";
        String NOTES_TAB_SELECTED = "NotesTabSelected";
        String GOALS_TAB_SELECTED = "GoalsTabSelected";
        String RESETS_PASSWORD = "ResetsPassword";
        String FORGOT_PASSWORD_SELECTED = "ForgotPasswordSelected";
        String DIFFERENT_ID_SELECTED = "DifferentIDSelected";
        String DIFFERENT_ID_SCREEN_SELECTED = "DifferentIDScreenSelected";
        String LOGIN_TERMS_ACCEPTED = "LoginTermsAccepted";
        String SETTINGS_MENU_SELECTED = "SettingsMenuSelected";

        String SETTINGS_MENU_SLECTED = "SettingsMenuSelected";
        String HELP_SELECTED = "HelpSelected";
        String SIGN_OUT_SELECTED = "SignOutSelected";
        String ENABLE_TOUCH_SELECTED = "EnableTouchSelected";
        String DISABLE_TOUCH_SELECTED = "DisableTouchSelected";
        String ARCHIVE_NOTE_SELECTED = "ArchiveNoteSelected";

        String ARCHIVE_ALL_SELECTED = "ArchiveAllSelected";
        String ARCHIVE_TAB_SELECTED = "ArchiveTabSelected";
        String NOTE_MESSAGE_SELECTED = "NoteMessageSelected";
        String UN_ARCHIVE_SELECTED = "UnArchiveSelected";
        String GOAL_SELECTED = "GoalSelected";
        String EDIT_STATUS_SELECTED = "EditStatusSelected";

        String ADD_NOTE_SELECTED = "AddNoteSelected";
        String REPLY_NOTES_SELECTED = "ReplyNoteSelected";
        String GOAL_STATUS_CHANGES = "GoalStatusChanges";
        String ERROR_FOUND = "ErrorFound";
    }

    public interface IStatus {

        String NO_STATUS = "No Status";
        String FALLING_BEHIND = "Falling Behind";
        String AT_RISK = "At Risk";
        String On_TRACK = "On Track";

        String DRAFT = "Draft";
        String SUSPEND = "Suspended";
        String COMPLETED = "Completed";
    }

    public interface IAddReplyNoteKey {

        String STATUS = "status";
        String MESSAGE_BODY = "messageBody";
        String ID = "id";
        String AUTHOR = "author";
        String GOAL_TYPE = "goalType";
        String PLAN_ID = "planId";
        String GOAL_ID = "goalId";


    }


}
