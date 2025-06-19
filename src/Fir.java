public class Fir {
    private int id;
    private int citizenId;
    private String date;
    private String time;
    private String location;
    private String description;

    public Fir(int id, int citizenId, String date, String time, String location, String description) {
        this.id = id;
        this.citizenId = citizenId;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
    }

    public Fir(int citizenId, String date, String time, String location, String description) {
        this(0, citizenId, date, time, location, description);
    }

    public int getId() {
        return id;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
