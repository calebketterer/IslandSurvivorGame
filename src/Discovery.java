public class Discovery {
    private final String DiscoveryName;
    private final int ExpGain;

    private final String FlavorText;
    private final String Narrative;
    private final int Nourishment;
    private final int Rarity; // out of 100
    private final int Worth;

    private Discovery(DiscoveryBuilder builder) {
        this.DiscoveryName = builder.DiscoveryName;
        this.ExpGain = builder.ExpGain;
        this.FlavorText = builder.FlavorText;
        this.Narrative = builder.Narrative;
        this.Nourishment = builder.Nourishment;
        this.Rarity = builder.Rarity;
        this.Worth = builder.Worth;
    }

    public String getDiscoveryName() { return DiscoveryName;}
    public int getExpGain() { return ExpGain;}
    public String getFlavorText() { return FlavorText;}
    public String getNarrative() {
        return Narrative;
    }
    public int getNourishment() { return Nourishment; }
    public int getRarity() {
        return Rarity;
    }
    public int getWorth() { return Worth; }

    @Override
    public String toString() {
        return "Discovery: " + this.DiscoveryName + " grants " + this.ExpGain + " experience upon finding it. " + this.Narrative + "\n\n"+ this.FlavorText;}

    public static class DiscoveryBuilder{
        private final String DiscoveryName;
        private final int ExpGain;
        private String FlavorText;
        private String Narrative;
        private int Nourishment;
        private int Rarity;
        private int Worth;

        public DiscoveryBuilder(String DiscoveryName, int ExpGain){
            this.DiscoveryName = DiscoveryName;
            this.ExpGain = ExpGain;
        }

        public DiscoveryBuilder Narrative(String Narrative){this.Narrative = Narrative;return this;}
        public DiscoveryBuilder FlavorText(String FlavorText){this.FlavorText = FlavorText; return this;}
        public DiscoveryBuilder Rarity(int Rarity){this.Rarity = Rarity; return this;}
        public DiscoveryBuilder Nourishment(int Nourishment){this.Nourishment = Nourishment; return this;}
        public DiscoveryBuilder Worth(int Worth){this.Worth = Worth; return this;}

        public Discovery build(){
            Discovery discovery = new Discovery(this);
            validateDiscoveryObjects(discovery);
            return discovery;
        }

        private void validateDiscoveryObjects(Discovery discovery){}
    }
}