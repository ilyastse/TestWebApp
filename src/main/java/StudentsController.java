import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;
import java.util.List;


@ManagedBean(name = "studentController")
@SessionScoped
public class StudentsController {


    private DBConnector DBConnector = new DBConnector();

    private String fullName;
    private String faculty;
    private List<Students> listStudents;
    private Students selectedStudent;

    public Students getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Students selectedStudent) {
        this.selectedStudent = selectedStudent;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String create() throws SQLException {
        DBConnector.insertStudent(fullName, faculty);
        return "success";

    }

    public void update(Students students, Students selectedStudent) throws SQLException {
        DBConnector.updateStudent(students,selectedStudent);

    }


    public void delete(Students students) throws SQLException {
        DBConnector.deleteStudent(students);

    }

    public List<Students> getAll() throws SQLException {
        return updateList();
    }


    private List<Students> updateList() {
        listStudents = DBConnector.getAll();
        return listStudents;
    }


}

