package com.example.koenigderschluecke.view.regelsets;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.db.RuleDatabaseHelper;
import com.example.koenigderschluecke.model.RuleSet;

import java.util.ArrayList;
import java.util.List;

public class RuleSetListFragment extends Fragment {
    private RuleDatabaseHelper dbHelper;
    private ListView listViewRuleSets;
    private ArrayAdapter<String> ruleSetAdapter;
    private List<RuleSet> ruleSets;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rule_set_list, container, false);

        dbHelper = new RuleDatabaseHelper(getContext());
        listViewRuleSets = view.findViewById(R.id.listViewRuleSets);

        ruleSets = new ArrayList<>();
        ruleSetAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        listViewRuleSets.setAdapter(ruleSetAdapter);

        listViewRuleSets.setOnItemClickListener((parent, view1, position, id) -> {
            RuleSet selectedRuleSet = ruleSets.get(position);
            ((RuleSetActivity) getActivity()).showRuleSetCreatorFragment(selectedRuleSet.getId());
        });

        listViewRuleSets.setOnItemLongClickListener((parent, view12, position, id) -> {
            RuleSet selectedRuleSet = ruleSets.get(position);
            showEditDeleteDialog(selectedRuleSet);
            return true;
        });

        view.findViewById(R.id.buttonAddRuleSet).setOnClickListener(v -> {
            ((RuleSetActivity) getActivity()).showRuleSetCreatorFragment(-1);
        });

        loadRuleSets();
        return view;
    }

    private void loadRuleSets() {
        ruleSets.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("ruleset", new String[]{"id", "name"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            ruleSets.add(new RuleSet(id, name));
        }
        cursor.close();

        List<String> ruleSetNames = new ArrayList<>();
        for (RuleSet ruleSet : ruleSets) {
            ruleSetNames.add(ruleSet.getName());
        }
        ruleSetAdapter.clear();
        ruleSetAdapter.addAll(ruleSetNames);
        ruleSetAdapter.notifyDataSetChanged();
    }

    private void showEditDeleteDialog(RuleSet ruleSet) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(ruleSet.getName());
        builder.setItems(new CharSequence[]{"Edit", "Delete"}, (dialog, which) -> {
            if (which == 0) {
                ((RuleSetActivity) getActivity()).showRuleSetCreatorFragment(ruleSet.getId());
            } else if (which == 1) {
                deleteRuleSet(ruleSet);
            }
        });
        builder.show();
    }

    private void deleteRuleSet(RuleSet ruleSet) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("ruleset", "id = ?", new String[]{String.valueOf(ruleSet.getId())});
        db.delete("card_rule", "ruleset_id = ?", new String[]{String.valueOf(ruleSet.getId())});
        loadRuleSets();
    }
}
