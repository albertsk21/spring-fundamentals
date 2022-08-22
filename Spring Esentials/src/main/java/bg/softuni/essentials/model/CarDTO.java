package bg.softuni.essentials.model;

public class CarDTO {


    private long id;
    private String make;
    private String model;
    private EngineEnum engine;
    private boolean insured;

    public CarDTO( long id,String make, String model, EngineEnum engine, boolean insured) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.insured = insured;
    }

    public CarDTO() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }


    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public boolean isInsured() {
        return insured;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", insured=" + insured +
                '}';
    }
}
