package logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taxiStation.AbstractCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 */

public class TaxiStationLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiStationLogic.class);

    private List<AbstractCar> cars;

    public TaxiStationLogic(List<AbstractCar> cars) {
        this.cars = cars;
    }

    public List<AbstractCar> getCars() {
        return cars;
    }

    public void setCars(List<AbstractCar> cars) {
        this.cars = cars;
    }

    /**
     * Method show car list
     *
     * @param carList
     */
    public static void showTaxiStation(List<AbstractCar> carList) {
        LOGGER.info("Trying to get car list");

        for (AbstractCar car : carList) {
            System.out.println(car);
        }
        LOGGER.info("Car list is  getting");
    }

    /**
     * Method show  total sum of  all  cars  in taxi station
     */
    public void getAllCarsCost() {
        LOGGER.info(" Trying to get car list");
        double totalSum = 0;

        for (AbstractCar car : cars) {
            totalSum += car.getPrice();
        }
        System.out.println("Сost of all cars: " + totalSum);
        LOGGER.info("Сost of all cars: {}", totalSum);
    }

    /**
     * Method  sorted  cars  by  fuel  consumption
     *
     * @param carList
     */
    public void sortCarsByFuelConsumption(List<AbstractCar> carList) {
        LOGGER.info("Trying to get sorted, by fuel consumption, car list");

        Collections.sort(carList, new Comparator<AbstractCar>() {
            public int compare(AbstractCar o1, AbstractCar o2) {
                if (o1.getFuelConsumption() > o2.getFuelConsumption()) {
                    return 1;
                } else if (o1.getFuelConsumption() < o2.getFuelConsumption()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        LOGGER.info("Got sorted, by fuel consumption, car list");

    }

    /**
     * Checking method,  which  are checking  is  min and max  values  execute
     *
     * @param minSp
     * @param maxSp
     * @return
     */
    public boolean isMaxMoreThanMin(int minSp, int maxSp) {
        LOGGER.info("Trying to check, min/max values on  the right conditions");

        if (maxSp <= minSp || (maxSp <= 0 || minSp < 0) || maxSp == minSp) {
            LOGGER.warn("min/max have incorrect values");
            return false;
        }
        LOGGER.info("min/max have correct values");
        return true;
    }

    /**
     * Checking method,  which  are checking  is  car list is empty
     *
     * @param carList
     * @return
     */
    public boolean isListIsEmpty(List<AbstractCar> carList) {
        LOGGER.info("Trying to check, is car list  is empty");

        if (carList.size() == 0) {
            LOGGER.info("car list is empty");
            return true;
        }
        LOGGER.warn("car list is not empty");
        return false;
    }

    /**
     * Method  get  cars with  speed  which  located  in specified  speed range
     *
     * @param carList
     * @param minSpeedRange
     * @param maxSpeedRange
     */
    public void getCarListBySpeedRange(List<AbstractCar> carList, int minSpeedRange, int maxSpeedRange) {
        LOGGER.info("Trying to get car list  by  speed  range");

        List<AbstractCar> newCarList = new ArrayList<AbstractCar>();

        if (!isMaxMoreThanMin(minSpeedRange, maxSpeedRange)) {
            System.out.println("Incorrect values");
            return;

        } else {
            for (AbstractCar car : carList) {
                if (car.getSpeed() >= minSpeedRange && car.getSpeed() <= maxSpeedRange) {
                    newCarList.add(car);
                } else {
                    break;
                }
            }
        }
        if (isListIsEmpty(newCarList)) {
            System.out.println("Cars with this speed  range  isn't found !");
            return;
        }

        LOGGER.info("Got car list  with  special   range of speed");
        showTaxiStation(newCarList);

    }

    @Override
    public String toString() {
        return "TaxiStationLogic{" +
                "car=" + cars +
                '}';
    }

}
