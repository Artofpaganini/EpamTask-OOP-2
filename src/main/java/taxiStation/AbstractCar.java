package taxiStation;

/**
 * Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 */
public abstract class AbstractCar {

    private String model;
    private int year;
    private double weight;
    private double price;
    private double fuelConsumption;
    private int speed;

    public AbstractCar(String model, int year, double weight, double price, double fuelConsumption,
                       int speed) {
        this.model = model;
        this.year = year;
        this.weight = weight;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getWeight() {
        return weight;
    }



    public double getPrice() {
        if (isPricePositive()) {
            return price;
        }
        return 0.0;
    }

    public double getFuelConsumption() {
        if (isFuelConsumptionPositive()) {
            return fuelConsumption;
        }
        return 0.0;
    }

    public int getSpeed() {
        if (isSpeedPositive()) {
            return speed;
        }
        return 0;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCar that = (AbstractCar) o;

        if (year != that.year) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.fuelConsumption, fuelConsumption) != 0) return false;
        if (speed != that.speed) return false;
        return model != null ? model.equals(that.model) : that.model == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + year;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return "Сar{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", price=" + price +
                ", fuelConsumption=" + fuelConsumption +
                ", speed=" + speed +
                '}';
    }

    public boolean isPricePositive() {
        if (this.price <= 0) {
            return false;
        }
        return true;
    }

    public boolean isFuelConsumptionPositive() {
        if (this.fuelConsumption <= 0) {
            return false;
        }
        return true;
    }

    public boolean isSpeedPositive() {
        if (this.speed < 0) {
            return false;
        }
        return true;
    }


}


