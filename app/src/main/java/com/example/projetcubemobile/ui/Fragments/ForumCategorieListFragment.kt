package com.example.projetcubemobile.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetcubemobile.R
import com.example.projetcubemobile.RecyclerViewAdapter.MyForumCategorieListRecyclerViewAdapter
import com.example.projetcubemobile.models.CategorieModel
import com.example.projetcubemobile.ui.Fragments.placeholder.PlaceholderContent
import java.util.LinkedList

/**
 * A fragment representing a list of Items.
 */
class ForumCategorieListFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View?

    {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        //Essaie de données de test :
        var donne1 = CategorieModel();

        donne1.id = 1;
        donne1.title = "test 1"

        var donne2 = CategorieModel();

        donne2.id = 2;
        donne2.title = "test 2"

        val listTest = LinkedList<CategorieModel>();

        listTest.add(donne1)
        listTest.add(donne2)



        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyForumCategorieListRecyclerViewAdapter(listTest)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ForumCategorieListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}