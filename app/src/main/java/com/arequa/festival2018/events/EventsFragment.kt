package com.arequa.festival2018.events

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arequa.commons.BaseListFragment
import com.arequa.commons.DataBindingRecyclerAdapter
import com.arequa.festival2018.Event
import com.arequa.festival2018.BR
import com.arequa.festival2018.R
import com.arequa.festival2018.data.EventsDataSource


/**
 * Created by FCD on 22/05/2018.
 */
class EventsFragment : BaseListFragment() {

    override fun onResume() {
        super.onResume()
        showData()
    }

    private fun showData() {
        EventsDataSource
                .getEvents()
                .subscribe({ list ->
                    replaceItems(list)
                }, { error ->
                    showMessage(error)
                })
    }

    private fun showMessage(error: Throwable?) {
        error!!.printStackTrace()
        view?.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                    .setAction(R.string.label_retry, { _ -> showData()})
                    .show()
        }
    }

    private fun replaceItems(list: List<com.arequa.festival2018.Event>) {
        with(listAdapter as DataBindingRecyclerAdapter<Event>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Event>(BR.item, R.layout.item_event)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<Event>).items.addAll(getDummyItems())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyItems(): ArrayList<Event> {
        return arrayListOf(Event("title", 0.99F, 9.99F, 80, 80, "https://i.blogs.es/7b014b/coco-disney/450_1000.jpg"))
    }

    /*override fun getLayoutResId(): Int {
        return R.layout.fragments_events
    }*/

}
