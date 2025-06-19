public class Citizen {
    private int id;
    private String name;
    private String cnic;

    public Citizen(int id, String name, String cnic) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
    }

    public Citizen(String name, String cnic) {
        this(0, name, cnic);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }
}
