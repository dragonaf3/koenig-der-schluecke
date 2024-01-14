package com.example.koenigderschluecke.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.koenigderschluecke.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class StatistikActivityTest {
    @Rule
    public ActivityScenarioRule<StatistikActivity> activityRule = new ActivityScenarioRule<>(StatistikActivity.class);

    @Before
    public void setUp() {
        //Setzt die Statistik auf "5"
        activityRule.getScenario().onActivity(StatistikActivity::setStatistik);

    }

    @Test
    public void testUIInteraktionStatistikLoeschen() {
        onView(ViewMatchers.withId(R.id.textViewStatistikAnzahlGesamtSpiele))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // Überprüfen, ob das TextView angezeigt wird
                .check(ViewAssertions.matches(ViewMatchers.withText("5"))); // Überprüfen, ob der Text im TextView dem erwarteten Text entspricht

        onView(withId(R.id.buttonStatistikLoeschen)).perform(click());

        onView(ViewMatchers.withId(R.id.textViewStatistikAnzahlGesamtSpiele))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // Überprüfen, ob das TextView angezeigt wird
                .check(ViewAssertions.matches(ViewMatchers.withText("0"))); // Überprüfen, ob der Text im TextView dem erwarteten Text entspricht
    }

    @Test
    public void testUIInteraktionZurueckButton() {
        Intents.init();
        onView(withId(R.id.buttonZurueckZumHauptmenueStatistikSeite)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(StartbildschirmActivity.class.getName()));
        Intents.release();
    }
}
