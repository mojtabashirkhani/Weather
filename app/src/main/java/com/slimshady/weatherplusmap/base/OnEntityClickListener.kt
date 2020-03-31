package com.slimshady.weatherplusmap.base

interface OnEntityClickListener<T> : BaseRecyclerListener {

    /**
     * Item has been clicked.
     * Here you retrieve an entity associated with the clicked item and you are free to use it in any way.
     *
     * @param item object associated with the clicked item.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 0.1.0
     */
    fun onItemClicked(item: T)
}