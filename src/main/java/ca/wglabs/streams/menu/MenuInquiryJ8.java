package ca.wglabs.streams.menu;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


public class MenuInquiryJ8 implements MenuInquiry {


    /**
     *  Find the names of all the dishes with more than 400 calories.
     */
    public List<String> getHighCaloricDishesNames() {
        return menu.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    /**
     *  Return the name of all the dishes separated by comma.
     */
    public String getShortMenuCommaSeparated() {
        return menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
    }

    /**
     *  Group the dishes by its type.
     */
    public Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType));
    }

    /**
     *  Group the dishes by their caloric level.
     */
    public Map<Dish.CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));
    }

    /**
     *  Group the dishes by their types and within those groups, re-group them by caloric level.
     */
    public Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                            else return Dish.CaloricLevel.FAT;
                        })
                )
        );
    }

    /**
     *  Return the number of dishes of each group.
     */
    public Map<Dish.Type, Long> countDishesInGroups() {
        return menu.stream().collect(groupingBy(Dish::getType, counting()));
    }

    /**
     *  Return the total amount of calories for each group.
     */
    public Map<Dish.Type, Long> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,
                summingLong(Dish::getCalories)));
    }

    /**
     *  Returns the dish caloric levels grouped by their type.
     */
    public Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                            else return Dish.CaloricLevel.FAT;
                        },
                        toSet())));
    }

    /**
     *  Partition the list of dishes in two groups: vegetarian and non-vegetarian.
     */
    public Map<Boolean, List<Dish>> partitionByVegetarian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    /**
     *  Partition the list of dishes in two groups: vegetarian and non-vegetarian.
     *  Within those groups, re-group them by dish type.
     */
    public Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }

    /**
     *  Return the most caloric vegetarian and non-vegetarian dishes.
     */
    public Map<Boolean, Dish> mostCaloricPartitionedByVegetarian() {
        return menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));
    }
}
