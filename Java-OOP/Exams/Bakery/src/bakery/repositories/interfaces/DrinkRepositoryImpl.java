package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.Collection;

public class DrinkRepositoryImpl extends RepositoryImpl implements DrinkRepository{

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Collection<Drink> drinks = super.getAll();

        Drink drink = null;

        for (Drink d : drinks) {
            if (d.getBrand().equals(drinkBrand) && d.getName().equals(drinkName)) {
                drink = d;
                break;
            }
        }
        return drink;
    }
}
