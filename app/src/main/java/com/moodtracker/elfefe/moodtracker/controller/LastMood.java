package com.moodtracker.elfefe.moodtracker.controller;

import com.moodtracker.elfefe.moodtracker.model.Mood;
import com.moodtracker.elfefe.moodtracker.dao.StateStore;

import java.util.Objects;

class LastMood {
    private Integer feeling;

    LastMood(StateStore stateStore) {
        if (stateStore.getQuery().findAll().size() > 0)
            feeling = Objects.requireNonNull(stateStore.getQuery().findAll().get(stateStore.getQuery().findAll().size()-1)).getFeeling();
    }
    Integer getMoodFeeling(){
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

    Integer getMoodColor() {
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
