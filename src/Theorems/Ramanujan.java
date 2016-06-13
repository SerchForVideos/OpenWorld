
package Theorems;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Sergio Noriega Heredia
 */
public class Ramanujan {
    public static void main(String[] args) {
        BigInteger sol;
        BigInteger a=new BigInteger("2");
        BigInteger b=new BigInteger("1");
        int numSol=0,
            rank=5,
            cap=1;
        ArrayList<BigInteger> prevSols=new ArrayList<BigInteger>();
        ArrayList<BigInteger> prevAs=new ArrayList<BigInteger>();
        ArrayList<BigInteger> prevBs=new ArrayList<BigInteger>();
        while(numSol!=cap){
            sol=a.pow(rank).add(b.pow(rank));
            //System.out.println(""+sol.toString()+" = "+a.toString()+"^"+rank+" + "+b.toString()+"^"+rank);
            if(prevSols.contains(sol)){
                numSol++;
                int pos=prevSols.indexOf(sol);
                String temp=""+sol+" = "+prevAs.get(pos)+"^"+rank+" + "+prevBs.get(pos)+"^"+rank+" = "+a+"^"+rank+" + "+b+"^"+rank;
                System.out.println(temp);
                File save;
                FileOutputStream fileStream;
                ObjectOutputStream objectStream;
                try{
                    save=new File("collectedOutputs.txt");
                    fileStream=new FileOutputStream(save);
                    objectStream=new ObjectOutputStream(fileStream);
                    objectStream.writeChars(temp);
                    objectStream.close();
                    System.out.println("Saved");
                }catch(Exception ex){
                    System.out.println("Save fail.");
                    ex.printStackTrace();
                }
            }
            prevSols.add(sol);
            prevAs.add(a);
            prevBs.add(b);
            if(a.equals(b.add(new BigInteger("1")))){
                a=a.add(new BigInteger("1"));
                b=new BigInteger("1");
            }else{
                b=b.add(new BigInteger("1"));
            }
        }
    }
}
