import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class bioinformatic {

    public Random r = new Random();


    public ArrayList<String> sequence(int quantity, int size, int key_A, int key_C, int key_G, int key_T){
        String sequence_str = "";
        ArrayList<String> sequences = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            while (sequence_str.length() < size) {
                int key = r.nextInt(0,4);
                if (key == key_A){
                    sequence_str = sequence_str + "A";
                }else if(key == key_C){
                    sequence_str = sequence_str + "C";
                }else if(key == key_G){
                    sequence_str = sequence_str + "G";
                }
                else if(key == key_T){
                    sequence_str = sequence_str + "T";
                }
            }
            sequences.add(sequence_str);
            sequence_str = "";
        }
        return sequences;
    }

    public double calculateEntropy(ArrayList<String> sequences){
        ArrayList<Double> indivEntropy = new ArrayList<>();
        
        for (String sequence : sequences){
            int counter[] = new int[4];
            for(char c : sequence.toCharArray()){
                switch (c) {
                    case 'A':
                        counter[0]++;
                        break;
                    case 'C':
                        counter[1]++;
                        break;
                    case 'G':
                        counter[2]++;
                        break;
                    case 'T':
                        counter[3]++;
                        break;
                    default:
                        break;
                }
            }
            double entropy = 0;
            for (int count : counter) {
                double probrability = (double)count/sequence.length();
                if(probrability > 0 ){
                    entropy =- -probrability * Math.log(probrability) / Math.log(2);
                    
                }
            }
            indivEntropy.add(entropy);    
        }
        double sum = 0;
        for(int i = 0; i < indivEntropy.size(); i++){
            sum += indivEntropy.get(i);
        }
        double average = sum / indivEntropy.size();
        return average;
    }

    public HashMap<Integer, String> dataBaseSequences(int quantity, ArrayList<String> sequence){
        HashMap<Integer, String> lista = new HashMap<>();
        for (int i = 0; i < quantity; i++){
            lista.put(i, sequence.get(i));
        }
        
        return lista;
    }

    public void createTxT(HashMap<Integer, String> list){
        File file = new File("database.txt");
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + "\n");
            }
            
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String findMotif(String file, int size) throws FileNotFoundException, IOException { 
        long startTime = System.nanoTime();
        ArrayList<String> lines = new ArrayList<>();
        try (FileReader f = new FileReader(file); 
            BufferedReader b = new BufferedReader(f)) {
            
            String line;

            while ((line = b.readLine()) != null) {
                lines.add(line); 
            }
        }catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + file);
            e.printStackTrace();  
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + file);
            e.printStackTrace();  
        }
        
        
        HashMap<String , Integer> motifList = new HashMap<>();
        for(String line : lines){
            char characters[] = line.toCharArray();
            ArrayList<Character> charactersList = new ArrayList<>();
            
            for (char c : characters) {
                charactersList.add(c); 
            }

            while (charactersList.size() >= size) {
                String sequence = "";
                for (int i = 0; i < size && !charactersList.isEmpty(); i++) {
                    sequence = sequence + charactersList.remove(0); 
                }
                
                if (!motifList.containsKey(sequence)) {
                    motifList.put(sequence, 1); 
                } else {
                    int size2 = motifList.get(sequence) + 1; 
                    motifList.replace(sequence, size2);
                }
            }
            
        }
        
        int biggest = Integer.MIN_VALUE;
        String keyWithBiggest = null;

        for (Map.Entry<String, Integer> entry : motifList.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            if (value > biggest) {
                biggest = value;      
                keyWithBiggest = key; 
            }
            
        }
        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return "el motif es: " + keyWithBiggest + " con una cantidad de: " + biggest + " encontrados en un tiempo de: " + time + " milisegundos";
    }
    
    
}

