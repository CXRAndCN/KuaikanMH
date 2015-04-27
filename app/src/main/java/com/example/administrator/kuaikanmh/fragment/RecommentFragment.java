package com.example.administrator.kuaikanmh.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.kuaikanmh.BitmapHelper;
import com.example.administrator.kuaikanmh.R;
import com.example.administrator.kuaikanmh.adapter.RecommenAdapter;
import com.example.administrator.kuaikanmh.bean.Comics;
import com.example.administrator.kuaikanmh.bean.Topic;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import org.apache.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-4-25.
 */
public class RecommentFragment extends Fragment implements  SwipeRefreshLayout.OnRefreshListener{
    private Comics comics;
    private Topic topic;
    private List<Comics> list;
    private SwipeRefreshLayout refresh;
    private ListView listview;
    private RecommenAdapter recommenAdapter;
    private HttpUtils utils;
    private int offset=0;
    private View  view_head;
    private ImageView  head_image;
    private RadioGroup rg;
    private  View  view_rg_btn;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recommen_fragment,container,false);
        BitmapHelper.init(getActivity());
        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        listview= ((ListView) view.findViewById(R.id.recommend_list));

        utils=new HttpUtils();
        Refresh();
        //添加头部布局
//         =inflater.inflate(R.layout.main_list_head, container, false);
        refresh.setOnRefreshListener(this);

        return view;
    }
    //添加头部
    private void initHeadView() {
       view_head = View.inflate(getActivity(), R.layout.main_list_head, null);

       listview.addHeaderView(view_head);

    }

    //首次进入页面加载数据：
    public  void  Refresh(){

        String path="http://api.kuaikanmanhua.com/v1/comic_lists/1?offset="+offset+"&limit=50";
        utils.send(com.lidroid.xutils.http.client.HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                comics=null;
                topic=null;
                try {
     //               Log.d("RecommentFragment",responseInfo.result);
                    JSONObject json1 = new JSONObject(responseInfo.result);
                    JSONObject json2 = json1.getJSONObject("data");
                    JSONArray arr = json2.getJSONArray("comics");
                    list=new ArrayList<Comics>();
                    for (int i=0;i<arr.length();i++){
                        comics=new Comics();
                        JSONObject json3 = arr.getJSONObject(i);
                        comics.setComments_count(json3.getInt("comments_count"));
                        comics.setCover_image_url(json3.getString( "cover_image_url"));
                        comics.setCreated_at(json3.getLong("created_at"));
                        comics.setId(json3.getInt("id"));
                        comics.setIs_liked(json3.getBoolean("is_liked"));
                        comics.setLikes_count(json3.getInt( "likes_count"));
                        comics.setTitle(json3.getString("title"));
                        topic=new Topic();
                        JSONObject json4 = json3.getJSONObject("topic");
                        topic.setComics_count(json4.getInt("comics_count"));
                        topic.setCover_image_url(json4.getString("cover_image_url"));
                        topic.setCreated_at(json4.getLong("created_at"));
                        topic.setDescription(json4.getString( "description"));
                        topic.setId(json4.getInt("id"));
                        topic.setOrder(json4.getInt("order"));
                        topic.setTitle(json4.getString(  "title"));
                        topic.setUpdated_at(json4.getLong(  "updated_at"));
                        topic.setUser_id(json4.getInt( "user_id"));
                        comics.setUpdated_at(json3.getLong("updated_at"));
                        comics.setUrl(json3.getString("url"));
                        comics.setTopic(topic);
                        list.add(comics);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


                initHeadView();
                recommenAdapter=new RecommenAdapter(getActivity(),list);
                listview.setAdapter(recommenAdapter);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(),"请检查您的网络连接",Toast.LENGTH_SHORT).show();
            }
        });

    }
//下拉刷新
    @Override
    public void onRefresh() {
        offset=0;

        String path="http://api.kuaikanmanhua.com/v1/comic_lists/1?offset="+offset+"&limit=50";
        utils.send(com.lidroid.xutils.http.client.HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {


            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                try {
      //              Log.d("RecommentFragment",responseInfo.result);
                    JSONObject json1 = new JSONObject(responseInfo.result);
                    JSONObject json2 = json1.getJSONObject("data");
                    JSONArray arr = json2.getJSONArray("comics");
                    list=new ArrayList<Comics>();
                    for (int i=0;i<arr.length();i++){
                        comics=new Comics();
                        JSONObject json3 = arr.getJSONObject(i);
                        comics.setComments_count(json3.getInt("comments_count"));
                        comics.setCover_image_url(json3.getString( "cover_image_url"));
                        comics.setCreated_at(json3.getLong("created_at"));
                        comics.setId(json3.getInt("id"));
                        comics.setIs_liked(json3.getBoolean("is_liked"));
                        comics.setLikes_count(json3.getInt( "likes_count"));
                        comics.setTitle(json3.getString("title"));
                        topic=new Topic();
                        JSONObject json4 = json3.getJSONObject("topic");
                        topic.setComics_count(json4.getInt("comics_count"));
                        topic.setCover_image_url(json4.getString("cover_image_url"));
                        topic.setCreated_at(json4.getLong("created_at"));
                        topic.setDescription(json4.getString( "description"));
                        topic.setId(json4.getInt("id"));
                        topic.setOrder(json4.getInt("order"));
                        topic.setTitle(json4.getString(  "title"));
                        topic.setUpdated_at(json4.getLong(  "updated_at"));
                        topic.setUser_id(json4.getInt( "user_id"));
                        comics.setUpdated_at(json3.getLong("updated_at"));
                        comics.setUrl(json3.getString("url"));
                        comics.setTopic(topic);
                        list.add(comics);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                recommenAdapter=new RecommenAdapter(getActivity(),list);
                listview.setAdapter(recommenAdapter);

                refresh.setRefreshing(false);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(),"请检查您的网络连接",Toast.LENGTH_SHORT).show();
                refresh.setRefreshing(false);
            }
        });

    }

    //打开fragment页面的方法
    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain,fragment);
        fragmentTransaction.commit();

    }


}
