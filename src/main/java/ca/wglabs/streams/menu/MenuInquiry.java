package ca.wglabs.streams.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MenuInquiry {

    List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));


    List<String> getLowCaloricDishesNames();

    String getShortMenuCommaSeparated();

    Map<Dish.Type, List<Dish>> groupDishesByType();

    Map<Dish.CaloricLevel, List<Dish>> groupDishesByCaloricLevel();

    Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel();

    Map<Dish.Type, Long> countDishesInGroups();

    Map<Dish.Type, Long> sumCaloriesByType();

    Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType();

    Map<Boolean, List<Dish>> partitionByVegeterian();

    Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType();

    Map mostCaloricPartitionedByVegetarian();
}
