package hackeru.zakalinskyevgeny.mycinemaapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.R
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.SearchMovie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.TMBDResult
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.SearchItemBinding

class SearchAdapter(private val onSearchItemClick: (TMBDResult) -> Unit) : ListAdapter<TMBDResult, SearchAdapter.SearchVH>(Comparator()) {
        class SearchVH(view : View) : RecyclerView.ViewHolder(view) {

            private val binding = SearchItemBinding.bind(view)

            fun bind(searchMovie: TMBDResult, onSearchItemClick :  (TMBDResult) -> Unit) = with(binding) {
                searchTitle.text = searchMovie.title
                searchOverview.text = searchMovie.overview

                val pic = "https://image.tmdb.org/t/p/w185" + searchMovie.posterPath
                pic.let { image ->
                    Picasso.get().load(image).into(binding.searchPoster)
                }

                binding.searchCard.setOnClickListener {
                    onSearchItemClick.invoke(searchMovie)
                }
            }
        }

    class Comparator: DiffUtil.ItemCallback<TMBDResult>() {
        override fun areItemsTheSame(oldItem: TMBDResult, newItem: TMBDResult): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: TMBDResult, newItem: TMBDResult): Boolean {
            return oldItem == newItem
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.SearchVH {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.search_item,
            parent,
            false
        )
        return SearchAdapter.SearchVH(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchVH, position: Int) {
        holder.bind(getItem(position), onSearchItemClick)
    }
}