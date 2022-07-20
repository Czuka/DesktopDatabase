package project.adminP;

import java.io.*;

public class IdBananas {

    private int idThis;

    public int bananasFuction(String nazwa){

        try{
            int liczba=25;
            File f = new File(nazwa+".txt");
            if(f.exists() && !f.isDirectory()){
                BufferedReader reader = new BufferedReader(new FileReader(nazwa+".txt"));
                String line = reader.readLine();
                reader.close();
                liczba = Integer.parseInt(line);
                this.idThis = liczba;
                System.out.println(this.idThis);
            }



            BufferedWriter writer = new BufferedWriter(new FileWriter(nazwa+".txt"));
            this.idThis = liczba = liczba+1 ;
            System.out.println(this.idThis +"this.idThis");
            writer.write(liczba+"");
            System.out.println(liczba+"");
            writer.close();

        }catch (IOException ex) {
            System.err.println(ex+ " bananas");
        }finally {

            System.out.println(this.idThis);
            return this.idThis;
        }

    }



    public void IdBananas(){

    }




}

