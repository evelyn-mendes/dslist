package com.evelyn.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging () {}

    public Belonging (Game game, GameList list, Integer position) {
        this.id.setGame(game);
        this.id.setList(list);
        this.position = position;
    }

    public BelongingPK getId () {
        return id;
    }

    public void setId (BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition () {
        return position;
    }

    public void setPosition (Integer position) {
        this.position = position;
    }

    public int hashCode () {
        return Objects.hash(id);
    }

    public boolean equals (Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        return Objects.equals(id, other.id);
    }

}
