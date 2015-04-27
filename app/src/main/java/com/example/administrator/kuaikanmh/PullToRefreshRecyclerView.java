package com.example.administrator.kuaikanmh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by Administrator on 2015-4-16.
 */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView>{
    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode, AnimationStyle animStyle) {
        super(context, mode, animStyle);
    }

    /**
     * 刷新拉动的流向
     * @return
     */
    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    /**
     * 创建一个包裹的view
     * @param context Context to create view with
     * @param attrs AttributeSet from wrapped class. Means that anything you
     *            include in the XML layout declaration will be routed to the
     *            created View
     * @return
     */
    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView recyclerView=new RecyclerView(context,attrs);
        recyclerView.setId(R.id.recycler);
        return recyclerView;
    }

    /**
     * 是否滑动到底部
     * @return
     */
    @Override
    protected boolean isReadyForPullEnd() {
        RecyclerView recyclerView = getRefreshableView();
        View view = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        int count = recyclerView.getAdapter().getItemCount();
        int position = recyclerView.getChildPosition(view);
        return position==count-1&&view.getBottom()==recyclerView.getHeight();
    }

    /**
     * 是否滑动到顶部
     * @return
     */
    @Override
    protected boolean isReadyForPullStart() {
        RecyclerView recyclerView = getRefreshableView();
        View view = recyclerView.getChildAt(0);
        int position = recyclerView.getChildPosition(view);
        return position==0&&view.getTop()==0;
    }
}
