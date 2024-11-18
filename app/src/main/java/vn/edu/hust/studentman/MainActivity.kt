package vn.edu.hust.studentman

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.studentman.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity(),StudentAdapter.OnStudentActionListener {
    private lateinit var studentAdapter: StudentAdapter
    val students = mutableListOf(
        StudentModel("Nguyễn Văn An", "SV001"),
        StudentModel("Trần Thị Bảo", "SV002"),
        StudentModel("Lê Hoàng Cường", "SV003"),
        StudentModel("Phạm Thị Dung", "SV004"),
        StudentModel("Đỗ Minh Đức", "SV005"),
        StudentModel("Vũ Thị Hoa", "SV006"),
        StudentModel("Hoàng Văn Hải", "SV007"),
        StudentModel("Bùi Thị Hạnh", "SV008"),
        StudentModel("Đinh Văn Hùng", "SV009"),
        StudentModel("Nguyễn Thị Linh", "SV010"),
        StudentModel("Phạm Văn Long", "SV011"),
        StudentModel("Trần Thị Mai", "SV012"),
        StudentModel("Lê Thị Ngọc", "SV013"),
        StudentModel("Vũ Văn Nam", "SV014"),
        StudentModel("Hoàng Thị Phương", "SV015"),
        StudentModel("Đỗ Văn Quân", "SV016"),
        StudentModel("Nguyễn Thị Thu", "SV017"),
        StudentModel("Trần Văn Tài", "SV018"),
        StudentModel("Phạm Thị Tuyết", "SV019"),
        StudentModel("Lê Văn Vũ", "SV020")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun showCustomDialog(name: String, SID: String) {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog)
            val editFullName = dialog.findViewById<EditText>(R.id.editTextText)
            editFullName.setText(name)
            val editSID = dialog.findViewById<EditText>(R.id.editTextText2)
            editSID.setText(SID)
            dialog.findViewById<Button>(R.id.dialogBtnSave).setOnClickListener {
// TODO: Do something with name and email

                dialog.dismiss()
            }
            dialog.findViewById<Button>(R.id.dialogBtnCancel).setOnClickListener {
                dialog.dismiss()
            }
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_students)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val addBtn = findViewById<Button>(R.id.btn_add_new)
        addBtn.setOnClickListener{
            showCustomDialog("","")
        }

        studentAdapter = StudentAdapter(students, this)
        recyclerView.adapter = studentAdapter

    }

    override fun onEditStudent(position: Int) {
        Toast.makeText(this, "Edit: ${students[position]}", Toast.LENGTH_SHORT).show()
        // Add your edit logic here
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onRemoveStudent(position: Int) {
        Toast.makeText(this, "Remove: ${students[position]}", Toast.LENGTH_SHORT).show()
        // Add your remove logic here
        students.removeAt(position)
        studentAdapter.notifyDataSetChanged()
    }
}
