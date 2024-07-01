package com.example.koenigderschluecke.view;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.is;

import static java.util.function.Predicate.not;

import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.view.lobby.LobbyActivity;
import com.example.koenigderschluecke.view.spiel.HauptspielActivity;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SingleplayerGameTest {

    @Rule
    public ActivityScenarioRule<StartbildschirmActivity> activityRule = new ActivityScenarioRule<>(StartbildschirmActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @Test
    public void singleplayerGameTest() {
        onView(withId(R.id.buttonNeuesSpiel)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(LobbyActivity.class.getName()));

        onView(withId(R.id.singleplayerButton)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(LobbyActivity.class.getName()));

        //Im Name Edit soll name Alex eingegeben werden
        onView(withId(R.id.nameEditText)).perform(click()).perform(typeText("Alex"));
        //Button playerAddButton soll gedrückt werden
        onView(withId(R.id.playerAddButton)).perform(click());
        //Überprüfen ob der Name im namesListView steht
        onData(is("Alex")).inAdapterView(withId(R.id.namesListView)).check(matches(isDisplayed()));

        //Überprüfen ob bei klicken auf startGameButton ein Toast ausgegeben wird
        onView(withId(R.id.startGameButton)).perform(click());
        //Nichts passiert

        //Im Name Edit soll name Eva eingegeben werden
        onView(withId(R.id.nameEditText)).perform(click()).perform(typeText("Eva"));
        //Button playerAddButton soll gedrückt werden
        onView(withId(R.id.playerAddButton)).perform(click());
        //Überprüfen ob der Name im namesListView steht
        onData(is("Eva")).inAdapterView(withId(R.id.namesListView)).check(matches(isDisplayed()));

        //Überprüfen ob bei klicken auf startGameButton die HauptspielActivity geöffnet wird
        onView(withId(R.id.startGameButton)).perform(click());
        Intents.intended(IntentMatchers.hasComponent(HauptspielActivity.class.getName()));

        //Überprüfen ob beim klicken auf buttonKarteZiehen das Fragment_regel geöffnet wird
        onView(withId(R.id.buttonKarteZiehen)).perform(click());
        onView(withId(R.id.regelZurKarte)).check(matches(isDisplayed()));

        //Überprüffen ob beim klicken auf buttonNaechsteRunde wieder das fragment kartenkreis geöffnet wird
        onView(withId(R.id.buttonNaechsteRunde)).perform(click());
        onView(withId(R.id.kartenStapelView)).check(matches(isDisplayed()));

        // Wiederholen bis sich das Fragment spielende öffnet
        boolean isGameEndFragmentDisplayed = false;
        while (!isGameEndFragmentDisplayed) {
            if (isViewDisplayed(withId(R.id.textViewSpielBeendetUeberschrift))) {
                isGameEndFragmentDisplayed = true;
            } else {
                onView(withId(R.id.buttonKarteZiehen)).perform(click());
                onView(withId(R.id.buttonNaechsteRunde)).perform(click());
            }
        }
    }

    private boolean isViewDisplayed(final Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            return false;
        }
    }
}
