public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int yearOfStudy;
    private String group;


    public Student(int id, String firstName, String lastName, String middleName, String dateOfBirth, String address, String phoneNumber, String faculty, int yearOfStudy, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
    }
    public Student(int id, String firstName, String lastName, String middleName, String faculty, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", group='" + group + '\'' +
                '}';
    }
}
