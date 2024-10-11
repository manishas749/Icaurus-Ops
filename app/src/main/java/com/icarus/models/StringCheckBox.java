package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import org.parceler.Parcel;

/**
 * Created by Anurag Purwar on 5/11/18.
 */
@Parcel
public class StringCheckBox
{
    public int id;

    @ColumnInfo(name = "name")
    public String title;

    @Ignore
    public boolean isSelected;

    @ColumnInfo(name = "short_name")
    public String shortName;


    @Ignore
    public int position;



    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean selected)
    {
        isSelected = selected;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
