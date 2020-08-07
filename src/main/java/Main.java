import logic.TaxiStationLogic;
import taxiStation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 */

public class Main {
    public static void main(String[] args) {

        AbstractCar miniCar = new MiniCar("Audi", 2015, 1100.7, 1500, 4.3, 120);
        AbstractCar smallCar = new SmallCar("Mersedes", 2019, 1620.8, 950, 9.7, 180);
        AbstractCar largerCar = new LargeCar("Hyundai", 2018, 1800.9, 880, 7.4, 160);
        AbstractCar multiPurposeCar = new MultiPurposeCar("Iveco", 2019, 2954.6, 1200, 8.4, 140);

        List<AbstractCar> carList = new ArrayList<AbstractCar>();

        carList.add(miniCar);
        carList.add(smallCar);
        carList.add(largerCar);
        carList.add(multiPurposeCar);

        System.out.println("Taxi station:");
        TaxiStationLogic taxiStationLogic = new TaxiStationLogic(carList);
        taxiStationLogic.showTaxiStation(taxiStationLogic.getCars());

        System.out.println();
        taxiStationLogic.getAllCarsCost();
        System.out.println();

        System.out.println("Sorted Cars");
        taxiStationLogic.sortCarsByFuelConsumption(taxiStationLogic.getCars());

        taxiStationLogic.showTaxiStation(taxiStationLogic.getCars());

        System.out.println();

        taxiStationLogic.getCarListBySpeedRange(taxiStationLogic.getCars(), 120, 160);

    }
}

