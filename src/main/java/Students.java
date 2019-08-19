public class Students {
    private String fullName;
    private String faculty;

    public Students(){

    }

    public Students(String fullName, String faculty) {
        this.fullName = fullName;
        this.faculty = faculty;
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
}
