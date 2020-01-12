package mbasak;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import mbasak.*;

public class TestRunner {
	public static void main(String [] args) {

        System.out.println("===============Chamber Test===============");
		Result result = JUnitCore.runClasses(ChamberTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedList = result.getFailures();
        failedList.forEach(f -> {
            System.out.println(f);
        });

        System.out.println("Number of Failed Tests = " + result.getFailureCount());

        System.out.println("===============Passage Test===============");
        Result resultP = JUnitCore.runClasses(PassageTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedListP = resultP.getFailures();
        failedListP.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + resultP.getFailureCount());

        System.out.println("===============Door Test===============");
        Result resultD = JUnitCore.runClasses(DoorTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedListD = resultD.getFailures();
        failedListD.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + resultD.getFailureCount());

        System.out.println("===============Passage Section Test===============");
        Result resultPS = JUnitCore.runClasses(PassageSectionTest.class);
        System.out.println("\n*****Failed Test Report****\n");
        List<Failure> failedListPS = resultPS.getFailures();
        failedListPS.forEach(f -> {
            System.out.println(f);
        });
        System.out.println("Number of Failed Tests = " + resultPS.getFailureCount());

        /*repeat steps the above for each junit test file you have*/
	}
}