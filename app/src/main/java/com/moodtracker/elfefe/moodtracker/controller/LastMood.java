package com.moodtracker.elfefe.moodtracker.controller;

import com.moodtracker.elfefe.moodtracker.dao.StateStore;
import com.moodtracker.elfefe.moodtracker.model.Mood;

import java.util.Objects;

public class LastMood {
    private Integer feeling;

    LastMood(StateStore stateStore) {
        feeling = Objects.requireNonNull(stateStore.getQuery().findAll().get(stateStore.getQuery().findAll().size()-1)).getFeeling();
    }
    public Integer getMoodFeeling(){
        if (feeling ==  Mood.HAPPY.getColor())
            return Mood.HAPPY.getFeeling();
        else if (feeling ==  Mood.GOOD.getColor())
            return Mood.GOOD.getFeeling();
        else if (feeling ==  Mood.AVERAGE.getColor())
            return Mood.AVERAGE.getFeeling();
        else if (feeling ==  Mood.SAD.getColor())
            return Mood.SAD.getFeeling();
        else if (feeling ==  Mood.ANGRY.getColor())
            return Mood.ANGRY.getFeeling();
        else
            return null;
    }

    public Integer getMoodColor() {
        if (feeling ==  Mood.HAPPY.getColor())
            return Mood.HAPPY.getColor();
        else if (feeling ==  Mood.GOOD.getColor())
            return Mood.GOOD.getColor();
        else if (feeling ==  Mood.AVERAGE.getColor())
            return Mood.AVERAGE.getColor();
        else if (feeling ==  Mood.SAD.getColor())
            return Mood.SAD.getColor();
        else if (feeling ==  Mood.ANGRY.getColor())
            return Mood.ANGRY.getColor();
        else
            return null;
    }
}
