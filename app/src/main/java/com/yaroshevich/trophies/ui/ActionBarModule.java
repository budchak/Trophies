package com.yaroshevich.trophies.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

public interface ActionBarModule{
    ActionBar get();
    void set(Toolbar toolbar);
}