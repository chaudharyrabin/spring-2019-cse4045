package seu.edu.bd.smartdeviceappdevelopment.listcontent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import seu.edu.bd.smartdeviceappdevelopment.R;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListView>{

    private ArrayList<Student> students;
    private Context context;

    public StudentListAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentListView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StudentListView(LayoutInflater.from(context).inflate(R.layout.adapter_student_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListView studentListView, int index) {
        Student student = students.get(index);
        studentListView.name.setText(student.getName());
        studentListView.dept.setText(student.getDept());
        studentListView.id.setText(student.getId());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentListView extends RecyclerView.ViewHolder{

        TextView name, dept, id;

        public StudentListView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.student_name);
            dept = itemView.findViewById(R.id.department);
            id = itemView.findViewById(R.id.student_id);
        }
    }
}
