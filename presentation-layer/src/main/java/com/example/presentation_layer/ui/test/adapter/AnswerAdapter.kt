package com.example.presentation_layer.ui.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation_layer.R
import com.example.presentation_layer.databinding.AnswerItemBinding
import kotlin.properties.Delegates

class AnswerAdapter(private val onAnswerSelect: (position: Int) -> Unit) :
    RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    var items: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // This keeps track of the currently selected position
    var selectedPosition by Delegates.observable(-1) { property, oldPos, newPos ->
        if (newPos in items.indices) {
            notifyItemChanged(oldPos)
            notifyItemChanged(newPos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder =
        AnswerViewHolder(
            AnswerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        if (position in items.indices) {
            holder.bind(position, items[position], position == selectedPosition)
            holder.itemView.setOnClickListener {
                selectedPosition = position
                onAnswerSelect(position)
            }
        }
    }

    inner class AnswerViewHolder(private val viewBinding: AnswerItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(position: Int, answer: String, selected: Boolean) {
            with(viewBinding) {
                answerNumberTv.text = "${position + 1} :"
                answerTv.text = answer
                if (selected) {
                    answerContainer.background =
                        ContextCompat.getDrawable(answerContainer.context!!, R.drawable.selected_answer_border)
                    answerNumberTv.setTextColor(
                        ContextCompat.getColor(
                            answerNumberTv.context!!,
                            R.color.teal_200
                        )
                    )
                    answerTv.setTextColor(
                        ContextCompat.getColor(
                            answerTv.context!!,
                            R.color.teal_200
                        )
                    )
                } else {
                    answerContainer.background =
                        ContextCompat.getDrawable(answerContainer.context!!, R.drawable.un_selected_answer_border)
                    answerNumberTv.setTextColor(
                        ContextCompat.getColor(
                            answerNumberTv.context!!,
                            R.color.textColor
                        )
                    )
                    answerTv.setTextColor(
                        ContextCompat.getColor(
                            answerTv.context!!,
                            R.color.textColor
                        )
                    )
                }
            }
        }
    }
}