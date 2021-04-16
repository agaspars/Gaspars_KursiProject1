package Model;

public class Category {
    private String category;

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void printCategory(){
        System.out.println("-------------------------");
        System.out.println("Category: " + category);
        System.out.println("-------------------------");
    }
}
