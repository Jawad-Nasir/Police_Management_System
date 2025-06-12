public class Complain {
    private int id;
    private String name, cnic, description;
    private boolean isSolved;

    public Complain(int id, String name, String cnic, String description, boolean isSolved) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.description = description;
        this.isSolved = isSolved;
    }

    public Complain(String name, String cnic, String description) {
        this(0, name, cnic, description, false);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCnic() { return cnic; }
    public String getDescription() { return description; }
    public boolean isSolved() { return isSolved; }
    public void setSolved(boolean solved) { isSolved = solved; }
}