package com.newshub.presentation.common.decorations

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by mickaelg on 23/02/2016.
 */
class VerticalSpacingDecoration(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = verticalSpaceHeight;
        }
    }

}