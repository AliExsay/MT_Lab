package com.example.memory_game;

import android.hardware.lights.LightsManager;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import androidx.appcompat.view.menu.ListMenuPresenter;

import java.util.List;

public class Settings extends PreferenceActivity implements Preference.OnPreferenceChangeListener
{
    ListPreference collection;
    ListPreference color;
    ListPreference size;

    // два массива для хранения значений списков
    CharSequence[] pictValue, colValue, sizeValue;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        collection = (ListPreference)this.findPreference("PictureCollection");
        color = (ListPreference)this.findPreference("BackgroundColor");
        size = (ListPreference)this.findPreference("key_board_size");

        // устанавливаем слушатель
        collection.setOnPreferenceChangeListener(this);
        color.setOnPreferenceChangeListener(this);
        size.setOnPreferenceChangeListener(this);

        // пишем в summary текущее значение
        collection.setSummary(collection.getEntry());
        color.setSummary(color.getEntry());
        size.setSummary(size.getEntry());

        // получаем списки значений для каждой настройки
        pictValue = collection.getEntries();
        colValue = color.getEntries();
        sizeValue = color.getEntries();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue)
    {
        // название настройки, которая была изменена
        String Key = preference.getKey();

        // если это коллекция картинок
        if (Key.equals("PictureCollection"))
        {
            // определяем индекс нового значения
            int i = ((ListPreference)preference).findIndexOfValue(newValue.toString());
            // ищем русское название для значения с этим индексом и записываем в summary
            preference.setSummary(pictValue[i]);
            return true;
        }

        // если это цвет
        if (Key.equals("BackgroundColor"))
        {
            int i = ((ListPreference)preference).findIndexOfValue(newValue.toString());
            preference.setSummary(colValue[i]);
            return true;
        }
        //если это размер поля
        if (Key.equals("BoardSize"))
        {
            int i = ((ListPreference)preference).findIndexOfValue(newValue.toString());
            preference.setSummary(sizeValue[i]);
            return true;
        }

        // для всех остальных настроек ставим пришедшее значение в summary
        preference.setSummary((CharSequence)newValue);
        return true;
    }
}