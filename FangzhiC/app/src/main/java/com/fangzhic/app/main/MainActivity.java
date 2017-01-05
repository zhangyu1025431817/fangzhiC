package com.fangzhic.app.main;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseActivity;
import com.fangzhic.app.base.RxBus;
import com.fangzhic.app.main.cart.ShoppingCartFragment;
import com.fangzhic.app.main.design.SmartDesignFragment;
import com.fangzhic.app.main.home.HomeFragment;
import com.fangzhic.app.main.product.ProductFragment;
import com.fangzhic.app.main.user.UserFragment;

import butterknife.Bind;
import rx.functions.Action1;


public class MainActivity extends BaseActivity {
    private final int[] mTabNames = new int[]{R.string.page_home, R.string.page_baby,
            R.string.page_smart_design, R.string.page_shopping_cart, R.string.page_user_center};
    public static final String TAG_CHANGE = "view_pager_change";
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab_Layout)
    TabLayout tabLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_content;
    }

    @Override
    public void initView() {
        initViewPager();
        registerEvent();
    }

    private void registerEvent(){
        RxBus.$().register(TAG_CHANGE).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                int position = (int)o;
                viewPager.setCurrentItem(position);
            }
        });
    }

    private void initViewPager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new ProductFragment();
                    case 2:
                        return new SmartDesignFragment();
                    case 3:
                        return new ShoppingCartFragment();
                    case 4:
                        return new UserFragment();
                    default:
                        return new HomeFragment();
                }
            }

            @Override
            public int getCount() {
                return mTabNames.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(mTabNames[position]);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return super.instantiateItem(container, position);
            }
        });
        viewPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(R.layout.view_main_tab);
                Drawable d = null;
                switch (i) {
                    case 0:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            d = getResources().getDrawable(R.drawable.tab_icon_home, null);
                        } else {
                            d = getResources().getDrawable(R.drawable.tab_icon_home);
                        }
                        break;
                    case 1:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            d = getResources().getDrawable(R.drawable.tab_icon_product, null);
                        } else {
                            d = getResources().getDrawable(R.drawable.tab_icon_product);
                        }
                        break;
                    case 2:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            d = getResources().getDrawable(R.drawable.tab_icon_design, null);
                        } else {
                            d = getResources().getDrawable(R.drawable.tab_icon_design);
                        }
                        break;
                    case 3:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            d = getResources().getDrawable(R.drawable.tab_icon_cart, null);
                        } else {
                            d = getResources().getDrawable(R.drawable.tab_icon_cart);
                        }
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            d = getResources().getDrawable(R.drawable.tab_icon_user, null);
                        } else {
                            d = getResources().getDrawable(R.drawable.tab_icon_user);
                        }
                        break;
                }
                tab.setIcon(d);
            }
        }
    }


}
