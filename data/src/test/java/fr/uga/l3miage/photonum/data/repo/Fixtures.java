package fr.uga.l3miage.photonum.data.repo;

import com.github.javafaker.Faker;
import fr.uga.l3miage.photonum.data.domain.Tirage;

import java.util.Random;

public class Fixtures {

    private static final Faker FAKER = Faker.instance(new Random(42));

    public static Tirage newTirage() {
        Tirage impression = new Tirage();
        // ...
        return impression;
    }

}
