package br.trainingForme.com.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

open class GenericListAdapter<T : Any>(
    @LayoutRes val itemLayout: Int,
    @LayoutRes val itemEmpty: Int? = null,
    inline val bind: (item: T, holder: BaseViewHolder, itemCount: Int) -> Unit,
    inline val bindEmpty: ((holder: BaseViewHolder) -> Unit)? = null
) : ListAdapter<T, BaseViewHolder>(BaseItemCallback<T>()) {

    companion object {
        private const val typeEmpty = 0
        private const val typeData = 1
    }

    @CallSuper
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        with(holder) {
            if (itemViewType == typeEmpty) bindEmpty?.let { empty -> empty(holder) }
            else bind(getItem(position), holder, itemCount)
        }

    }

    private val emptyList = listOf<T?>(null)

    @CallSuper
    override fun submitList(list: List<T>?) {
        if ((list == null || list.isEmpty()) && (itemEmpty != null || bindEmpty != null))
            super.submitList(emptyList)
        else
            super.submitList(list)
    }

    @CallSuper
    override fun getItemViewType(position: Int) =
        if (currentList.size == 1 && currentList[position] == null) typeEmpty else typeData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val root = if (viewType == typeData)
            LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        else
            itemEmpty?.let { item ->
                LayoutInflater.from(parent.context).inflate(item, parent, false)
            }

        return BaseViewHolder(root as ViewGroup)
    }

    override fun getItemCount() = currentList.size

}

class BaseViewHolder(container: ViewGroup) : RecyclerView.ViewHolder(container)

class BaseItemCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.toString() == newItem.toString()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}