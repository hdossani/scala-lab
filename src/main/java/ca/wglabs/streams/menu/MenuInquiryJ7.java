package ca.wglabs.streams.menu;


import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MenuInquiryJ7 implements MenuInquiry {


    /**
     *  Find the names of all the dishes with more than 400 calories.
     */
    public List<String> getHighCaloricDishesNames(){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: menu){
            if(d.getCalories() > 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    /**
     *  Return the name of all the dishes separated by comma.
     */
    public String getShortMenuCommaSeparated() {
        String shortMenu = "";
        for(Dish dish : menu){
            shortMenu +=  dish.getName() + ", ";
        }
        int lastCommaIndex = shortMenu.lastIndexOf(", ");

        return shortMenu.substring(0, lastCommaIndex);
    }

    /**
     *  Group the dishes by its type.
     */
    public  Map<Dish.Type, List<Dish>> groupDishesByType() {

        Map<Dish.Type, List<Dish>> dishesByType =  new HashMap();

        for (Dish dish: menu){
            if (!dishesByType.containsKey(dish.getType())){
                dishesByType.put(dish.getType(), new ArrayList());
            }
            dishesByType.get(dish.getType()).add(dish);
        }

        return dishesByType;
    }

    /**
     *  Group the dishes by their caloric level.
     */
    public Map<Dish.CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {

        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel=  new HashMap();

        List<Dish> dietDishes = new ArrayList();
        List<Dish> normalDishes = new ArrayList();
        List<Dish> fatDishes = new ArrayList();

        for (Dish dish: menu){
            if (dish.getCalories() <= 400) {
                dietDishes.add(dish);
            } else if (dish.getCalories() <= 700) {
                normalDishes.add(dish);
            } else fatDishes.add(dish);
        }

        if (!dietDishes.isEmpty()) {
            dishesByCaloricLevel.put(Dish.CaloricLevel.DIET, dietDishes);
        }
        if (!normalDishes.isEmpty()) {
            dishesByCaloricLevel.put(Dish.CaloricLevel.NORMAL, normalDishes);
        }
        if (!fatDishes.isEmpty()) {
            dishesByCaloricLevel.put(Dish.CaloricLevel.FAT, fatDishes);
        }

        return dishesByCaloricLevel;
    }


    /**
     *  Group the dishes by their types and within those groups, re-group them by caloric level.
     */
    public Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel = new HashMap();

        Map<Dish.Type, List<Dish>> dishesByType =  new HashMap();

        for (Dish dish: menu){
            if (!dishesByType.containsKey(dish.getType())){
                dishesByType.put(dish.getType(), new ArrayList());
            }
            dishesByType.get(dish.getType()).add(dish);
        }

        for(Dish.Type type : dishesByType.keySet()){
            List<Dish> dishes = dishesByType.get(type);

            Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel=  new HashMap();

            List<Dish> dietDishes = new ArrayList();
            List<Dish> normalDishes = new ArrayList();
            List<Dish> fatDishes = new ArrayList();

            for (Dish d: dishes){
                if (d.getCalories() <= 400) {
                    dietDishes.add(d);
                } else if (d.getCalories() <= 700) {
                    normalDishes.add(d);
                } else fatDishes.add(d);
            }

            if (!dietDishes.isEmpty()) {
                dishesByCaloricLevel.put(Dish.CaloricLevel.DIET, dietDishes);
            }
            if (!normalDishes.isEmpty()) {
                dishesByCaloricLevel.put(Dish.CaloricLevel.NORMAL, normalDishes);
            }
            if (!fatDishes.isEmpty()) {
                dishesByCaloricLevel.put(Dish.CaloricLevel.FAT, fatDishes);
            }

            dishesByTypeAndCaloricLevel.put(type, dishesByCaloricLevel);

        }
        return dishesByTypeAndCaloricLevel;
    }

    /**
     *  Return the number of dishes of each group.
     */
    public Map<Dish.Type, Long> countDishesInGroups() {

        Map<Dish.Type, Long> dishesPerGroup =  new HashMap();

        for (Dish dish: menu){
            if (!dishesPerGroup.containsKey(dish.getType())){
                dishesPerGroup.put(dish.getType(), new Long(1));
            } else {
                Long currentCount = dishesPerGroup.get(dish.getType());
                dishesPerGroup.put(dish.getType(), currentCount + 1);
            }
        }
        return dishesPerGroup;
    }

    /**
     *  Return the total amount of calories for each group.
     */
    public Map<Dish.Type, Long> sumCaloriesByType() {

        Map<Dish.Type, Long> caloriesByType =  new HashMap();

        for (Dish dish: menu){
            if (!caloriesByType.containsKey(dish.getType())){
                caloriesByType.put(dish.getType(), new Long(dish.getCalories()));
            } else {
                Long currentCount = caloriesByType.get(dish.getType());
                caloriesByType.put(dish.getType(), currentCount + dish.getCalories());
            }
        }
        return caloriesByType;
    }

    /**
     *   Returns the dish caloric levels grouped by their type.
     */
    public Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType() {

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelByType =  new HashMap();

        for (Dish dish: menu){
            Dish.CaloricLevel caloricLevel;
            if (dish.getCalories() <= 400) caloricLevel = Dish.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) caloricLevel = Dish.CaloricLevel.NORMAL;
            else caloricLevel = Dish.CaloricLevel.FAT;

            if (!caloricLevelByType.containsKey(dish.getType())){
                caloricLevelByType.put(dish.getType(), new HashSet());
            }
            Set<Dish.CaloricLevel> caloricLevels = caloricLevelByType.get(dish.getType());
            caloricLevels.add(caloricLevel);
            caloricLevelByType.put(dish.getType(), caloricLevels);

        }
        return caloricLevelByType;
    }

    /**
     *  Partition the list of dishes in two groups: vegetarian and non-vegetarian.
     */
    public Map<Boolean, List<Dish>> partitionByVegetarian() {

        Map<Boolean, List<Dish>> partition = new HashMap();

        List<Dish> vegetarianDishes = new ArrayList();
        List<Dish> nonVegetarianDishes = new ArrayList();

        for (Dish dish: menu){
            if (dish.isVegetarian()){
                vegetarianDishes.add(dish);
            } else {
                nonVegetarianDishes.add(dish);
            }
        }

        partition.put(TRUE, vegetarianDishes);
        partition.put(FALSE, nonVegetarianDishes);

        return partition;
    }

    /**
     *  Partition the list of dishes in two groups: vegetarian and non-vegetarian.
     *  Within those groups, re-group them by dish type.
     */
    public Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = new HashMap();

        Map<Boolean, List<Dish>> partitionByVegeterian = partitionByVegetarian();

        for(Boolean key : Arrays.asList(TRUE, FALSE)) {
            Map<Dish.Type, List<Dish>> dishesByType = new HashMap();
            for (Dish dish : partitionByVegeterian.get(key)) {
                if (!dishesByType.containsKey(dish.getType())) {
                    dishesByType.put(dish.getType(), new ArrayList());
                }
                dishesByType.get(dish.getType()).add(dish);
            }
            vegetarianDishesByType.put(key, dishesByType);
        }

        return vegetarianDishesByType;
    }

    /**
     *  Return the most caloric vegetarian and non-vegetarian dishes.
     */
    public Map<Boolean, Dish> mostCaloricPartitionedByVegetarian() {

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = new HashMap();

        Map<Boolean, List<Dish>> partitionByVegetarian = partitionByVegetarian();

        for(Boolean key : Arrays.asList(TRUE, FALSE)) {
            Dish mostCaloricDish = null;
            for (Dish dish : partitionByVegetarian.get(key)) {
                if (mostCaloricDish == null){
                    mostCaloricDish = dish;
                } else {
                    mostCaloricDish = (mostCaloricDish.getCalories() > dish.getCalories()) ? mostCaloricDish : dish;
                }
            }
            mostCaloricPartitionedByVegetarian.put(key, mostCaloricDish);
        }

        return mostCaloricPartitionedByVegetarian;


    }
}
