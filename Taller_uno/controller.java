import java.util.ArrayList;

public class controller {
    public controller(){
        bioinformatic jaja = new bioinformatic();
        int quantity = 1050300; // 10000 and 2000000           //hasta 100
        ArrayList<String> sequences= jaja.sequence(quantity,100, 0, 1, 2, 3);
        jaja.createTxT(jaja.dataBaseSequences(quantity, sequences));
        try {
            System.out.println(jaja.findMotif("database.txt", 48));    
        } catch (Exception e) {
        }
        double entropia = jaja.calculateEntropy(sequences);
        System.out.println("La entropia calculada es: " + entropia);
    }
    
}