package test.bwie.com.myrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by zhongkang on 2016/11/10.
 */
public class IndicaterAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public IndicaterAdapter(FragmentManager fm, String[] title) {
        super(fm);
        this.titles=title;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=new Fragment11();
//        Bundle args=new Bundle();
//        args.putString("arg",titles[position]);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
