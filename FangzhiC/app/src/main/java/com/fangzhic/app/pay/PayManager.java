package com.fangzhic.app.pay;

/**
 * Created by smacr on 2016/12/26.
 */

public class PayManager {
    private static PayManager mPayManager;
    public static PayManager getInstance(){
        if(mPayManager ==null){
            mPayManager = new PayManager();
        }
        return mPayManager;
    }

    public void aliPay(){

    }

    public void weChatPay(){

    }
}
