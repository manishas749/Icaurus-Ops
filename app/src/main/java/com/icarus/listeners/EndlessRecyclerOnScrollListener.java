package com.icarus.listeners;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener
{
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5; // The minimum amount of items to have below your current scroll position before loading more.
    private int current_page = 0;
    private LinearLayoutManager mLinearLayoutManager;

    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager)
    {
        previousTotal = 0;
        current_page = 0;
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void setCurrent_page(int current_page)
    {
        this.current_page = current_page;
    }

    @Override
    public synchronized void onScrolled(RecyclerView recyclerView, int dx, int dy)
    {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if(loading)
        {
            if(totalItemCount > previousTotal)
            {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if(!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold))
        {
            // End has been reached

            // Do something
            current_page++;

            onLoadMore(current_page);

            loading = true;
        }
    }

    public abstract void onLoadMore(int current_page);
}