package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void equivalent_teams_returns_true() {
        Team team1 = new Team("test");
        Team team2 = new Team("test");
        team1.addMember("test");
        team2.addMember("test");
        assertEquals(team1, team2);
        assertEquals(team1, team1);
    }

    @Test
    public void different_teams_return_false(){
        Team team1 = new Team("test");
        Team team2 = new Team("test");
        team1.addMember("test1");
        team2.addMember("test2");
        assertNotEquals(team1, team2);
    }

    @Test
    public void different_objects_return_false(){
        Team team1 = new Team("test");
        team1.addMember("test1");
        assertNotEquals(team1, "banana");
    }

    @Test
    public void toString_returns_correct_string() {
        Team team1 = new Team("test");
        team1.addMember("test1");
        assertEquals(team1.toString(), "Team(name=test, members=[test1])");
    }

    @Test
    public void hashCode_is_correct(){
        assertEquals(team.hashCode(), -1226298695);
    }
}
