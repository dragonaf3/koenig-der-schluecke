package com.example.koenigderschluecke.view.regelsets;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;

public class RuleSetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_set);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RuleSetListFragment())
                    .commit();
        }
    }

    public void showRuleSetCreatorFragment(long ruleSetId) {
        RuleSetCreatorFragment fragment = RuleSetCreatorFragment.newInstance(ruleSetId);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
