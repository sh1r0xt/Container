public class Container {
    private int amount;

    public Container() {
        this.amount = 0;
    }

    public int contains() {
        return amount;
    }

    public void addAmount(int amount) {
        int total = this.amount + amount;

        if (amount >= 0 && total <= 100) {
            this.amount = total;
        }
        if (total>100) {
            this.amount = 100;
        }
        else{
            System.out.println("Cannot add amount, exceeds container capacity");
        }
    }


    public void removeAmount(int amount) {
        if (amount > 0 && this.amount - amount >= 0) {
            this.amount -= amount;
        } else if (this.amount - amount < 0) {
            System.out.println("Cannot remove amount, exceeds container contents");
        }
    }


    public void move(int amount, Container container) {
        if (this.amount > 0 && amount > 0) {
            this.amount -= amount;
            container.addAmount(amount);
        }
    }

    public String toString() {
        return this.amount + "/100";

    }
}
