import java.util.ArrayList;

public class controller {
    public controller(){
        bioinformatic jaja = new bioinformatic();
        int quantity = 10000;
        ArrayList<String> sequences= jaja.sequence(quantity,6, 0, 2, 3, 1);
        jaja.createTxT(jaja.dataBaseSequences(quantity, sequences));
        try {
            System.out.println(jaja.findMotif("database.txt", 3));    
        } catch (Exception e) {
        }
        double entropia = jaja.calculateEntropy(sequences);
        System.out.println("La entropia calculada es: " + entropia);
    }
    
}