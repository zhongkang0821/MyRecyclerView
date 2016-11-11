package test.bwie.com.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhongkang on 2016/11/10.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener {
    private LayoutInflater mInflater;
    private final Context mcontext;
    private final DisplayImageOptions displayImageOptions;
    private final List<Bean.DataBean> mDatas;
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnRecyclerViewItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener=mOnItemClickListener;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, Bean.DataBean data);
    }

    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //主要要在点击事件里面得到以下数据
            mOnItemClickListener.onItemClick(view, (Bean.DataBean) view.getTag());
        }
    }

    public HomeAdapter(List<Bean.DataBean> datas,Context context) {
        mInflater=LayoutInflater.from(context);
        mDatas=datas;
        mcontext=context;
        displayImageOptions=ImageLoaderUtils.initOptions();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mcontext).inflate(R.layout.item, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position).getGoods_name());
        ImageLoader.getInstance().displayImage(mDatas.get(position).getGoods_img(), holder.iamge, displayImageOptions);
        holder.itemView.setTag(mDatas.get(position));

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView iamge;

        public MyViewHolder(View view) {
            super(view);
            tv=(TextView) view.findViewById(R.id.tv);
            iamge=(ImageView) view.findViewById(R.id.ima);

        }
    }
}
