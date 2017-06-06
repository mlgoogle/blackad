package com.yundian.comm.networkapi.listener;

import com.yundian.comm.listener.OnErrorListener;
import com.yundian.comm.listener.OnSuccessListener;

/**
 * @author : Created by 180
 * @version : 0.01
 * @email : yaobanglin@163.com
 * @created time : 2015-06-16 12:09
 * @describe : OnAPIListener
 * @for your attention : none
 * @revise : none
 */
public interface OnAPIListener<T> extends OnSuccessListener<T>, OnErrorListener
{
}
