package pojos;

public class boardsPost {

    private String name;

    public boardsPost() {
    }

    public boardsPost(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "boardsPost{" +
                "name='" + name + '\'' +
                '}';
    }
}
