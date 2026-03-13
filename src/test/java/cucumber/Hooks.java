package cucumber;

import io.cucumber.java.After;
import org.testng.annotations.BeforeClass;
import stepDefinitions.StepDefinitionImpl;

public class Hooks {

    StepDefinitionImpl stepDefinitionImpl;
    public Hooks(StepDefinitionImpl stepDefinitionImpl) {
        this.stepDefinitionImpl = stepDefinitionImpl;
    }

    @After
    public void tearDown(){
        stepDefinitionImpl.driver.quit();
    }

}
