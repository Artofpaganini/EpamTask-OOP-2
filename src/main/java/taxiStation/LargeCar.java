package taxiStation;

/**
 * Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 */

public class LargeCar extends AbstractCar {
    public LargeCar(String model, int year, double weight, double price, double fuelConsumption, int speed) {
        super(model, year, weight, price, fuelConsumption, speed);
    }
}
