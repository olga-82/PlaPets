package utils;


import models.Gender;
import models.PetDTO;
import models.Type;
import models.UserDTO;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.String.valueOf;

public class DataProviderCVS {


    @DataProvider
    public Iterator<Object[]> DataForPets() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/animals.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");

                list.add(new Object[]{
                        PetDTO.builder()
                                .Sex(Gender.MALE)
                                .type(Type.BIRD)
                                .Breed(split[0])
                                .color(split[1])
                                .DistinctiveFeatures(split[2])
                                .description(split[3])
                                .location(split[4])
                                .contactsPhone(split[5])
                                .email(split[6])
                                .build()

                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> DataForUserLogin () {
        List<Object[]> list = new ArrayList<>();
        String path = "src/main/resources/User.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        UserDTO.builder()
                                .email(split[0].trim())
                                .password(split[1].trim())
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();

    }


}
