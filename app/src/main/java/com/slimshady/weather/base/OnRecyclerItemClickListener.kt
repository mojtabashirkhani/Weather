package com.slimshady.weather.base

interface OnRecyclerItemClickListener : BaseRecyclerListener {

    /**
     * Returns clicked item position [RecyclerView.ViewHolder.getAdapterPosition]
     *
     * @param position clicked item position.
     */
    fun onItemClick(position: Int)
}