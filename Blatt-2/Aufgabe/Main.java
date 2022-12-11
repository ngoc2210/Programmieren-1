class Main {
    public static void main(String[] args) {
        Gast gast1 = new Gast("Max Mustermann", 321);

        Gast gast2 = new Gast();
        gast2.zimmer = 50;
        gast2.name = "Maria Mustermann";

        gast1.einchecken();
        gast2.einchecken(3);

        System.out.println("Gast im Hotel: " + gast1.name + " wohnt in Zimmer #" + gast1.getZimmer());

        
    }
}
