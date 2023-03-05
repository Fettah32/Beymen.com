package pojos;

public class deleteCard {

    private String id;

    public deleteCard() {
    }

    public deleteCard(String id, String id2) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "deleteCard{" +
                "id='" + id + '\'' +
                '}';
    }
}
