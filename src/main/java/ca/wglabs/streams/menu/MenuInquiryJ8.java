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
        return new ArrayList<>();
    }

    /**
     *  Return the name of all the dishes separated by comma.
     */
    public String getShortMenuCommaSeparated() {
        return "";
    }

    /**
     *  Group the dishes by its type.
     */
    public Map<Dish.Type, List<Dish>> groupDishesByType() {
        return new HashMap<>();
    }

    /**
     *  Group the dishes by their caloric level.
     */
    public Map<Dish.CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return new HashMap<>();
    }

    /**
     *  Group the dishes by their types and within those groups, re-group them by caloric level.
     */
    public Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return new HashMap<>();
    }

    /**
     *  Return the number of dishes of each group.
     */
    public Map<Dish.Type, Long> countDishesInGroups() {
        return new HashMap<>();
    }

    /**
     *  Return the total amount of calories for each group.
     */
    public Map<Dish.Type, Long> sumCaloriesByType() {
        return new HashMap<>();
    }

    /**
     *  Returns the dish caloric levels grouped by their type.
     */
    public Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType() {
        return new HashMap<>();
    }

    /**
     *  Partition the list of dishes in two groups: vegetarian and non-vegetarian.
     */
    public Map<Boolean, List<Dish>> partitionByVegetarian() {
        return new HashMap<>();
    }

    /**
     *  Partition the list of dishes in two groups: vegetarian and non-vegetarian.
     *  Within those groups, re-group them by dish type.
     */
    public Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {
        return new HashMap<>();
    }

    /**
     *  Return the most caloric vegetarian and non-vegetarian dishes.
     */
    public Map<Boolean, Dish> mostCaloricPartitionedByVegetarian() {
        return new HashMap<>();
    }
}
