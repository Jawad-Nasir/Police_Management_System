public class Complain {
    private int id;
    private int citizenId;
    private String name;
    private String cnic;
    private String description;
    private boolean isSolved;

    public Complain(int id, String name, String cnic, String description, boolean isSolved) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.description = description;
        this.isSolved = isSolved;
    }

    public Complain(int id, String description) {
        this.description = description;
        this.id = id;
    }

    public Complain(String name, String cnic, String description) {
        this(0, name, cnic, description, false);
    }

    public Complain(int id, int citizenId, String description, boolean isSolved) {
        this.id = id;
        this.citizenId = citizenId;
        this.description = description;
        this.isSolved = isSolved;
    }

    // Getters
    public int getId() { return id; }
    public int getCitizenId() { return citizenId; }
    public String getName() { return name; }
    public String getCnic() { return cnic; }
    public String getDescription() { return description; }
    public boolean isSolved() { return isSolved; }

    public void setSolved(boolean isSolved) { this.isSolved = isSolved; }
}
