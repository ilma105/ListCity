package com.example.simpleparadox.listycity;
        import android.app.Activity;
        import androidx.test.ext.junit.runners.AndroidJUnit4;
        import androidx.test.platform.app.InstrumentationRegistry;
        import androidx.test.rule.ActivityTestRule;

        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.robotium.solo.Solo;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import static junit.framework.TestCase.assertTrue;
        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertFalse;
/**
 * Test class for MainActivity. All the UI tests are written here. Robotium test framework is
 used
 */
@RunWith(AndroidJUnit4.class)
public class ShowActivityTest{
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }






    @Test
    public void switchActivity(){
        ListView listView =  (ListView) solo.getView(R.id.city_list);
        View view = listView.getChildAt(0);
        solo.clickOnView(view);
        solo.assertCurrentActivity("Activity didn't switch",ShowActivity.class);
        //solo.assertCurrentActivity("Activity didn't switch",ShowActivity.class);
        //solo.sleep(1000);
    }
    @Test
    public void checkName(){
        ListView listView =  (ListView) solo.getView(R.id.city_list);
        View view = listView.getChildAt(0);
        solo.clickOnView(view);
        TextView text = (TextView) solo.getView(R.id.textView);
       // TextView text1 = (TextView) solo.getView(R.id.textView2);
      //  String roll = text1.getText().toString();
        String name = text.getText().toString();
        //solo.assertCurrentActivity("Activity didn't switch",ShowActivity.class);
        //solo.assertCurrentActivity("Activity didn't switch",ShowActivity.class);
        //assertEquals("Roll:1707012", roll);
        assertEquals("Edmonton", name);
        //solo.sleep(1000);

    }
    @Test
    public void checkBackButton(){
        ListView listView =  (ListView) solo.getView(R.id.city_list);
        View view = listView.getChildAt(0);
        solo.clickOnView(view);
        solo.waitForActivity(ShowActivity.class);
        Button btn =(Button) solo.getView(R.id.button);
        solo.clickOnView(btn);

        solo.assertCurrentActivity("Activity didn't switch",MainActivity.class);
       // solo.getCurrentActivity(MainActivity.class,1);
        //solo.sleep(1000);


    }

    /**
     * Close activity after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        solo.waitForActivity("ShowActivityTest",1000);
        solo.finishOpenedActivities();
    }
}