package com.fangzhic.app.main.product.search;
import com.fangzhic.app.base.BaseModel;
import com.fangzhic.app.base.BasePresenter;
import com.fangzhic.app.base.BaseView;

/**
 * Created by smacr on 2016/8/30.
 */
public interface ProductSearchContract {
    interface Model extends BaseModel {

    }

    interface View extends BaseView {


    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
