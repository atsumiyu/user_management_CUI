public class User {

    private int id;
    private String company;
    private String name;
    private int score;

    private static int count;

    public User(String company, String name, int score) {
        count++;
        this.id = count;
        this.company = company;
        this.name = name;
        this.score = score;
    }

//    public void getInfo() {
//        System.out.println("|" + id + "|" + company + "|" + name + "|" + score + "|");
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
