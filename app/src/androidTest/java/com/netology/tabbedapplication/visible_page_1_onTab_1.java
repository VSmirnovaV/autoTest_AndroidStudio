package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class visible_page_1_onTab_1 {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void visible_page_1_onTab_1() {
        ViewInteraction textView = onView(
                allOf(withText("TAB 1"),
                        withParent(allOf(withContentDescription("Tab 1"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView.check(matches(withText("TAB 1")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.section_label), withText("Page: 1"),
                        withParent(allOf(withId(R.id.constraintLayout),
                                withParent(withId(R.id.view_pager)))),
                        isDisplayed()));
        textView2.check(matches(withText("Page: 1")));
    }
}
