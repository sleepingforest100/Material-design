package kz.just_code.material_designapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.util.Pair
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kz.just_code.material_designapp.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val badge = binding.bottomNavigation.getOrCreateBadge(R.id.page_5)
        badge.isVisible = true
        badge.number = 23

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 5)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(calendar.timeInMillis)
                .build()


        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select dates")
            .setSelection(
                Pair(
                    Date().time,
                    calendar.timeInMillis
                )
            )
                .build()
        binding.textButton.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, "")
        }

        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(calendar.get(Calendar.HOUR))
                .setMinute(calendar.get(Calendar.MINUTE))
                .build()

        binding.cardView.setOnClickListener {
            picker.show(supportFragmentManager, "")
        }
        binding.floatingActionButton.setOnClickListener {
            Snackbar.make(binding.floatingActionButton, "Hello snackBar", Snackbar.LENGTH_SHORT)
                .setAction("Done"){
                    Toast.makeText(this, "Clicked done", Toast.LENGTH_SHORT)
                }
               // .setAnchorView(binding.bottomNavigation)
                .setBackgroundTint(ContextCompat.getColor(this, R.color.DeepSkyBlue))
                .show()
        }
    }
}