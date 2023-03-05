package pojos;

public class cardsPost {

    private String idList;

    public cardsPost() {
    }

    public cardsPost(String idList) {
        this.idList = idList;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    @Override
    public String toString() {
        return "cardsPost{" +
                "idList='" + idList + '\'' +
                '}';
    }
}
