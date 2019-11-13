package com.yaroshevich.trophies.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

public interface ActionBarModule{
    Toolbar get();
    void set(Toolbar toolbar);
}