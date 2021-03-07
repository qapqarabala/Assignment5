package kz.aitu.oop.practice.assignment4.Entities;

public class Stone {
    static String name;
    static String value;
    static int cost;
    static int weight;
    static int id = 0;

    public Stone(int id, String name, String value, int cost, int weight){//constructor to set the values to variables
        this.id = id;
        this.name = name;
        this.value = value;
        this.cost = cost;
        this.weight = weight;
    }


    //fullname

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void printAllStones() { System.out.println(getName()); }
    public static String getName() { return name; }
    public static String getValue() { return value; }
    public static int getCost() {return cost; }
    public static int getWeight() { return weight; }

    public String toString() {
        return "stone{" +
                "id=' "+id+'\n'+
                "name=' "+name+'\n'+
                ", value=' "+ value+'\n'+
                ", cost='" + cost + '\'' +
                ", weight='" + weight + '\'' + '}';
    }
}
