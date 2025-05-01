package deep.model;

public enum UserType {
    VETERAN(0.10),
    SOLDIER(0.05),
    STUDENT(0.03),
    NORMAL(0.00);

    private final double discountRate;

    UserType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static UserType fromSelection(int input) {
        return switch (input) {
            case 1 -> VETERAN;
            case 2 -> SOLDIER;
            case 3 -> STUDENT;
            case 4 -> NORMAL;
            default -> throw new IllegalArgumentException("잘못된 입력입니다.");
        };
    }
}
