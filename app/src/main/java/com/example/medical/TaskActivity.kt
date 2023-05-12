package com.example.medical

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

const val DB_NAME = "todo.db"

class TaskActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var myCalendar: Calendar

    lateinit var dateSetListener: DatePickerDialog.OnDateSetListener
    lateinit var timeSetListener: TimePickerDialog.OnTimeSetListener

    var finalDate = 0L
    var finalTime = 0L

    //Labels para escoger cuando tomarse la pastilla, medicacion...
    private val labels = arrayListOf("Morning", "AfterLunch", "Evening", "AfterDinner", "Night")


    val db by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val dateEdt: TextInputEditText = findViewById(R.id.dateEdt)
        val timeEdt: TextInputEditText = findViewById(R.id.timeEdt)
        val saveBtn: MaterialButton = findViewById(R.id.saveBtn)

        dateEdt.setOnClickListener(this)
        timeEdt.setOnClickListener(this)
        saveBtn.setOnClickListener(this)

        setUpSpinner()
    }

    private fun setUpSpinner() {
        val spinnerCategory: Spinner = findViewById(R.id.spinnerCategory)

        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, labels)

        labels.sort()

        spinnerCategory.adapter = adapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.dateEdt -> {
                setListener()
            }
            R.id.timeEdt -> {
                setTimeListener()
            }
            R.id.saveBtn -> {
                saveTodo()
            }
        }
    }

    //Guardar en la base de datos todos los cambios
    @OptIn(DelicateCoroutinesApi::class)
    private fun saveTodo() {
        val spinnerCategory: Spinner = findViewById(R.id.spinnerCategory)
        val titleInpLay: TextInputLayout = findViewById(R.id.titleInpLay)
        val taskInpLay: TextInputLayout = findViewById(R.id.taskInpLay)

        val category = spinnerCategory.selectedItem.toString()
        val title = titleInpLay.editText?.text.toString()
        val description = taskInpLay.editText?.text.toString()


        GlobalScope.launch(Dispatchers.Main) {
            val id = withContext(Dispatchers.IO) {
                return@withContext db.todoDao().insertTask(
                    TodoModel(
                        title,
                        description,
                        category,
                        finalDate,
                        finalTime
                    )
                )
            }
            finish()
        }

    }
    //Time
    private fun setTimeListener() {
        myCalendar = Calendar.getInstance()

        timeSetListener =
            TimePickerDialog.OnTimeSetListener() { _: TimePicker, hourOfDay: Int, min: Int ->
                myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                myCalendar.set(Calendar.MINUTE, min)
                updateTime()
            }

        val timePickerDialog = TimePickerDialog(
            this, timeSetListener, myCalendar.get(Calendar.HOUR_OF_DAY),
            myCalendar.get(Calendar.MINUTE), false
        )
        timePickerDialog.show()
    }
    private fun updateTime() {
        val uTimeEdt: TextInputEditText = findViewById(R.id.timeEdt)
        val myFormat = "h:mm a"
        val sdf = SimpleDateFormat(myFormat)
        finalTime = myCalendar.time.time
        uTimeEdt.setText(sdf.format(myCalendar.time))

    }
    //Date
    private fun setListener() {
        myCalendar = Calendar.getInstance()

        dateSetListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDate()

            }

        val datePickerDialog = DatePickerDialog(
            this, dateSetListener, myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        datePickerDialog.show()
    }
    private fun updateDate() {
        val uDateEdt: TextInputEditText = findViewById(R.id.dateEdt)
        val timeInptLay: TextInputLayout = findViewById(R.id.timeInptLay)

        val myFormat = "EEE, d MMM yyyy"
        val sdf = SimpleDateFormat(myFormat)

        finalDate = myCalendar.time.time
        uDateEdt.setText(sdf.format(myCalendar.time))

        timeInptLay.visibility = View.VISIBLE
    }
}
