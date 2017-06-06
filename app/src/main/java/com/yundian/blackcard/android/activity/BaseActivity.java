package com.yundian.blackcard.android.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yundian.blackcard.android.R;
import com.yundian.blackcard.android.view.LoaderLayout;
import com.yundian.comm.listener.InitPageListener;
import com.yundian.comm.listener.OnErrorListener;
import com.yundian.comm.util.LogUtils;
import com.yundian.comm.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yaowang on 2017/5/8.
 */

public abstract class BaseActivity extends AppCompatActivity implements InitPageListener , OnErrorListener {

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @Nullable
    @BindView(R.id.toolbar_title)
    protected TextView mToolbarTitle;
    @Nullable
    @BindView(R.id.toolbar_subtitle)
    protected TextView mToolbarSubTitle;
    protected LoaderLayout loaderLayout;
    protected View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(rootView);
        ButterKnife.bind(this);

        initStatusBar();
        initView();
        initListener();
        initData();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (mToolbarTitle != null) {
            mToolbarTitle.setText(title);
        }
    }

    protected boolean isShowBackButton() {
        return false;
    }


    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        if (toolbar != null && isShowBackButton()) {
            toolbar.setNavigationIcon(R.mipmap.back_icon);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override
    public void initData() {

    }

    protected void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //设置状态栏颜色
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    protected void onShowError(Throwable ex) {
        if( ! this.isFinishing() )
        {
            ToastUtils.show(this, ex.getLocalizedMessage());
        }
        LogUtils.showException(ex);
        closeLoader();
    }

    protected void showToast(String string) {
        ToastUtils.show(this,string);
    }

    protected void showToast(CharSequence charSequence){
        showToast(charSequence.toString());
    }

    @Override
    public void onError(Throwable ex) {
        onShowError(ex);
    }


    public void showLoader() {
        showLoader(null);
    }

    public void showLoader(String msgContent) {
        try {
            if (loaderLayout == null) {
                loaderLayout = new LoaderLayout(this);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                loaderLayout.setLayoutParams(params);
                if (rootView != null) {
                    ((FrameLayout) rootView.getParent()).addView(loaderLayout);
                }
            }
            loaderLayout.setVisibility(View.VISIBLE);
            if (msgContent != null) {
                loaderLayout.setMsgContent(msgContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoader(int resId) {
        showLoader(getString(resId));
    }

    public void closeLoader() {
        if (loaderLayout != null)
            loaderLayout.setVisibility(View.GONE);
    }
}
