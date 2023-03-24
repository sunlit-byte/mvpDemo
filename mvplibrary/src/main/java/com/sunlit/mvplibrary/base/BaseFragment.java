package com.sunlit.mvplibrary.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public abstract class BaseFragment extends Fragment implements UiCallback {

    protected View rootView;

    protected LayoutInflater layoutInflater;

    protected Activity context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initBeforeView(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        layoutInflater = inflater;
        if(rootView == null){
            rootView = inflater.inflate(getLayoutId(),null);
        }else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if(viewGroup != null){
                viewGroup.removeView(rootView);
            }
         }
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.context = (Activity) context;
        }
        //requireActivity() 返回的是宿主activity
        requireActivity().getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull  Lifecycle.Event event) {
                if (event.getTargetState() == Lifecycle.State.CREATED){
                    //在这里任你飞翔
                    initData(context);
                    requireActivity().getLifecycle().removeObserver(this);  //这里是删除观察者
                }
            }
        });
    }
    /**
     * 解绑
     */
    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }

    @Override
    public void initBeforeView(Bundle savedInstanceState) {

    }
}
