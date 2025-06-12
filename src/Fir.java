public class Fir {
    private int id;
    private String name, cnic, date, time, location, description;

    public Fir(int id, String name, String cnic, String date, String time, String location, String description) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
    }

    public Fir(String name, String cnic, String date, String time, String location, String description) {
        this(0, name, cnic, date, time, location, description);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCnic() { return cnic; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
}