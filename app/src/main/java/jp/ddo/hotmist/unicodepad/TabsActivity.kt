/*
   Copyright 2018 Ryosuke839

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package jp.ddo.hotmist.unicodepad

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import com.mobeta.android.dslv.DragSortController
import com.mobeta.android.dslv.DragSortListView

class TabsActivity : BaseActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = DragSortListView(this, null)
        val controller = DragSortController(view, R.id.HANDLE_ID, DragSortController.ON_DRAG, DragSortController.FLING_REMOVE)
        controller.isSortEnabled = true
        controller.setBackgroundColor(TypedValue().also { tv ->
            theme.resolveAttribute(android.R.attr.windowBackground, tv, true)
        }.data)
        view.setFloatViewManager(controller)
        view.setOnTouchListener(controller)
        view.adapter = TabsAdapter(this, view)
        setContentView(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}