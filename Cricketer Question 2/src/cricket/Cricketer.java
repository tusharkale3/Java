package cricket;



public class Cricketer {
    private String name;
    private int age;
    private String emailId;
    private String phone;
    private int rating;

    public Cricketer(String name, int age, String emailId, String phone, int rating) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.phone = phone;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhone() {
        return phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nAge: " + age +
               "\nEmail ID: " + emailId +
               "\nPhone: " + phone +
               "\nRating: " + rating;
    }
}
