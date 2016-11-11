package test.bwie.com.myrecyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by zhongkang on 2016/11/10.
 */
public class Fragment11 extends Fragment {

    private String urlPath="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";
    private RecyclerView my_recycler;
    private HomeAdapter mAdapter;
    private Button add,del;
    private List<Bean.DataBean> list=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment,container,false);

        my_recycler= (RecyclerView) view.findViewById(R.id.my_recycler);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Recycler();

//        addView();

    }

    private void Recycler() {
        my_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter=new HomeAdapter(list,getActivity());

        OkHttp.getAsync(urlPath, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Log.i("jjjjjjjjj",result);
                Gson gson=new Gson();
                Bean bean=gson.fromJson(result,Bean.class);
                list=bean.getData();

                mAdapter=new HomeAdapter(list,getActivity());

                my_recycler.setAdapter(mAdapter);

                mAdapter.setmOnItemClickListener(new HomeAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, Bean.DataBean data) {
                        Toast.makeText(getActivity(), "..."+data.getGoods_name(), Toast.LENGTH_LONG).show();
                    }
                });
            }

        });

    }

//    private void addView() {
//        OkHttp.getAsync(urlPath, new OkHttp.DataCallBack() {
//            @Override
//            public void requestFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void requestSuccess(String result) throws Exception {
//                Log.i("jjjjjjjjj",result);
//                Gson gson=new Gson();
//                Bean bean=gson.fromJson(result,Bean.class);
//                list=bean.getData();
//
//                my_recycler.setAdapter(mAdapter=new HomeAdapter(list,getActivity()));
//            }
//
//        });
//    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.add:
//                my_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//                mAdapter.notifyDataSetChanged();
//                break;
//            case R.id.del:
//                my_recycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//                mAdapter.notifyDataSetChanged();
//                break;
//        }
//    }
}
