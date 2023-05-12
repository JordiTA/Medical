package com.example.medical

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

// Creacion de Adapter Class. Heredara de Recycler View (No necesita View Holder)
class TodoAdapter(val list: List<TodoModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // 3 funciones del ViewHolder:

    // 1-En este inflater de layout se convierte la view para que el Adapter pueda usarla
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun getItemCount() = list.size

    // 2-Esta funcion ordenara los datos en su posicion adecuada
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position]) // we are passing the object of the list that we made in the ToDoModel.kt
    }

    // 3-Esta funcion hace get por posicion de los datos
    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    // View Holder dentro del Recycler View
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: TodoModel) {
            with(itemView) {
                val colors = resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]

                val viewColorTag: View = findViewById(R.id.viewColorTag)
                val txtShowTitle: TextView = findViewById(R.id.txtShowTitle)
                val txtShowTask: TextView = findViewById(R.id.txtShowTask)
                val txtShowCategory: TextView = findViewById(R.id.txtShowCategory)

                viewColorTag.setBackgroundColor(randomColor)
                txtShowTitle.text = todoModel.title
                txtShowTask.text = todoModel.description
                txtShowCategory.text = todoModel.category
                updateTime(todoModel.time)
                updateDate(todoModel.date)

            }
        }
        private fun updateTime(_time: Long) {

            val myFormat = "h:mm a"
            val sdf = SimpleDateFormat(myFormat)

            with(itemView){
                val txtShowTime: TextView = findViewById(R.id.txtShowTime)
                txtShowTime.text = sdf.format(Date(_time))
            }
        }

        private fun updateDate(_time: Long) {

            val myFormat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myFormat)
            with(itemView){
                val txtShowDate: TextView = findViewById(R.id.txtShowDate)
                txtShowDate.text = sdf.format(Date(_time))
            }
        }
    }

}


