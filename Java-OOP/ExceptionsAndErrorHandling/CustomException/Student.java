package CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        setName(name);
        this.email = email;
    }

    private void setName(String name) {
        if (validateName(name)) {
            throw new InvalidPersonNameException("Invalid name!");
        }
        this.name = name;
    }

    private boolean validateName(String name) {
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
