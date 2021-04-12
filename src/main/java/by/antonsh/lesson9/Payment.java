package by.antonsh.lesson9;


import java.util.*;

/**
 * This class create basket with items for payment
 */

public class Payment {
    /**
     * @param basket it's basket for payment
     * @param ids this check unique value for change id item
     * @param generatedId value for auto generation id item
     */
    private List<Items> basket = new ArrayList<>();
    private Set<Integer> ids = new TreeSet<>();
    private static int generateId;

    public void addToBusket(Items item) {
        basket.add(item);
    }

    public void deleteFromBucket(Items item) {
        ids.remove(item.getId());
        basket.remove(item);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "you basket=" + basket +
                '}';
    }

    /**
     * This  inner class create items for payment basket
     */

    class Items {
        /**
         * @param id unique value for item
         * @param name name of item
         * @param count number of units item
         */
        private int id;
        private String name;
        private int count;


        public Items(String name, int count) {
            this.id = generateId++;
            this.name = name;
            this.count = count;
            ids.add(this.getId());
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        /**
         * This method check input value
         * @param id item can be unique value
         */

        public void setId(int id) {
            if (ids.add(id)) {
                this.id = id;
            } else {
                System.out.println("Wrong id");
            }
        }

        @Override
        public String toString() {
            return "Items{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
