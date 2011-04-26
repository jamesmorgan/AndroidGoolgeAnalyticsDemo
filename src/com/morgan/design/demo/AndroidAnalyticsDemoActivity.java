package com.morgan.design.demo;

import android.os.Bundle;
import android.view.View;

/**
 * @author James Edward Morgan
 */
public class AndroidAnalyticsDemoActivity extends AbstractAnalyticActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set you main view, i.e. your GUI xml file
		setContentView(R.layout.main);
	}

	/**
	 * Click handler for statics button
	 * 
	 * @param v the {@link View}
	 */
	public void onStatsClick(final View v) {
		getTracker().trackPageView("/DashboardStatsActivity");
	}

	/**
	 * Click handler for statics button
	 * 
	 * @param v the {@link View}
	 */
	public void onGroupsClick(final View v) {
		getTracker().trackPageView("/DashboardGroupsActivity");
	}

	/**
	 * Click handler for statics button
	 * 
	 * @param v the {@link View}
	 */
	public void onFriendsClick(final View v) {
		getTracker().trackPageView("/DashboardFriendsActivity");
	}

	/**
	 * Click handler for statics button
	 * 
	 * @param v the {@link View}
	 */
	public void onHomeClick(final View v) {
		getTracker().trackPageView("/DashboardHomeActivity");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Stop the tracker when it is no longer needed.
		getTracker().stop();
	}

}
