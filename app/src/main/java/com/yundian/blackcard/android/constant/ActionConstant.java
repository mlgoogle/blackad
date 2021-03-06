package com.yundian.blackcard.android.constant;

/**
 * @author : created by chuangWu
 * @version : 0.01
 * @email : chuangwu127@gmail.com
 * @created time : 2017-06-07 10:39
 * @description : none
 * @for your attention : none
 * @revise : none
 */
public interface ActionConstant {

    interface Action {
        int EMPTY_BUTTON = 0;
        int PAY_CLOSE = EMPTY_BUTTON + 1;
        int PAY_PURSE = PAY_CLOSE + 1;
        int PAY_ALI = PAY_PURSE + 1;
        int PAY_WEIXIN = PAY_ALI + 1;
        int DYNAMIC_PIC = PAY_WEIXIN + 1;
        int DYNAMIC_DETAIL = DYNAMIC_PIC + 1;
        int DYNAMIC_NAME = DYNAMIC_DETAIL + 1;
        int DYNAMIC_PRAISE = DYNAMIC_NAME + 1;
        int DYNAMIC_COMMENT = DYNAMIC_PRAISE + 1;
        int DYNAMIC_MORE = DYNAMIC_COMMENT + 1;
        int DYNAMIC_DELETE = DYNAMIC_MORE + 1;
        int DYNAMIC_COMMENT_REQUEST = DYNAMIC_DELETE + 1;
        int DYNAMIC_RELEASE_ICON = DYNAMIC_COMMENT_REQUEST + 1;
        int DYNAMIC_RELEASE_DELETE = DYNAMIC_RELEASE_ICON + 1;
        int DYNAMIC_RELEASE_REQUEST = DYNAMIC_RELEASE_DELETE + 1;
        int ARTICLE_DETAIL = DYNAMIC_RELEASE_REQUEST + 1;
        int BIG_IMAGE = ARTICLE_DETAIL + 1;
        int ARTICLE_COMMENT_REQUEST = BIG_IMAGE + 1;
        int TRIBE_FLOAT = ARTICLE_COMMENT_REQUEST + 1;
        int TRIBE_AGREE = TRIBE_FLOAT + 1;
        int TRIBE_REFUSE = TRIBE_AGREE + 1;
        int TRIBE_APPLY_REQUEST = TRIBE_REFUSE + 1;
        int TRIBE_ADD = TRIBE_APPLY_REQUEST + 1;
        int TRIBE_DELETE = TRIBE_ADD + 1;
        int TRIBE_ADD_REQUEST = TRIBE_DELETE + 1;
        int DYNAMIC_COMMENT_CONTENT = TRIBE_ADD_REQUEST + 1;
        int DYNAMIC_COMMENT_DELETE = DYNAMIC_COMMENT_CONTENT + 1;
    }

    interface IntentKey {
        String PAY_PASSOWRD = "PAY_PASSOWRD";
        String PHONE = "PHONE";
        String SHOP = "SHOP";
        String SMS_CODE = "SMS_CODE";
        String PAY_PASSWORD = "PAY_PASSWORD";
        String DYNAMIC = "DYNAMIC";
        String TRIBEID_ID = "TRIBEID_ID";
        String WEBVIEW_URL = "WEBVIEW_URL";
        String TRIBEID_IDENTITY = "TRIBEID_IDENTITY";
        String TRIBEID_STATUS = "TRIBEID_STATUS";
        String DYNAMIC_COMMENT = "DYNAMIC_COMMENT";
        String ARTICLE_COMMENT = "ARTICLE_COMMENT";
        String ARTICLE = "ARTICLE";
        String IMGS_LIST = "IMGS_LIST";
        String IMGS_POSITION = "IMGS_POSITION";
        String IMGS_BIG = "IMGS_BIG";
        String IMG_BIG_INDEX = "IMG_BIG_INDEX";
        String TRIBEID_LIST_MODEL = "TRIBEID_LIST_MODEL";
        String USER_ID = "USER_ID";
        String ISPAY = "ISPAY";
    }

    interface Broadcast {
        String TRIBE_UPDATE = "TRIBE_UPDATE";
    }
}
