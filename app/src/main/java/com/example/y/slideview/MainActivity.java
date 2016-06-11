package com.example.y.slideview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.y.slideview.view.SlideView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SlideView.OnTouchListener {


    private RecyclerView recyclerView;
    private List<String> data;
    private LinearLayoutManager linearLayoutManager;
    private SlideView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (SlideView) findViewById(R.id.slide);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        assert view != null;
        assert recyclerView != null;
        init();
    }

    private void init() {
        view.setOnTouchListener(this);
        data = new LinkedList<>();
        Data.addList(data);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onTouch(String letter) {
        for (int i = 0; i < data.size(); i++) {
            if (letter.equals(data.get(i))) {
                moveToPosition(i);
//                smoothMoveToPosition(i);
            }
        }
    }

    //不带动画
    @SuppressWarnings("unused")
    private void moveToPosition(int index) {

        int firstItem = linearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = linearLayoutManager.findLastVisibleItemPosition();
        if (index <= firstItem) {
            recyclerView.scrollToPosition(index);
        } else if (index <= lastItem) {
            int top = recyclerView.getChildAt(index - firstItem).getTop();
            recyclerView.scrollBy(0, top);
        } else {
            recyclerView.scrollToPosition(index);
        }

    }


    //带动画
    @SuppressWarnings("unused")
    private void smoothMoveToPosition(int index) {

        int firstItem = linearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = linearLayoutManager.findLastVisibleItemPosition();
        if (index <= firstItem) {
            recyclerView.smoothScrollToPosition(index);
        } else if (index <= lastItem) {
            int top = recyclerView.getChildAt(index - firstItem).getTop();
            recyclerView.smoothScrollBy(0, top);
        } else {
            recyclerView.smoothScrollToPosition(index);
        }

    }

}
