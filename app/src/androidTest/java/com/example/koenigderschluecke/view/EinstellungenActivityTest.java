package com.example.koenigderschluecke.view;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.koenigderschluecke.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Diese Klasse testet die EinstellungenActivity.
 */
@RunWith(AndroidJUnit4.class)
public class EinstellungenActivityTest {

    @Rule
    public ActivityScenarioRule<EinstellungenActivity> activityRule =
            new ActivityScenarioRule<>(EinstellungenActivity.class);

    @Test
    public void zurueckZumHauptmenueButtonStartetStartbildschirmActivity() {
        Intents.init();
        Espresso.onView(withId(R.id.buttonZurueckZumHauptmenueSpielendeFragmentSeite)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(StartbildschirmActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void zumFeedbackButtonStartetFeedbackActivity() {
        Intents.init();
        Espresso.onView(withId(R.id.imageButtonFeedback)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(FeedbackActivity.class.getName()));
        Intents.release();
    }
}