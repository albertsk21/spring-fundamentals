package com.example.battleships.models.bm;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AttackShips {



    @NotEmpty
    private String attackerName;
    @NotEmpty
    private String defenderName;

    public AttackShips() {
    }

    public String getAttackerName() {
        return attackerName;
    }

    public void setAttackerName(String attackerName) {
        this.attackerName = attackerName;
    }

    public String getDefenderName() {
        return defenderName;
    }

    public void setDefenderName(String defenderName) {
        this.defenderName = defenderName;
    }
}
