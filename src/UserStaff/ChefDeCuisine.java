package UserStaff;


import java.math.BigDecimal;

public class ChefDeCuisine extends Operational {

    private String specialtyCuisine;
    private int menuItemsCreated;
    private int kitchenStaffCount;
    private String kitchenSuppliesInventory;
    private String healthAndSafetyCertifications;
    private String weeklyMenuPlan;
    private BigDecimal foodWastePercentage;
    private BigDecimal preparationTime;

    public ChefDeCuisine() {
    }

    public ChefDeCuisine(int id, String firstName, String lastName, String email, String phoneNumber,
                         String address, java.util.Date hireDate, BigDecimal salary, String status, String department,
                         String jobTitle, String workingHours, String shiftType, String location, String responsibilityLevel,
                         int taskCount, BigDecimal performanceRating, String specialtyCuisine, int menuItemsCreated,
                         int kitchenStaffCount, String kitchenSuppliesInventory, String healthAndSafetyCertifications,
                         String weeklyMenuPlan, BigDecimal foodWastePercentage, BigDecimal preparationTime) {
        super(id, firstName, lastName, email, phoneNumber, address, hireDate, salary, status, department, jobTitle,
                workingHours, shiftType, location, responsibilityLevel, taskCount, performanceRating);
        this.specialtyCuisine = specialtyCuisine;
        this.menuItemsCreated = menuItemsCreated;
        this.kitchenStaffCount = kitchenStaffCount;
        this.kitchenSuppliesInventory = kitchenSuppliesInventory;
        this.healthAndSafetyCertifications = healthAndSafetyCertifications;
        this.weeklyMenuPlan = weeklyMenuPlan;
        this.foodWastePercentage = foodWastePercentage;
        this.preparationTime = preparationTime;
    }

    public String getSpecialtyCuisine() {
        return specialtyCuisine;
    }

    public void setSpecialtyCuisine(String specialtyCuisine) {
        this.specialtyCuisine = specialtyCuisine;
    }

    public int getMenuItemsCreated() {
        return menuItemsCreated;
    }

    public void setMenuItemsCreated(int menuItemsCreated) {
        this.menuItemsCreated = menuItemsCreated;
    }

    public int getKitchenStaffCount() {
        return kitchenStaffCount;
    }

    public void setKitchenStaffCount(int kitchenStaffCount) {
        this.kitchenStaffCount = kitchenStaffCount;
    }

    public String getKitchenSuppliesInventory() {
        return kitchenSuppliesInventory;
    }

    public void setKitchenSuppliesInventory(String kitchenSuppliesInventory) {
        this.kitchenSuppliesInventory = kitchenSuppliesInventory;
    }

    public String getHealthAndSafetyCertifications() {
        return healthAndSafetyCertifications;
    }

    public void setHealthAndSafetyCertifications(String healthAndSafetyCertifications) {
        this.healthAndSafetyCertifications = healthAndSafetyCertifications;
    }

    public String getWeeklyMenuPlan() {
        return weeklyMenuPlan;
    }

    public void setWeeklyMenuPlan(String weeklyMenuPlan) {
        this.weeklyMenuPlan = weeklyMenuPlan;
    }

    public BigDecimal getFoodWastePercentage() {
        return foodWastePercentage;
    }

    public void setFoodWastePercentage(BigDecimal foodWastePercentage) {
        this.foodWastePercentage = foodWastePercentage;
    }

    public BigDecimal getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(BigDecimal preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ChefDeCuisine {" +
                "specialtyCuisine='" + specialtyCuisine + '\'' +
                ", menuItemsCreated=" + menuItemsCreated +
                ", kitchenStaffCount=" + kitchenStaffCount +
                ", kitchenSuppliesInventory='" + kitchenSuppliesInventory + '\'' +
                ", healthAndSafetyCertifications='" + healthAndSafetyCertifications + '\'' +
                ", weeklyMenuPlan='" + weeklyMenuPlan + '\'' +
                ", foodWastePercentage=" + foodWastePercentage +
                ", preparationTime=" + preparationTime +
                '}';
    }
}

