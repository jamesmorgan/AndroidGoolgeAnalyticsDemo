package com.morgan.design.demo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

/**
 * Abstract class used to encapsulate Google analytics and its user preference
 * 
 * @author James Edward Morgan
 */
public class AbstractAnalyticActivity extends Activity {

	private GoogleAnalyticsTracker tracker;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get and set the Google Analytic tracker instance
		setTracker(GoogleAnalyticsTracker.getInstance());

		// Get application shared preferences
		final SharedPreferences preferences = getSharedPreferences("SomeSharedPreferenceKey", Activity.MODE_PRIVATE);

		// Get your preference key for enabling google analytics
		final boolean enabledGoogleAnaltyics = preferences.getBoolean("PREF_GOOGLE_ANALYTIC", true);

		if (enabledGoogleAnaltyics) {

			// Arg1: Your tracking ID
			// Arg2: How often your tracking events get dispatched to google, set to 20 seconds
			// Arg3: The activity to track
			tracker.start("UA-XXXXXXXX-X", 20, this);
		}
		else {
			// Stop the tracker if not enabled
			tracker.stop();
		}
	}

	/**
	 * Set the {@link GoogleAnalyticsTracker}
	 */
	private void setTracker(final GoogleAnalyticsTracker tracker) {
		this.tracker = tracker;
	}

	/**
	 * Make the tracker available the sub class
	 * 
	 * @return the {@link GoogleAnalyticsTracker}
	 */
	public GoogleAnalyticsTracker getTracker() {
		return this.tracker;
	}

}
