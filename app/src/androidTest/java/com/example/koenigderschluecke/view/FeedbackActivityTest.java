package com.example.koenigderschluecke.view;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.koenigderschluecke.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Diese Klasse testet die FeedbackActivity. Mail senden wird nicht getestet, da erstmal Irrelevant und ein Mail Programm vom Android Gerät extern geöffnet werden muss.
 */
@RunWith(AndroidJUnit4.class)
public class FeedbackActivityTest {

    @Rule
    public ActivityScenarioRule<FeedbackActivity> activityRule = new ActivityScenarioRule<>(FeedbackActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void returnsToMainMenuWhenBackButtonIsClicked() {
        Espresso.onView(ViewMatchers.withId(R.id.buttonZurueckZumHauptmenueFeedbackSeite)).perform(ViewActions.click());

        Intents.intended(IntentMatchers.hasComponent("com.example.koenigderschluecke.view.StartbildschirmActivity"));
    }
}
