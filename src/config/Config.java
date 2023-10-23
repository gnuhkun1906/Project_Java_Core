package config;

import dataURL.Path;
import model.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Config<E> {
    public Config() {
    }
    public List<E> readFromFile(String pathFile){
        List<E> list=new ArrayList<>();
          try {
              File file=new File(pathFile);
              if (file.exists()){
                  FileInputStream fis=new FileInputStream(file);
                  ObjectInputStream ois=new ObjectInputStream(fis);
                  list= (List<E>) ois.readObject();
                  fis.close();
                  ois.close();
              }
          }catch (EOFException e){

          } catch (Exception e){
              e.printStackTrace();
          }
          return list;
    }
    public void writeToFile(String pathFile,List<E>list){
        try {
            FileOutputStream fos=new FileOutputStream(pathFile);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
