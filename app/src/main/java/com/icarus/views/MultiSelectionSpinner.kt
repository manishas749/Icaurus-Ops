package com.icarus.views

import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnMultiChoiceClickListener
import android.database.DataSetObserver
import androidx.appcompat.app.AlertDialog
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.SpinnerAdapter
import android.widget.TextView
import com.icarus.R


/**
 * Created by Anurag Purwar on 24/10/18.
 */
class MultiSelectionSpinner : androidx.appcompat.widget.AppCompatTextView, OnMultiChoiceClickListener {

    var adapter: SpinnerAdapter? = null
    private var mOldSelection: BooleanArray? = null
    private var mSelected: BooleanArray? = null
    var defaultText: String? = null
    var mAllText: String? = null
    private var mAllSelected: Boolean = false
    var mAllSelectedDisplayMode: AllSelectedDisplayMode? = null
    private var mListener: MultiSelectionSpinnerListener? = null
    private var defaultSelectedIndex: Int? = -1

    private val onClickListener = object : View.OnClickListener {
        override fun onClick(v: View) {
            val builder = AlertDialog.Builder(context)

            val choices = arrayOfNulls<String>(adapter!!.count)

            for (i in choices.indices) {
                choices[i] = adapter!!.getItem(i).toString()
            }

            for (i in mSelected!!.indices) {
                mOldSelection!![i] = mSelected!![i]
            }

            builder.setMultiChoiceItems(choices, mSelected, this@MultiSelectionSpinner)

            builder.setNegativeButton(android.R.string.cancel) { dialog, which ->
                for (i in mSelected!!.indices) {
                    mSelected!![i] = mOldSelection!![i]
                }

                dialog.dismiss()
            }

            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                refreshSpinner()
                mListener!!.onItemsSelected(mSelected)
                dialog.dismiss()
            }

            builder.show()
        }
    }

    internal var dataSetObserver: DataSetObserver = object : DataSetObserver() {
        override fun onChanged() {
            // all selected by default
            mOldSelection = BooleanArray(adapter!!.count)
            mSelected = BooleanArray(adapter!!.count)
            for (i in mSelected!!.indices) {
                mOldSelection!![i] = false
                mSelected!![i] = mAllSelected
            }
        }
    }

    var selected: BooleanArray?
        get() = this.mSelected
        set(selected) {
            if (this.mSelected!!.size != selected!!.size)
                return

            this.mSelected = selected

            refreshSpinner()
        }

    enum class AllSelectedDisplayMode {
        UseAllText,
        DisplayAllItems
    }

    constructor(context: Context) : super(context) {}

    @JvmOverloads constructor(context: Context, attr: AttributeSet, defStyle: Int = R.attr.spinnerStyle) : super(context, attr, defStyle) {}

    override fun onClick(dialog: DialogInterface, which: Int, isChecked: Boolean) {
        if (defaultSelectedIndex != which) {
            mSelected!![which] = isChecked
        } else {
            mSelected!![which] = true
        }
    }

    fun setAdapter(adapter: SpinnerAdapter, allSelected: Boolean, selectedUserIndex: Int, listener: MultiSelectionSpinnerListener) {
        val oldAdapter = this.adapter

        setOnClickListener(null)
        this.defaultSelectedIndex = selectedUserIndex;
        this.adapter = adapter
        this.mListener = listener
        this.mAllSelected = allSelected

        oldAdapter?.unregisterDataSetObserver(dataSetObserver)

        if (this.adapter != null) {
            this.adapter!!.registerDataSetObserver(dataSetObserver)

            // all selected by default
            mOldSelection = BooleanArray(this.adapter!!.count)
            mSelected = BooleanArray(this.adapter!!.count)
            for (i in mSelected!!.indices) {
                mOldSelection!![i] = false
                mSelected!![i] = allSelected
            }

            setOnClickListener(onClickListener)
        }

        // all text on the spinner
        if (TextUtils.isEmpty(mAllText)) {
            text = defaultText
        } else {
            text = mAllText
        }
    }

    fun setOnItemsSelectedListener(listener: MultiSelectionSpinnerListener) {
        this.mListener = listener
    }

    interface MultiSelectionSpinnerListener {
        fun onItemsSelected(selected: BooleanArray?)
    }

    fun refreshSpinner() {
        // refresh text on spinner
        val spinnerBuffer = StringBuffer()
        var someUnselected = false
        var allUnselected = true

        for (i in 0 until adapter!!.count) {
            if (mSelected!![i]) {
                spinnerBuffer.append(adapter!!.getItem(i).toString())
                spinnerBuffer.append(", ")
                allUnselected = false
            } else {
                someUnselected = true
            }
        }

        var spinnerText: String?

        if (!allUnselected) {
            if ((someUnselected && !(mAllText != null && mAllText!!.isNotEmpty())) || mAllSelectedDisplayMode == AllSelectedDisplayMode.DisplayAllItems) {
                spinnerText = spinnerBuffer.toString();
                if (spinnerText.length > 2)
                    spinnerText = spinnerText.substring(0, spinnerText.length - 2);
            } else {
                spinnerText = mAllText;
            }
        } else {
            spinnerText = defaultText;
        }

        text = spinnerText
    }
}