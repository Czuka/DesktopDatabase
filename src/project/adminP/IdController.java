package project.adminP;

import java.io.*;

public class IdController {
/*    private int idInt;


    public int setIdInt() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("IdContainer.txt"));
            if (Integer.valueOf(reader.readLine()) != null) {
                this.idInt = Integer.valueOf(reader.readLine());
            }else {
                //dodać ściągnięcie id z bazy
            }
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("setIdInt ="+ this.idInt +" .");
            return this.idInt;

        }
    }

    public int getIdInt() {
        return idInt;
    }

    public void saveID(){
        int tempID = this.idInt;
        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter("IdContainer.txt")); // nadpisuje stary plik
            writer.write(String.valueOf(tempID));
            writer.close();

        }catch(IOException ex) {
            ex.printStackTrace();
        }finally {

            System.out.println("saveID ="+ this.idInt +" .");
        }
    }

    public int IdController() {
        setIdInt();
        getIdInt();

        return this.idInt;
    }*/
}

