package c.anurag.database.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import c.anurag.database.application.BaseApplication;
import c.anurag.database.navigation.IntentHelperAbstract;

public abstract class BaseFragment extends Fragment
{

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);
        initView(view);
        onFragmentReady(savedInstanceState);
        return view;
    }

    public abstract void onFragmentReady(Bundle savedInstanceState);

    public abstract int getFragmentLayout();

    public abstract void initView(View view);

    protected IntentHelperAbstract getIntentHelper()
    {
        return ((BaseApplication) getActivity().getApplication()).getIntentHelper();
    }
}
