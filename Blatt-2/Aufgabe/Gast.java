class Gast {
    int zimmer;
    String name;

    public Gast() {
        // tu nix.
    }

    public Gast(String name, int pZimmer) {
        this.name = name;
        zimmer = pZimmer;
    }

    public int getZimmer() {
        // Neubau: deswegen +20
        return zimmer + 20;
    }

    public void einchecken() {
        System.out.println("Gast " + name  + " wurde eingecheckt");
    }

    public void einchecken(int dauer) {
        // TODO: in die Datenbank schreiben
        System.out.println("Gast " + this.name + " wurde für " + dauer + " Tage eingecheckt.");
    }
}
