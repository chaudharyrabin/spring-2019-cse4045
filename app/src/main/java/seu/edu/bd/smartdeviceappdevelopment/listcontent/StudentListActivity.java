package seu.edu.bd.smartdeviceappdevelopment.listcontent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import seu.edu.bd.smartdeviceappdevelopment.R;

public class StudentListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Student> students;
    StudentListAdapter studentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerView = findViewById(R.id.studentListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // add data into student list
        students = new ArrayList<>();

        students.add(new Student("A","CSE","001"));
        students.add(new Student("B","EEE","124"));
        students.add(new Student("C","CSE","12"));
        students.add(new Student("D","CSE","24"));
        students.add(new Student("E","TEXT","32"));
        students.add(new Student("AA","CSE","111"));
        students.add(new Student("AB","CSE","200"));
        students.add(new Student("AC","EEE","300"));
        students.add(new Student("AD","CSE","13"));
        students.add(new Student("AE","BBA","201"));
        students.add(new Student("AAA","CSE","202"));
        students.add(new Student("ABC","MBA","203"));
        students.add(new Student("AEC","CSE","204"));

        //
        studentListAdapter = new StudentListAdapter(students, this);
        recyclerView.setAdapter(studentListAdapter);
    }
}
