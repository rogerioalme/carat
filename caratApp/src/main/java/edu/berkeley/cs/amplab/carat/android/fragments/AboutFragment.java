package edu.berkeley.cs.amplab.carat.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import edu.berkeley.cs.amplab.carat.android.CaratApplication;
import edu.berkeley.cs.amplab.carat.android.R;
import edu.berkeley.cs.amplab.carat.android.activities.DashboardActivity;
import edu.berkeley.cs.amplab.carat.android.model_classes.AboutItem;
import edu.berkeley.cs.amplab.carat.android.ui.LocalizedWebView;
import edu.berkeley.cs.amplab.carat.android.ui.adapters.AboutExpandListAdapter;
import edu.berkeley.cs.amplab.carat.android.ui.adapters.HogBugExpandListAdapter;

public class AboutFragment extends ExtendedTitleFragment {
    private DashboardActivity dashboardActivity;
    private LinearLayout mainFrame;
    private ExpandableListView expandableListView;
    private ArrayList<AboutItem> allAboutItems = new ArrayList<>();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.dashboardActivity = (DashboardActivity) activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mainFrame = (LinearLayout) inflater.inflate(R.layout.fragment_about, container, false);
        return mainFrame;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dashboardActivity.setUpActionBar(R.string.bugs, getFragmentManager().getBackStackEntryCount() > 0);
    }

    @Override
    public void onResume() {
        super.onResume();
        setAboutItems();
        initViewRefs();
    }

    private void initViewRefs() {
        CaratApplication app = (CaratApplication) getActivity().getApplication();
        expandableListView = (ExpandableListView) mainFrame.findViewById(R.id.expandable_about_list);
        expandableListView.setAdapter(new AboutExpandListAdapter
                (expandableListView, app, allAboutItems));
    }

    private void setAboutItems() {
        AboutItem item = new AboutItem();
        item.setAboutTitle(getString(R.string.about_general_title));
        item.setAboutMessage(getString(R.string.about_general_message));
        item.setChildMessage(getString(R.string.about_general_child_message));
        allAboutItems.add(item);

        item = new AboutItem();
        item.setAboutTitle(getString(R.string.about_actions_title));
        item.setAboutMessage(getString(R.string.about_actions_message));
        item.setChildMessage(getString(R.string.about_actions_child_message));
        allAboutItems.add(item);

        item = new AboutItem();
        item.setAboutTitle(getString(R.string.about_bugs_title));
        item.setAboutMessage(getString(R.string.about_bugs_message));
        item.setChildMessage(getString(R.string.about_bugs_child_message));
        allAboutItems.add(item);

        item = new AboutItem();
        item.setAboutTitle(getString(R.string.about_hogs_title));
        item.setAboutMessage(getString(R.string.about_hogs_message));
        item.setChildMessage(getString(R.string.about_hogs_child_message));
        allAboutItems.add(item);

        item = new AboutItem();
        item.setAboutTitle(getString(R.string.about_collect_title));
        item.setAboutMessage(getString(R.string.about_collect_message));
        item.setChildMessage(getString(R.string.about_collect_child_message));
        allAboutItems.add(item);

        item = new AboutItem();
        item.setAboutTitle(getString(R.string.about_battery_title));
        item.setAboutMessage(getString(R.string.about_battery_message));
        item.setChildMessage(getString(R.string.about_battery_child_message));
        allAboutItems.add(item);

    }

}
