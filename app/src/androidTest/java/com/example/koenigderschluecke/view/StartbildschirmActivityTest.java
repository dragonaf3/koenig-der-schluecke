package com.example.koenigderschluecke.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.view.lobby.LobbyActivity;
import com.example.koenigderschluecke.view.lobby.SpielBeitretenFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class StartbildschirmActivityTest {

    @Rule
    public ActivityScenarioRule<StartbildschirmActivity> activityRule = new ActivityScenarioRule<>(StartbildschirmActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void clickingNeuesSpielButtonOpensLobbyActivity() {
        onView(withId(R.id.buttonNeuesSpiel)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(LobbyActivity.class.getName()));
    }

    @Test
    public void clickingSpielBeitretenButtonOpensSpielBeitretenActivity() {
        onView(withId(R.id.buttonSpielBeitreten)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(SpielBeitretenFragment.class.getName()));
    }

    @Test
    public void clickingStatistikButtonOpensStatistikActivity() {
        onView(withId(R.id.buttonStatistik)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(StatistikActivity.class.getName()));
    }

    @Test
    public void clickingEinstellungenButtonOpensEinstellungenActivity() {
        onView(withId(R.id.buttonEinstellungen)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(EinstellungenActivity.class.getName()));
    }

    @Test
    public void clickingBeendenButtonFinishesActivity() {
        // Starten der Activity
        ActivityScenario<StartbildschirmActivity> scenario = activityRule.getScenario();

        // Ausführen des Klicks auf den Button
        onView(withId(R.id.buttonBeenden)).perform(click());

        // Warten auf das Beenden der Activity
        scenario.onActivity(activity -> {
            // Prüfen, ob die Activity beendet ist
            assertTrue(activity.isFinishing());
        });
    }
}