package in.microlan.www.perfectmatrimony.utility;


import android.util.Log;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.enums.PNPushType;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.push.PNPushAddChannelResult;
import com.pubnub.api.models.consumer.push.PNPushRemoveAllChannelsResult;
import java.util.ArrayList;
import java.util.List;


public final class PubNubUtility {

    private static PubNubUtility instance;

    public static final String TAG = PubNubUtility.class.getSimpleName();

    private PubNub pubNub;

    private PubNubUtility() {
        createPubNubInstance();
    }

    public static PubNubUtility getInstance() {
        if (instance == null) {
            instance = new PubNubUtility();
        }

        return instance;
    }

    private void createPubNubInstance() {
        //first need to create the pubnub configuration
//        PNConfiguration pnConfiguration = new PNConfiguration();
//        pnConfiguration.setSubscribeKey(NotificationConstants.IPubNubKey.DEV_SUB_KEY);
//        pnConfiguration.setPublishKey(NotificationConstants.IPubNubKey.DEV_PUB_KEY);
//        pnConfiguration.setAuthKey(CurrentUser().getAuthKey());
//        pnConfiguration.setUuid(CurrentUser().getUserID());
//        pnConfiguration.setSecure(true);
//        pnConfiguration.setPresenceTimeout(130);

        //create our PubNub instance
   //     pubNub = new PubNub(pnConfiguration);
    }

    public void connect()
    {

   /*     if (PreferenceUtility.getDeviceToken() == null) {
            //PreferenceUtility.setDeviceToken(FirebaseInstanceId.getInstance().getToken());

        }*/

        String deviceToken = PreferenceUtility.getDeviceToken();
        if (deviceToken == null) {
            //WHAT DO WE DO ABOUT THIS?? THIS HAPPENS FREQUENTLY AND IT CAN'T BE NULL
            // CAN WE DO AN EVENT LISTENER AND WAIT?
            Log.d(TAG, "PUBNUB ERROR DEVICE TOKEN IS NULL");
        }

        //channels we are connecting to
        List<String> channels = new ArrayList<>();

        //todo: for the first release we are ONLY interested in joining Notification Channel types
//        for (ChannelGroupDO channelGroupDO : channelGroupDOs) {
//            if (ChannelGroupType.NOTIFICATION.equals(channelGroupDO.getType())) {
//                for (ChannelDO channelDO : channelGroupDO.getChannelMemberships()) {
//                    channels.add(channelDO.getUuid());
//                }
//            }
//        }

        //adds gcm push notifications to channels
        pubNub.addPushNotificationsOnChannels()
                .pushType(PNPushType.GCM)
                .channels(channels)
                .deviceId(deviceToken)
                .async(new PNCallback<PNPushAddChannelResult>() {
                    @Override
                    public void onResponse(PNPushAddChannelResult result, PNStatus status) {
                        if (status.isError()) {
                            Log.d(TAG, "Push Notification Error: " + status.getErrorData());
                        } else {
                            Log.d(TAG, "Push notification added ");
                        }
                    }
                });

    }

    public void disconnect() {

        //remove all push notifications
        // https://www.pubnub.com/docs/android-java/api-reference-mobile-push#removing-device-channel
        pubNub.removeAllPushNotificationsFromDeviceWithPushToken()
                .deviceId(PreferenceUtility.getDeviceToken())
                .pushType(PNPushType.GCM)
                .async(new PNCallback<PNPushRemoveAllChannelsResult>() {
                    @Override
                    public void onResponse(PNPushRemoveAllChannelsResult result, PNStatus status) {
                        PreferenceUtility.clearPreferences();
                        if (status.isError()) {
                            Log.d(TAG, "Remove Push Notification Error: " + status.getErrorData());
                        } else {
                            Log.d(TAG, "Push notifications removed ");

                        }
                    }
                });
    }

}