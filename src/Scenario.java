public class Scenario {
    private final String ScenarioName;
    private final int Worth;

    private String Narrative;
    private int CoastRarity; // out of 100
    private String FlavorText;

    private Scenario(ScenarioBuilder builder) {
        this.ScenarioName = builder.ScenarioName;
        this.Worth = builder.Worth;
        this.Narrative = builder.Narrative;
        this.CoastRarity = builder.CoastRarity;
        this.FlavorText = builder.FlavorText;
    }

    public String getScenarioName() {
        return ScenarioName;
    }
    public int getWorth() {
        return Worth;
    }
    public String getNarrative() {
        return Narrative;
    }
    public int getCoastRarity() {
        return CoastRarity;
    }
    public String getFlavorText() {
        return FlavorText;
    }

    @Override
    public String toString() {
        return "Scenario: " + this.ScenarioName + " grants " + this.Worth + " experience upon completion. " + this.Narrative + "\n\n"+ this.FlavorText;}

    public static class ScenarioBuilder{
        private final String ScenarioName;
        private final int Worth;
        private String Narrative;
        private int CoastRarity;
        private String FlavorText;

        public ScenarioBuilder(String ScenarioName, int Worth){
            this.ScenarioName = ScenarioName;
            this.Worth = Worth;
        }

        public ScenarioBuilder Narrative(String Narrative){this.Narrative = Narrative;return this;}
        public ScenarioBuilder Flavortext(String FlavorText){this.FlavorText = FlavorText; return this;}
        public ScenarioBuilder CoastRarity(int CoastRarity){this.CoastRarity = CoastRarity; return this;}


        public Scenario build(){
            Scenario scenario = new Scenario(this);
            validateScenarioObjects(scenario);
            return scenario;
        }

        private void validateScenarioObjects(Scenario scenario){}
    }
}

