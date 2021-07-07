import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManager code_first = Persistence.createEntityManagerFactory("code_first")
                .createEntityManager();
    }
}
