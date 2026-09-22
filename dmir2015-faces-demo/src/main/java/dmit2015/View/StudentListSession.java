package dmit2015.View;

import dmit2015.model.StudentInfo;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class StudentListSession implements Serializable {

    private List<StudentInfo> studentInfoList = new ArrayList<>();

    public void addStudentInfo(StudentInfo studentInfo) {
        studentInfoList.add(studentInfo);
    }

    public List<StudentInfo> getStudentInfoList() {
        return studentInfoList;
    }
}
