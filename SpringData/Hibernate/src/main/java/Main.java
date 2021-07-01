import javax.persistence.*;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory soft_uni = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = soft_uni.createEntityManager();

        Engine engine = new Engine(em);

        engine.run();

    }


}
