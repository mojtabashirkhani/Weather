package com.slimshady.weatherplusmap.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


abstract class GenericRecyclerViewAdapter<T : Any, L : BaseRecyclerListener, VH : BaseViewHolder<T, L>> :
    RecyclerView.Adapter<VH> {

    private var items: MutableList<T>? = null
    /**
     * Get listener [BaseRecyclerListener]
     *
     * @return click listener
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    /**
     * Set click listener, which must extend [BaseRecyclerListener]
     *
     * @param listener click listener
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    var listener: L? = null
    var context: Context? = null
    private var layoutInflater: LayoutInflater? = null

    override fun getItemCount(): Int {
       return if (items != null) items?.size ?: 0 else 0
    }


    /**
     * Returns whether adapter is empty or not.
     *
     * @return `true` if adapter is empty or `false` otherwise
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    val isEmpty: Boolean
        get() = itemCount == 0

    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    @Deprecated("")
    constructor(context: Context) {
        layoutInflater = LayoutInflater.from(context)
        items = ArrayList()
    }

    constructor(context: Context, listener: L) {
        this.context = context
        this.listener = listener
        this.items = ArrayList()
        this.layoutInflater = LayoutInflater.from(context)
    }

    /**
     * To be implemented in as specific adapter.
     * Here you should return new ViewHolder instance.
     * You may also return different ViewHolders according to a view type.
     * In this case you shoulf also override [RecyclerView.Adapter.getItemViewType]
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the itemView to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: VH, position: Int) {
        if (items?.size ?: 0 <= position) {
            return
        }
        val item = items?.get(position)
        if (item != null) {
            holder.onBind(item)
        }
    }

    /**
     * Sets items to the adapter and notifies that data set has been changed.
     * Typically this method should be use with `notifyChanges = false` in case you are using DiffUtil
     * [android.support.v7.util.DiffUtil] in order to delegate it do all the updating job.
     *
     * @param items         items to set to the adapter
     * @param notifyChanges pass in `true` to call notifiDatasetChanged [RecyclerView.Adapter.notifyDataSetChanged] or `false` otherwise
     * @throws IllegalArgumentException in case of setting `null` items
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    @Throws(IllegalArgumentException::class)
    @JvmOverloads
    fun setItems(items: List<T>?, notifyChanges: Boolean = true) {
        requireNotNull(items) { "Cannot set `null` item to the Recycler adapter" }
        this.items?.clear()
        this.items?.addAll(items)
        if (notifyChanges) {
            notifyDataSetChanged()
        }
    }

    /**
     * Updates items list.
     * Typically to be used for the implementation of DiffUtil [android.support.v7.util.DiffUtil]
     *
     * @param newItems new items
     */
    fun updateItems(newItems: List<T>) {
        setItems(newItems, false)
    }

    /**
     * Updates items with use of DiffUtil callback [DiffUtil.Callback]
     *
     * @param newItems     new items
     * @param diffCallback DiffUtil callback
     */
    fun updateItems(newItems: List<T>, diffCallback: DiffUtil.Callback) {
        val result = DiffUtil.calculateDiff(diffCallback, false)
        setItems(newItems, false)
        result.dispatchUpdatesTo(this)
    }

    /**
     * Returns all items from the data set held by the adapter.
     *
     * @return All of items in this adapter.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    fun getItems(): List<T>? {
        return items
    }

    /**
     * Returns an items from the data set at a certain position.
     *
     * @return All of items in this adapter.
     */
    fun getItem(position: Int): T? {
        return items?.get(position)
    }

    /**
     * Adds item to the end of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    fun add(item: T?) {
        requireNotNull(item) { "Cannot add null item to the Recycler adapter" }
        items?.add(item)
        notifyItemInserted(items?.size ?: 0 - 1)
    }

    /**
     * Adds item to the beginning of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    fun addToBeginning(item: T?) {
        requireNotNull(item) { "Cannot add null item to the Recycler adapter" }
        items?.add(0, item)
        notifyItemInserted(0)
    }

    /**
     * Adds list of items to the end of the adapter's data set.
     * Notifies that item has been inserted.
     *
     * @param items items which has to be added to the adapter.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    fun addAll(items: List<T>?) {
        requireNotNull(items) { "Cannot add `null` items to the Recycler adapter" }
        this.items?.addAll(items)
        notifyItemRangeInserted(this.items?.size ?: 0 - items.size, items.size)
    }

    /**
     * Clears all the items in the adapter.
     *
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    fun clear() {
        items?.clear()
        notifyDataSetChanged()
    }

    /**
     * Removes an item from the adapter.
     * Notifies that item has been removed.
     *
     * @param item to be removed
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    fun remove(item: T) {
        val position = items?.indexOf(item) ?: 0
        if (position > -1) {
            items?.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    /**
     * Indicates whether each item in the data set can be represented with a unique identifier
     * of type [Long].
     *
     * @param hasStableIds Whether items in data set have unique identifiers or not.
     * @see .hasStableIds
     * @see .getItemId
     */
    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }

    /**
     * Inflates a view.
     *
     * @param layout       layout to me inflater
     * @param parent       container where to inflate
     * @param attachToRoot whether to attach to root or not
     * @return inflated View
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    @NonNull
    @JvmOverloads
    protected fun inflate(@LayoutRes layout: Int, @Nullable parent: ViewGroup, attachToRoot: Boolean = false): View {
        return layoutInflater!!.inflate(layout, parent, attachToRoot)
    }
}
/**
 * Sets items to the adapter and notifies that data set has been changed.
 *
 * @param items items to set to the adapter
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */
/**
 * Inflates a view.
 *
 * @param layout layout to me inflater
 * @param parent container where to inflate
 * @return inflated View
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */
