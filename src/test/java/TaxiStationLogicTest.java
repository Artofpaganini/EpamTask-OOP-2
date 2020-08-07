import logic.TaxiStationLogic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taxiStation.*;

import java.util.ArrayList;
import java.util.List;

public class TaxiStationLogicTest {

    private TaxiStationLogic taxiStationLogic;
    private List<AbstractCar> carList;

    @Before
    public void createNewTaxiStation() {

        AbstractCar miniCar = new MiniCar("Audi", 2015, 1100.7, 1500, 4.3, 120);
        AbstractCar smallCar = new SmallCar("Mersedes", 2019, 1620.8, 950, 9.7, 180);
        AbstractCar largerCar = new LargeCar("Hyundai", 2018, 1800.9, 880, 7.4, 160);
        AbstractCar multiPurposeCar = new MultiPurposeCar("Iveco", 2019, 2954.6, 1200, 8.4, 140);

        carList = new ArrayList<AbstractCar>();

        carList.add(miniCar);
        carList.add(smallCar);
        carList.add(largerCar);
        carList.add(multiPurposeCar);

        taxiStationLogic = new TaxiStationLogic(carList);
    }

    @After
    public void cleanNewTaxiStationLogic() {
        taxiStationLogic = null;
    }

    @Test
    public void test_shouldSortCarListByFuelConsumption() {

        taxiStationLogic.sortCarsByFuelConsumption(carList);
        Assert.assertNotNull(carList.size());

        for (AbstractCar car : carList) {
            System.out.println(car);
        }

        cleanNewTaxiStationLogic();
    }

    @Test
    public void isMax_ShouldBeMoreThanMinAndMinMax_ShouldNotBePositive() {

        int min = 10;
        int max = 15;

        Assert.assertTrue(taxiStationLogic.isMaxMoreThanMin(min, max));
    }

    @Test
    public void carList_ShouldBeEmpty() {

        List<AbstractCar> emptyCarList = new ArrayList<AbstractCar>();
        Assert.assertTrue(taxiStationLogic.isListIsEmpty(emptyCarList));
    }
}
