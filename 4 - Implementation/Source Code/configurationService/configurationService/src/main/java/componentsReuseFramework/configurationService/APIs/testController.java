// The controllers have to be in this package
package componentsReuseFramework.configurationService.APIs;

import Repositories.*;
import Models.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {

    // @Autowired
    private TestRepository testRepo;

    @RequestMapping("/")
    public String welcome_1() {
        return "Welcome From welcome_1 in testController";
    }

    @RequestMapping("/get")
    public testResultView getAll() {

        testResultView result = new testResultView();

        test tempTest = new test((long) 12, "SOSOS");

        List<test> res = new ArrayList<test>();
        String toReturnString = "";

        try {
            toReturnString += "testRepo.save(tempTest); start <br>";
            testRepo.save(tempTest);
            toReturnString += "testRepo.save(tempTest); TEST pass <br>";

            toReturnString += "testRepo.findAll(); start <br>";

            /* assing res to final final list Iterable => Lis */
            res = (List<test>) testRepo.findAll();

            toReturnString += "testRepo.findAll(); TEST passed <br>";

            /* returnnig result */

            if (res == null || res.size() == 0) { /* There is empty list returned from Repository */
                result = new testResultView("1", "can't find tests", null);
            } else { /* There is full list returned from repository */

                /* return the result and error_code,error_text as null */
                result = new testResultView(res);
            }

            toReturnString += "<br>******************************************<br>" + result.getError_text();
            result.setError_text(toReturnString);
            return result;

        } catch (Exception ex) {
            return new testResultView(
                    "404", 
                    toReturnString.toString(),
                    ex/*, testRepo.findOneByName("Sohaib")*/
                    );
        }
    }

    @RequestMapping("/get/{name}")
    public testResultView getByName(@PathVariable String name) {

        testResultView result = new testResultView();

        List<test> res = new ArrayList<test>();

        try {
            /* assing res to final final list Iterable => Lis */
            res = (List<test>) testRepo.findByName(name.trim());

            /* returnnig result */

            if (res == null || res.size() == 0) { /* There is empty list returned from Repository */

                /* result = new testResultView("1", "can't find tests", null); */

                result = new testResultView(res, "1", "if and there is't result", null, testRepo);

            } else { /* There is full list returned from repository */
                /* return the result and error_code,error_text as null */
                result = new testResultView(res, "1", "else and there is result", null, testRepo);
            }
            return result;

        } catch (Exception ex) {
            return new testResultView("404", "can't find tests", ex);
        }
    }

}

/**
 * This class aims to represent the APIs result
 */
class testResultView {
    private List<test> tests = new ArrayList<test>();
    private String error_code;

    private String error_text;

    private Exception exception;

    private Object object;

    // ***************************************

    /**
     * Default Constructor
     */
    public testResultView() {
    }

    // Whole
    /**
     * Default Constructor <param> tests : List<Test> </param>
     */
    public testResultView(List<test> tests, String error_code, String error_text, Exception exception, Object object) {
        this.tests = tests;
        this.error_code = error_code;
        this.error_text = error_text;
        this.exception = exception;
        this.object = object;
    }

    // No Result Only Exception
    public testResultView(String error_code, String error_text, Exception exception) {
        this.tests = null;
        this.error_code = error_code;
        this.error_text = error_text;
        this.exception = exception;
    }

    // Result No Exception
    public testResultView(List<test> tests) {
        this.tests = tests;
        this.error_code = null;
        this.error_text = null;
    }

    // ***************************************

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public List<test> getTests() {
        return tests;
    }

    public void setTests(List<test> tests) {
        this.tests = tests;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_text() {
        return error_text;
    }

    public void setError_text(String error_text) {
        this.error_text = error_text;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
