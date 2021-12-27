package service;


import model.Route;

public class RouteCreator {
    private static final String TEST_DATA_POINT_TO = "testdata.route.pointTo";
    private static final String TEST_DATA_IN_DATE = "testdata.route.checkInDate";
    private static final String TEST_DATA_OUT_DATE = "testdata.route.checkOutDate";
    private static final String TEST_DATA_INCORRECT_POINT = "testdata.route.pointToIncorrect";
    private static final String TEST_DATA_INCORRECT_DATE = "testdata.route.DateIncorrect";


    public static Route createForm(){
        return new Route(TestDataReader.getTestData(TEST_DATA_POINT_TO),"","");
    }

    public static Route createIncorrectPointForm(){
        return new Route(TestDataReader.getTestData(TEST_DATA_INCORRECT_POINT),"","");
    }

    public static Route createIncorrectDateForm(){
        return new Route(TestDataReader.getTestData(TEST_DATA_POINT_TO),
                TestDataReader.getTestData(TEST_DATA_INCORRECT_DATE),
                TestDataReader.getTestData(TEST_DATA_INCORRECT_DATE));
    }

    public static Route createFormWithDate(){
        return new Route(TestDataReader.getTestData(TEST_DATA_POINT_TO),
                TestDataReader.getTestData(TEST_DATA_IN_DATE),
                TestDataReader.getTestData(TEST_DATA_OUT_DATE));
    }



}
