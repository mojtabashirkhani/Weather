package com.slimshady.weatherplusmap.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/** BaseViewHolder is an abstract class for structuring the base view holder class. */
@Suppress("unused", "LeakingThis")
abstract class BaseViewHolder<T, L : BaseRecyclerListener> : RecyclerView.ViewHolder {

  protected var  listener: L? = null

  constructor(itemView: View) : super(itemView) {}

  constructor(itemView: View, listener: L?) : super(itemView) {
    this.listener = listener
  }

  /**
   * Bind data to the item.
   * Make sure not to perform any expensive operations here.
   *
   * @param item object, associated with the item.
   * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
   * @since 1.0.0
   */
  abstract fun onBind(item: T)

  /**
   * Bind data to the item.
   * Override this method for using the payloads in order to achieve the full power of DiffUtil
   *
   * @param item object, associated with the item.
   * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
   * @since 1.0.0
   */
  fun onBind(item: T, payloads: List<Any>) {
    onBind(item)
  }
}
