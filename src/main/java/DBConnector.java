import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DBConnector {

    public Connection getConnection() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "postgres";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        finally {
        }
        return con;
    }

    public void deleteStudent(Students students) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String query = "DELETE FROM students s WHERE s.fullName=" +"\'"+students.getFullName()+"\'" +"AND s.faculty="+"\'" +students.getFaculty()+"\'";
        try {
             pst = con.prepareStatement(query);
             pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateStudent(Students student, Students selectedStudent) {
       ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String query = "UPDATE students s SET s.fullName=" +"\'"+student.getFullName()+"\'" +"AND s.faculty="+"\'" +student.getFaculty()+"\' " +
                "WHERE s.fullName=" +"\'"+selectedStudent.getFullName()+"\'" +"AND s.faculty="+"\'" +selectedStudent.getFaculty();
        try {
             pst = con.prepareStatement(query);
             pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public List<Students> getAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String stm = "Select * from students";
        List<Students> records = new ArrayList<Students>();

        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while(rs.next()) {
                Students student = new Students();
                student.setFaculty(rs.getString(1));
                student.setFullName(rs.getString(2));
                records.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Students> insertStudent(String fullName, String faculty) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String stm = "insert into students (fullname,faculty) VALUES (" +"\'"+ fullName +"\'"+ "," +"\'"+ faculty +"\'"+ ")" ;
        List<Students> records = new ArrayList<Students>();

        try {
            pst = con.prepareStatement(stm);
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
